# API Management Platform

El objetivo de este proyecto es integrar tecnologias y realizar una prueba de concepto de exposicion y securitizacion de APIs.

Para instalar seguir la siguiente guia.

Descarga del codigo fuente:
```
$ git clone https://github.com/sgalvez/PTII.git

$ cd PTII/datastore
$ docker build -t datastore .
$ docker run -p 3306:3306 datastore

$ cd PTII/airportsRest
$ mvn clean package docker:build
$ docker run -it --name airportsrest --link datastore:mysql -p 8080:8080 ptii/airportrest

$ cd PTII/apiPortal
$ docker build -t portal .
$ docker run --name portal -p 8080:8080 portal
```

Instalacion del Gateway de APIs Kong:

```
$ docker run -d --name kong-database -p IP_INTERNA:9042:9042 cassandra:2.2

$ docker run -d --name kong -e "KONG_DATABASE=cassandra" -e "KONG_CASSANDRA_CONTACT_POINTS=IP_CASSANDRA:9042" 
-e "KONG_PG_HOST=HOST_CASANDRA" -p IP_INTERNA:8000:8000 -p IP_INTERNA:8443:8443 -p IP_INTERNA:8001:8001 
-p IP_INTERNA:7946:7946 -p IP_INTERNA:7946:7946/udp kong
```

Registro de la API Operacional en el Gataway
```
$ curl -i -X POST --url http://ADMIN_API_IP:8001/apis --data 'name=admin’ --data 'upstream_url=http://ADMIN_API_IP:8001' --data 'uris=/admin'
```

Agregar autenticacion Basica a la API:
```
$ curl -X POST http://ADMIN_API_IP:8001/apis/admin/plugins --data "name=basic-auth" --data "config.hide_credentials=true"
```

Crear un usuario administrador
```
$ curl -i -X POST --url http://ADMIN_API_IP:8001/consumers/ --data "username=administrator"

$ curl -i -X POST --url http://ADMIN_API_IP:8001/consumers/administrator/basic-auth/ --data 'username=administrator' --data 'password=bWF0aWFzCg=='
````




