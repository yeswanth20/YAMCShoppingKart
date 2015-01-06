angular.module("shopApp").controller("loginController",
	["$scope","$rootScope","homeService",
	function($scope,$rootScope,homeService){
		
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
			homeService.registerUser($scope.registrationFormData).then(function(result){
				if(result.id!=0)
				{
					var tempRequest = {
						userName : $scope.registrationFormData.userName,
						password : $scope.registrationFormData.password
					}
					homeService.loginService(tempRequest).then(function(loginResult){
						tempRequest.userId = result.id;
						$rootScope.$broadcast("loggedIn",tempRequest);
						$state.go("orderconformation");
					});
				}
			});
		}

		$scope.loginFormData = {
			"userName" : "",
			"password" : ""
		};

		$scope.loginUser = function(){
			homeService.loginService($scope.loginFormData).then(function(loginResult){
				$scope.loginFormData.userId = result.id;
				$rootScope.$broadcast("loggedIn",$scope.loginFormData);
				$state.go("orderconformation");
			});
		}

	}
]);