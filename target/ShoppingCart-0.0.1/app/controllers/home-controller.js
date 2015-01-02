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

		var tempProducts = getCookie("shopAppCartProducts");
		if(tempProducts!="")
		$scope.cartProducts = JSON.parse(tempProducts);
		else
		$scope.cartProducts = [];
		
		for(index in $scope.cartProducts) {
			console.log(index+":::"+$scope.cartProducts[index]);
		}

		homeService.getUnits().then(function(result){
			$scope.unitsList = result;
			homeService.getWeights().then(function(weights){
				$scope.weightsList = weights;
				homeService.getProducts().then(function(products){
					$scope.productsList = [];

					for (var index in products) {
						for(var prodex in products[index].productUnitDetails)
						{
							var tempProduct = _.find($scope.unitsList,function(rw){
								return rw.id == products[index].productUnitDetails[prodex].unit;
							});
							products[index].productUnitDetails[prodex].unitName = tempProduct.unitName;
						}
						if($scope.cartProducts.hasOwnProperty(products[index].id))
						{
							products[index].inCartFlag = true;							
							products[index].inCartQuantity = $scope.cartProducts[products[index].id].inCartQuantity;	
							products[index].inCartUnit = $scope.cartProducts[products[index].id].inCartUnit;
						} else {							
							products[index].inCartFlag = false;
						}
						$scope.productsList.push(products[index]);
					};					

				});
			});
		});

		$scope.addToCart = function(id) {
			var tempProduct = _.find($scope.productsList,function(rw){
				return rw.id == id;
			});

			var cartProduct = tempProduct;
			cartProduct.id = id;
			cartProduct.inCartUnit = $("#productunit"+id).val();
			cartProduct.inCartQuantity = $("#productquantity"+id).val();

			/*var tempDiscount = _.find(tempProduct.productUnitDetails,function(rw){
				return rw.unit == cartProduct.inCartUnit;
			});
			cartProduct.discountPercentage = tempDiscount.di*/

			var cartProducts = getCookie("shopAppCartProducts");
			if(cartProducts=="undefined");
			cartProducts = {};
			cartProducts[id] = cartProduct;

			setCookie("shopAppCartProducts",JSON.stringify(cartProducts));

			var tempProductIndex = $scope.productsList.indexOf(tempProduct);
			
			$scope.productsList[tempProductIndex].inCartFlag = true;
			$scope.productsList[tempProductIndex].inCartQuantity = $("#productquantity"+id).val();
			$scope.productsList[tempProductIndex].inCartUnit = $("#productunit"+id).val();
			
		};


		homeService.getBrands().then(function(result){
			$scope.brandsList = result;
		});

		$scope.reduceCartCount = function(id) {

			var cartProducts = JSON.parse(getCookie("shopAppCartProducts"));
			var tempProduct = _.find($scope.productsList,function(rw){
				return rw.id == id;
			});
			var tempProductIndex = $scope.productsList.indexOf(tempProduct);
			cartProducts[id].inCartQuantity--;
			$scope.productsList[tempProductIndex].inCartQuantity--;

			if (cartProducts[id].inCartQuantity==0) {
				$scope.productsList[tempProductIndex].inCartFlag = false;
				delete cartProducts[id];
			}
			setCookie("shopAppCartProducts",JSON.stringify(cartProducts));
		};

		$scope.increaseCartCount = function(id) {
			var cartProducts = JSON.parse(getCookie("shopAppCartProducts"));
			var tempProduct = _.find($scope.productsList,function(rw){
				return rw.id == id;
			});
			var tempProductIndex = $scope.productsList.indexOf(tempProduct);
			cartProducts[id].inCartQuantity++;
			$scope.productsList[tempProductIndex].inCartQuantity++;
			setCookie("shopAppCartProducts",JSON.stringify(cartProducts));
		};

	}
]);