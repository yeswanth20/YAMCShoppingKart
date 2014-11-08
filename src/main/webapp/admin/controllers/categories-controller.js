angular.module("shopApp").controller("categoriesController",
	["$scope","categoriesService",
	function($scope,categoriesService){

		$scope.categoriesList = [];
		$scope.originalCategoriesList = [];
		$scope.categoryEditFlag = false;

		$scope.resetCategoryFormData = function(){			
			$scope.categoryFormData = {
				parentCategory : "",
				rootCategory : "",
				categoryNameEng : "",
				categoryNameTel : "",
				categoryNameHindi : "",
				categoryNameTamil : ""
			};
		}

		$scope.resetCategoryFormData();

		$scope.showCategoryFormFlag = false;

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

		$scope.createCategory = function() {
			if($scope.categoryFormData.id!="") {
				if($scope.categoryFormData.categoryNameEng.trim()=="") {
					alert("Please enter category name");
					return false;
				}
				
				categoriesService.createCategory($scope.categoryFormData).then(function(result){
					alert("Category added successfully");
					$scope.initializeCategories();
					$scope.showCategoryFormFlag = false;
					$scope.resetCategoryFormData();
				});
			}
		};

		$scope.addSubCategory = function(id) {

			$scope.resetCategoryFormData();

			var tempCurrentCategory = _.where($scope.originalCategoriesList,function(rw){
				return rw.id == id;
			});

			if(tempCurrentCategory.length>0) {
				$scope.currentCategoryName = tempCurrentCategory[0].categoryNameEng;
				$scope.categoryFormData.parentCategory = id;
				
				if(tempCurrentCategory[0].rootCategory != "")
				{
					$scope.categoryFormData.rootCategory = tempCurrentCategory[0].rootCategory;
				} else {
					$scope.categoryFormData.rootCategory = id;
				}
			}
			else
			$scope.currentCategoryName = false;

			$scope.showCategoryFormFlag = true;
		};

		$scope.editCategory = function(id) {
			var tempCurrentCategory = _.where($scope.originalCategoriesList,function(rw){
				return rw.id == id;
			});
			$scope.categoryFormData = tempCurrentCategory[0];
			console.log($scope.categoryFormData);
			$scope.showCategoryFormFlag = true;
			$scope.categoryEditFlag = true;
		};

		$scope.updateCategory = function() {
			categoriesService.updateCategory($scope.categoryFormData).then(function(result){
				alert("Category updated successfully");
			});
		}

		$scope.deleteCategory = function(id) {
			if(confirm("Are you sure you want to delete the category?")) {
				var deleteRequest = {"id":id};
				categoriesService.deleteCategory(deleteRequest).then(function(result){
					alert("Category deleted successfully");
					$scope.initializeCategories();
				});
			}
		}

		$scope.newSubItem = function(scope) {
	      var nodeData = scope.$modelValue;
	      nodeData.nodes.push({
	        id: nodeData.id * 10 + nodeData.nodes.length,
	        title: nodeData.title + '.' + (nodeData.nodes.length + 1),
	        items: []
	      });
	    };
	}
]);