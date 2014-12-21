angular.module("shopApp").controller("homeController",
	["$scope","homeService",
	function($scope,homeService){

		var categoriesList = {};		

		$scope.initializeCategories = function() {
			var finalCategoriesList = [];
			homeService.getCategories().then(function(categoriesList){			
				var categoriesCounter = 1;
				$scope.originalCategoriesList = categoriesList;
				if(categoriesList.length==0) {
					$scope.showCategoryFormFlag = true;
				}

				var rootCateogies  = _.where(categoriesList, function(rw){
					return rw.parentCategory == 0;
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

		$scope.initializeCategories();		

		homeService.getUnits().then(function(result){
			$scope.unitsList = result;
			homeService.getWeights().then(function(weights){
				$scope.weightsList = weights;
				homeService.getProducts().then(function(products){
					$scope.productsList = [];

					for (var index in products) {
						products[index].unitName = _.find($scope.unitsList,function(rw){
							return rw.id == products[index].unit;
						});
						$scope.productsList.push(products[index]);
					};
				});
			});
		});

		$scope.addToCart = function(id) {
			var tempProduct = _.find($scope.productsList,function(rw){
				return rw.id == id;
			});
			var cartProduct = {
				id : id,
				unit : $("#productunit"+id).val(),
				quantity : $("#productquantity"+id).val()
			}
			var cartProducts = [];
			cartProducts = getCookie("shopAppCartProducts");			
			cartProducts.push(cartProduct);

			setCookie("shopAppCartProducts",cartProducts);		
		};

	}
]);