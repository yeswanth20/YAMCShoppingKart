angular.module("shopApp").controller("weightsController",
	["$scope","weightsService","unitsService",
	function($scope,weightsService,unitsService){

		$scope.weightsList = [];
		$scope.unitsList = {};
		$scope.weightsFormShowFlag = false;
		$scope.weightsFormEditFlag = false;

		$scope.resetWeightsFormData = function() {			
			$scope.weightsFormData = {
				"weightName" : "",
				"weightValue" : "",
				"unit" : "",
				"id" : ""
			}
		}
		$scope.resetWeightsFormData();

		unitsService.getUnits().then(function(result){
			for(unitIndex in result) {
				$scope.unitsList[result[unitIndex].id] = result[unitIndex];
			}
		});

		$scope.initializeWeights = function() {			
			weightsService.getWeights().then(function(weightsResult) {
				$scope.weightsList = weightsResult;
			});
		};

		$scope.initializeWeights();

		$scope.validateWeight = function() {
			if($scope.weightsFormData.weightName.trim()=="") {
				alert("Please enter weight name");
				return false;
			}
			if($scope.weightsFormData.weightValue.trim()=="") {
				alert("Please enter a value");
				return false;
			}
			if($scope.weightsFormData.unit=="") {
				alert("Please select a unit");
				return false;
			}
			return true;
		};

		$scope.createWeight = function() {
			if($scope.validateWeight()) {
				var weightsFormData = {
						"weightName" : $scope.weightsFormData.weightName,
						"weightValue" : $scope.weightsFormData.weightValue,
						"unit" : $scope.weightsFormData.unit					
					};
				weightsService.createWeight(weightsFormData).then(function(result){
					alert("Weight created successfully");
					$scope.resetWeightsFormData();
					$scope.initializeWeights();
					$scope.weightsFormShowFlag = false;
				});
			}
		};

		$scope.editWeight = function(id) {

			var tempWeight = _.where($scope.weightsList,function(rw){
				return rw.id == id;
			});
			console.log(tempWeight);
			if(tempWeight.length>0) {
				$scope.weightsFormData = tempWeight[0];
				$scope.weightsFormShowFlag = true;
				$scope.weightsFormEditFlag = true;
			}			
		}

		$scope.updateWeight = function(id) {		

			if($scope.validateWeight()) {
				weightsService.updateWeight($scope.weightsFormData).then(function(result){
					alert("Weight updated successfully");
					$scope.resetWeightsFormData();
					$scope.initializeWeights();
					$scope.weightsFormShowFlag = false;
					$scope.weightsFormEditFlag = false;
				});	
			}

		}

		$scope.deleteWeight = function(id) {
			if(confirm("Are you sure you want to delete a weight?")) {
				var tempRequest = {"id":id};
				weightsService.deleteWeight(tempRequest).then(function(result)
				{
					alert("Weight delted successfully");
				});
			}
		}

	}
]);