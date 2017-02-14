
var path = require('path');
var koa = require('koa');
var koa_auth = require('koa-basic-auth');
var addSlashes = require('koa-add-trailing-slashes');
var mount = require('koa-mount');
var serve = require('koa-static');
var auth = require('basic-auth');
var httpProxy = require('http-proxy');
var url_parser = require('url');

var name = process.env['kong-dashboard-name'];
var pass = process.env['kong-dashboard-pass'];

var webapp = koa();

webapp.use(function *(next){
  yield next;

  this.set('X-Frame-Options', 'Deny');
});

webapp.use(function *(next){
  try {
    yield next;
  } catch (err) {
    if (401 == err.status) {
      this.status = 401;
      this.set('WWW-Authenticate', 'Basic');
      this.body = 'Autenticacion Requerida';
    } else {
      throw err;
    }
  }
});

if (name && pass) {
  webapp.use(koa_auth({ name: name, pass: pass }));
}

webapp.use(serve(path.join(__dirname, '../public')));

var proxyapp = koa();
var proxy = httpProxy.createProxyServer({
  proxyTimeout: 3000
});

proxyapp.use(function *(next){
  if (this.request.method !== 'OPTION' && name && pass) {
    var user = auth(this);
    if (user && user.name == name && user.pass == pass) {
      yield next;
    } else {
      this.throw(401);
    }
  } else {
    yield next;
  }
});

proxyapp.use(function *(next){

  var ctx = this;

  if (!ctx.request.headers['kong-node-url']) {
    ctx.body = "Kong-Node-URL header is required";
    ctx.throw(400);
  }

  var proxied_req = ctx.req;

  proxied_req.headers['host'] = url_parser.parse(ctx.request.headers['kong-node-url']).host;
  if (ctx.request.headers['x-kong-authorization']) {
    proxied_req.headers['authorization'] = ctx.request.headers['x-kong-authorization'];
  } else {
    delete proxied_req.headers['authorization'];
  }

  yield new Promise(function (resolve, reject) {
    proxy.web(proxied_req, ctx.res, {target: ctx.request.headers['kong-node-url']});
  });
});

proxy.on('proxyRes', function(proxyRes, req, res) {
  if (proxyRes.statusCode == 401) {
    proxyRes.statusCode = 511;
  }
  if (proxyRes.statusCode == 302 || proxyRes.statusCode == 301) {
    proxyRes.statusCode = 404;
  }
});

proxy.on('error', function(err, req, res) {
  if (err.code == 'ECONNRESET' || err.code == 'ECONNREFUSED' || err.code == 'ENOTFOUND') {
    res.writeHead(400, {
      'Content-Type': 'application/json'
    });
    res.end('{"message": "Cant connect to Kong server."}');
  } else {
    console.log(err);
    res.writeHead(500, {
      'Content-Type': 'application/json'
    });
    res.end('{"message": "Sorry, something went wrong..."}');
  }
});

var app = koa();
app.use(addSlashes());
app.use(mount('/', webapp));
app.use(mount('/proxy', proxyapp));

app.listen(process.env['kong-dashboard-port']);

console.log('Server is runding on port ' + process.env['kong-dashboard-port']);
