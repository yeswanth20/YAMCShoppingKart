angular.module("shopApp").controller("loginController",
	["$scope","homeService",
	function($scope,homeService){
		alert("hiii");
		$scope.registrationFormData = {
			"userName" : "",
			"password" : "",
			"emailId" : "",
			"mobile" : "",
			"address" : {
				"houseNumber" : "",
				"street" : "",
				"area" : "",
				"landmark" : "",
				"city" : "",
				"pincode" : "",
				"landlineNumber" : ""
			}
		};

		$scope.registerUser = function(){
			homeService.registerUser($scope.registrationFormData);
		}

	}
]);