angular.module("shopApp").controller("brandsController",
	["$scope","brandsService",
	function($scope,brandsService){

		$scope.brandsList = [];
		$scope.brandsFormShowFlag = false;
		$scope.brandsFormEditFlag = false;

		$scope.resetBrandsFormData = function() {			
			$scope.brandsFormData = {
				"id" : "",
				"brandNameEng" : "",
				"brandNameHindi" : "",
				"brandNameTel" : "",
				"brandNameTamil" : "",
			}
		}
		$scope.resetBrandsFormData();

		$scope.initializeBrands = function() {
			brandsService.getBrands().then(function(brandsResult) {
				$scope.brandsList = brandsResult;
			});
		};

		$scope.initializeBrands();

		$scope.createBrand = function() {
			if($scope.brandsFormData.brandNameEng.trim()=="") {
				alert("Please enter brand name");
				return false;
			}
			var brandsFormData ={
					"brandNameEng" : $scope.brandsFormData.brandNameEng,
					"brandNameHindi" : $scope.brandsFormData.brandNameHindi,
					"brandNameTel" : $scope.brandsFormData.brandNameTel,
					"brandNameTamil" : $scope.brandsFormData.brandNameTamil,
				};
			
			brandsService.createBrand(brandsFormData).then(function(result){
				alert("Brand created successfully");
				$scope.resetBrandsFormData();
				$scope.initializeBrands();
				$scope.brandsFormShowFlag = false;
			});
		};

		$scope.editBrand = function(id) {
			var tempBrand = _.where($scope.brandsList,function(rw){
				return rw.id == id;
			});
			if(tempBrand.length>0) {
				$scope.brandsFormData = tempBrand[0];
				$scope.brandsFormShowFlag = true;
				$scope.brandsFormEditFlag = true;
			}			
		}

		$scope.updateBrand = function(id) {		

			if($scope.brandsFormData.brandNameEng.trim()=="") {
				alert("Please enter brand name");
				return false;
			}			
			brandsService.updateBrand($scope.brandsFormData).then(function(result){
				alert("Brand updated successfully");
				$scope.resetBrandsFormData();
				$scope.initializeBrands();
				$scope.brandsFormShowFlag = false;
				$scope.brandsFormEditFlag = false;
			});	

		}

		$scope.deleteBrand = function(id) {
			if(confirm("Are you sure you want to delete a brand?")) {
				var tempRequest = {"id":id};
				brandsService.deleteBrand(tempRequest).then(function(result)
				{
					alert("Brand delted successfully");
				});
			}
		}

	}
]);