angular.module("shopApp").controller("unitsController",
	["$scope","unitsService",
	function($scope,unitsService){

		$scope.unitsList = [];
		$scope.unitsFormDisplayFlag = false;
		$scope.unitEditFlag = false;

		$scope.intalizeUnitsFormData = function() {			
			$scope.unitFormData = {
				unitName : ""
			}
		}
		$scope.intalizeUnitsFormData();

		$scope.intalizeUnits = function() {
			unitsService.getUnits().then(function(result){
				$scope.unitsList = result;
			});
		}

		$scope.intalizeUnits();

		$scope.createUnit = function(){
			if($scope.unitFormData.unitName=="") {
				alert("Please enter unit name");
				return false;
			}
			unitsService.postUnits($scope.unitFormData).then(function(result){
				alert("Unit created successfully");
				$scope.intalizeUnits();
				$scope.unitsFormDisplayFlag = false;
				$scope.intalizeUnitsFormData();
			});
		}

		$scope.editUnit = function(id) {
			$scope.intalizeUnitsFormData();
			var tempUnit = _.where($scope.unitsList,function(rw){
				return rw.id == id;
			});
			if(tempUnit.length>0) {
				$scope.unitFormData = tempUnit[0];
				$scope.unitsFormDisplayFlag = true;
				$scope.unitEditFlag = true;
			}
		};

		$scope.updateUnit = function() {
			if($scope.unitFormData.unitName=="") {
				alert("Please enter unit name");
				return false;
			}
			unitsService.putUnits($scope.unitFormData).then(function(result){
				alert("Unit updated successfully");
				$scope.intalizeUnits();
				$scope.unitsFormDisplayFlag = false;
			});	
		};

		$scope.deleteUnit = function(id) {
			if(confirm("Are you sure you want to delete unit?")) {
				var tempRequest = {"id":id};
				unitsService.deleteUnits(tempRequest).then(function(result){
					alert("Unit deleted successfully");
				});
			}
		}

	}
]);