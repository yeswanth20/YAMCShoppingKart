angular.module("shopApp").controller("productsController",
	["$scope","categoriesService","unitsService","weightsService","brandsService","discountsService","productsService",
	function($scope,categoriesService,unitsService,weightsService,brandsService,discountsService,productsService){

		/*
		{ "productNameHindi": "Product HINDI",
							    "productNameTel": "Product TELUGU",
							    "productNameTamil": "Product TAMIL",
							    "brand": 151,
							    "productNameEng": "Product ENGLISH",
							    "productUnitDetails": [{
							                            "unit" : 90,
							                            "weight": 10,
							                            "discountType":180,
							                            "discountValue": 123,
							                            "price":122
														},
														{
														second child details if present
														}
							                          ],
							    "stockAvailable": true
							}
		*/

		$scope.productsFormShowFlag = false;

		$scope.productFormData = {
			"productNameHindi" : "",
			"productNameTel" : "",
			"productNameTamil" : "",
			"productNameEng" : "",
			"brand" : "",
			"productUnitDetails" : []
		};

		$scope.productsList = [];

		$scope.initializeCategories = function() {
			var finalCategoriesList = [];
			categoriesService.getCategories().then(function(categoriesList){			
				var categoriesCounter = 1;
				$scope.originalCategoriesList = categoriesList;
				if(categoriesList.length==0) {
					$scope.showCategoryFormFlag = true;
				}

				var rootCateogies  = _.where(categoriesList, function(rw){
					return rw.id == rw.parentCategory;
				});

				for(var rootIndex in rootCateogies) {
					finalCategoriesList[rootIndex] = {};
					finalCategoriesList[rootIndex].id = rootCateogies[rootIndex].id;
					finalCategoriesList[rootIndex].name = rootCateogies[rootIndex].categoryNameEng;
					finalCategoriesList[rootIndex].nodes = $scope.buildRecursiveTree(rootCateogies[rootIndex].id,categoriesList);
				}			
				$scope.categoriesList = finalCategoriesList;
			});
		};

		$scope.initializeCategories();

		$scope.buildRecursiveTree = function(parentCategory,categoriesList) {

			var rootCateogies  = _.where(categoriesList, function(rw){
				return rw.parentCategory == parentCategory && rw.id!=parentCategory;
			});

			if(rootCateogies.length>0)
			{
				var tempCategoriesList = [];
				for(var rootIndex in rootCateogies) {
					tempCategoriesList[rootIndex] = {};
					tempCategoriesList[rootIndex].id = rootCateogies[rootIndex].id;
					tempCategoriesList[rootIndex].name = rootCateogies[rootIndex].categoryNameEng;
					tempCategoriesList[rootIndex].nodes = $scope.buildRecursiveTree(rootCateogies[rootIndex].id,categoriesList);
				}
				return tempCategoriesList;
			}
			else
			{
				return [];
			}

		};
		
		unitsService.getUnits().then(function(result){
			$scope.unitsList = result;
		});

		weightsService.getWeights().then(function(result){
			$scope.weightsList = result;
		});

		brandsService.getBrands().then(function(result){
			$scope.brandsList = result;
		});

		discountsService.getDiscounts().then(function(result){
			$scope.discountsList = result;
		});

		productsService.getProducts().then(function(result){
			$scope.productsList = result;
		});
		
		$scope.addUnitsRows = function(){
			$scope.productFormData.productUnitDetails[$scope.productFormData.productUnitDetails.length] = {
				"unit" : "",
				"weight" : "",
				"discountType" : "",
				"discountValue" : "",
				"price" : ""
			};
		};
		$scope.addUnitsRows();

		$scope.removeUnitRow = function(id) {
			$scope.productFormData.productUnitDetails.splice(id,1);		
		}

		$scope.createProduct = function() {
			if(document.getElementById("productImageUpload").files.length!=0)
			{
				var fileObj = new FileReader();
	            fileObj.onload = function()
	            {
	                //xhr.send("file1=" + fileObj.result); //Send to server
	                $scope.productFormData.productImage = fileObj.result.split(",")[1];
					$scope.submitProduct();
	            }
	            fileObj.readAsDataURL(document.getElementById("productImageUpload").files[0]);
	        }
	        else {
	        	$scope.submitProduct();
	        }
		};

		$scope.submitProduct = function() {
			productsService.createProduct($scope.productFormData).then(function(result){

			});
		}

		$scope.unitChanged = function(unitIndex) {

			$scope.productFormData.productUnitDetails[unitIndex].weight = "";

		};

		$scope.editProduct = function(productId) {
			var tempProduct = _.where($scope.productsList,function(rw){
				return rw.id == productId;
			});
			console.log(tempProduct);
			if(tempProduct.length>0) {
				console.log(tempProduct[0]);
				$scope.productFormData = tempProduct[0];
				console.log($scope.productFormData);
				$scope.productsFormShowFlag = true;
				$scope.productsFormEditFlag = true;
			}		
		}

	}
]);