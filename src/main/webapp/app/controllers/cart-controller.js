angular.module("shopApp").controller("cartController",
	["$scope","homeService",
	function($scope,homeService){
		
		var tempProducts = getCookie("shopAppCartProducts");
		if(tempProducts!="")
		$scope.cartProducts = JSON.parse(tempProducts);
		else
		$scope.cartProducts = [];

	}
]);