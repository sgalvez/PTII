angular.module('app').controller("ApiController", ["$scope", "Kong", "$location", "$routeParams", "Alert", "api", function ($scope, Kong, $location, $routeParams, Alert, api) {
    if ($routeParams.id) {
        $scope.api = api;
        $scope.title = "Editar una API";
        $scope.action = "Guardar";
    } else {
        $scope.title = "Agregar una API";
        $scope.action = "Crear";
    }

    $scope.save = function () {
        Kong.put('/apis', $scope.api).then(function () {
            if ($routeParams.id) {
                Alert.success('Api actualizada');
            } else {
                Alert.success('Api creada');
                // clearing inputs.
                $scope.api = {};
            }
            // clearing errors.
            $scope.error = {};
        }, function (response) {
            $scope.error = response.data;
        });
    }
}]);
