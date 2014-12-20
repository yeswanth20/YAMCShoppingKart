angular.module("shopApp").controller("discountsController",
	["$scope","discountsService",
	function($scope,discountsService){

		$scope.discountsList = [];
		$scope.discountsFormShowFlag = false;
		$scope.discountsFormEditFlag = false;

		$scope.resetDiscountsFormData = function() {			
			$scope.discountsFormData = {
				"id" : "",
				"discountName" : "",
			}
		}
		$scope.resetDiscountsFormData();

		$scope.initializeDiscounts = function() {
			discountsService.getDiscounts().then(function(discountsResult) {
				$scope.discountsList = discountsResult;
			});
		};

		$scope.initializeDiscounts();

		$scope.createDiscount = function() {
			if($scope.discountsFormData.discountName.trim()=="") {
				
				alert("Please enter disount name");
				return false;
			}	
			var discountsFormData = {
					"discountName" : $scope.discountsFormData.discountName,
			}
			discountsService.createDiscount(discountsFormData).then(function(result){
				alert("Discount created successfully");
				$scope.resetDiscountsFormData();
				$scope.initializeDiscounts();
				$scope.discountsFormShowFlag = false;
			});
		};

		$scope.editDiscount = function(id) {
			var tempDiscount = _.where($scope.discountsList,function(rw){
				return rw.id == id;
			});
			if(tempDiscount.length>0) {
				$scope.discountsFormData = tempDiscount[0];
				$scope.discountsFormShowFlag = true;
				$scope.discountsFormEditFlag = true;
			}			
		}

		$scope.updateDiscount = function(id) {

			if($scope.discountsFormData.discountName.trim()=="") {
				alert("Please enter discount name");
				return false;
			}			
			discountsService.updateDiscount($scope.discountsFormData).then(function(result){
				alert("Discount updated successfully");
				$scope.resetDiscountsFormData();
				$scope.initializeDiscounts();
				$scope.discountsFormShowFlag = false;
				$scope.discountsFormEditFlag = false;
			});	

		}

		$scope.deleteDiscount = function(id) {
			if(confirm("Are you sure you want to delete a discount?")) {
				var tempRequest = {"id":id};
				discountsService.deleteDiscount(tempRequest).then(function(result)
				{
					alert("Discount delted successfully");
				});
			}
		}

	}
]);