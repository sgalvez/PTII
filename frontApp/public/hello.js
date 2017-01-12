angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:8000/airports/getCity?airportCode=SCL').
        then(function(response) {
            $scope.greeting = response.data;
        });
});
