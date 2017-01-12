angular.module('demo', [])
.controller('Hello', function($scope, $http) {
  //  $http.get('http://vdocker:8000/airports/getCity?airportCode=SCL').
 $http.get('http://rest-service.guides.spring.io/greeting').
        then(function(response) {
            $scope.greeting = response.data;
        });
});
