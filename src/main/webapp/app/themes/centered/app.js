angular.module('shopApp', ['ui.bootstrap','ui.tree']);
angular.module("shopApp").controller("appController",
	["$scope",
	function($scope){

		$scope.categoriesList = [];
		$scope.originalCategoriesList = [];
		$scope.categoryEditFlag = false;

		var categoriesList = [
			{
				"id" : "1",
				"parentId" : "1",
				"rootCategoryId" : "1",
				"categoryNameEng" : "Household",
				"categoryNameTel" : "Sarukulu",	
				"categoryNameHindi" : "Sarukulu",
				"categoryNameTamil" : "Sarukulu"
			},
			{
				"id" : "2",
				"parentId" : "1",
				"rootCategoryId" : "1",
				"categoryNameEng" : "electricaldd",
				"categoryNameTel" : "Sarukulu",
				"categoryNameHindi" : "Sarukulu",
				"categoryNameTamil" : "Sarukulu"
			},
			{
				"id" : "3",
				"parentId" : "2",
				"rootCategoryId" : "1",
				"categoryNameEng" : "safe",
				"categoryNameTel" : "Sarukulu",
				"categoryNameHindi" : "Sarukulu",
				"categoryNameTamil" : "Sarukulu"
			},
			{
				"id" : "4",
				"parentId" : "4",
				"rootCategoryId" : "1",
				"categoryNameEng" : "electricaldd",
				"categoryNameTel" : "Sarukulu",
				"categoryNameHindi" : "Sarukulu",
				"categoryNameTamil" : "Sarukulu"
			},
			{
				"id" : "5",
				"parentId" : "4",
				"rootCategoryId" : "1",
				"categoryNameEng" : "safe",
				"categoryNameTel" : "Sarukulu",
				"categoryNameHindi" : "Sarukulu",
				"categoryNameTamil" : "Sarukulu"
			}
		];

		$scope.resetCategoryFormData = function(){			
			$scope.categoryFormData = {
				parentId : 0,
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
			var categoriesCounter = 1;
			$scope.originalCategoriesList = categoriesList;
			if(categoriesList.length==0) {
				$scope.showCategoryFormFlag = true;
			}

			var rootCateogies  = _.where(categoriesList, function(rw){
				return rw.id == rw.parentId;
			});

			for(var rootIndex in rootCateogies) {
				finalCategoriesList[rootIndex] = {};
				finalCategoriesList[rootIndex].id = rootCateogies[rootIndex].id;
				finalCategoriesList[rootIndex].name = rootCateogies[rootIndex].categoryNameEng;
				finalCategoriesList[rootIndex].nodes = $scope.buildRecursiveTree(rootCateogies[rootIndex].id,categoriesList);
			}			
			$scope.categoriesList = finalCategoriesList;
		};

		

		$scope.buildRecursiveTree = function(parentId,categoriesList) {

			var rootCateogies  = _.where(categoriesList, function(rw){
				return rw.parentId == parentId && rw.id!=parentId;
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