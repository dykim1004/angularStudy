angular.module("store", ["customFilters", "cart", "ngRoute"])
.config(function ($routeProvider){
	
	$routeProvider.when("/complete", {
		templateUrl: "views/thankYou.html"
	});
	
	$routeProvider.when("/placeorder", {
		templateUrl: "views/placeOrder.html"
	});
	
	$routeProvider.when("/checkout", {
		templateUrl : "views/checkoutSummary.html"
	});
	
	$routeProvider.when("/products", {
		templateUrl: "views/productList.html"
	});
	
	$routeProvider.otherwise({
		templateUrl : "views/productList.html"
	});
	
})
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
