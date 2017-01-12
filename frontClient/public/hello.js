angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://vdocker1:8000/airports?apikey=87b9175460234cb3a941f559d37f5667').
        then(function(response) {
            //$scope.greeting = response.data;
            angular.forEach(response.data._embedded.airports, function(value, key) {
                console.log(value.cityname);
                angular.element(document.querySelector('#airport-select')).append("<option value="+value.airportcode+">"+value.cityname+"</option>");
            });
        });
});
