angular.module("shopApp").service("usersService",
	function($http,$q,serviceCallBaseUrl){
		
		this.getUsers = function(){
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"usersService/getAll")
			.success(function(data, status, headers, config) {				
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;
		};

		this.createUsers = function(request){
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"usersService/insert",request)
			.success(function(data,status,headers,config) {
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;
		};

		this.updateUsers = function(request) {
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"usersService/update",request)
			.success(function(data,status,headers,config) {
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;			
		};

		this.deleteUsers = function(request) {
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"usersService/delete",request)
			.success(function(data,status,headers,config) {
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;			
		};
	}
);