angular.module("storeAdmin")
.constant("authUrl", "http://localhost:8080/users/login")
.constant("ordersUrl", "http://localhost:8080/orders")
.controller("authCtrl", function($scope, $http, $location, authUrl){
	
	$scope.authenticate = function (user, pass){
		$http.post(authUrl, {
			username: user,
			password: pass
		}, {
			withCredentials: true
		}).success(function(data){
			$location.path("/main");
		}).error(function(error){
			$scope.authenticationError = error;
		});
	}
})
.controller("mainCtrl", function($scope){
	$scope.screens = ["Products", "Orders"];
    $scope.current = $scope.screens[0];

    $scope.setScreen = function (index) {
        $scope.current = $scope.screens[index];
    };

    $scope.getScreen = function () {
        return $scope.current == "Products"
            ? "/views/adminProducts.html" : "/views/adminOrders.html";
    };
})
.controller("ordersCtrl", function($scope, $http, ordersUrl){
	
	$http.get(ordersUrl)
		.success(function(data){
			$scope.orders = data;
		})
		.error(function (error){
			$scope.error = error;
		});
	
	$scope.selectedOrder;
	
	// 주문상세정
	$scope.selectOrder = function(order){
		$scope.selectedOrder = order;
	}
	
	// 주문한 상품의 전체 가
	$scope.calcTotal = function(order){
		var total = 0;
		for(var i=0; i < order.products.length; i++){
			total += orders.products[i].count * order.products[i].price;
		}
		return total;
	}
	
});