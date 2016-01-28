angular.module("store", ["customFilters"])
.constant("dataUrl","http://localhost:8080/products")
.controller("storeCtrl", function($scope, $http, dataUrl) {

	$scope.data = {};
	$http.get(dataUrl)
    .success(function (data) {
        $scope.data.products = data;
    })
    .error(function (error) {
        $scope.data.error = error;
    });
});
