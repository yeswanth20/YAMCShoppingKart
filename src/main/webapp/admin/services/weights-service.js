angular.module("shopApp").service("weightsService",
	function($http,$q,serviceCallBaseUrl){

		this.getWeights = function(){
			var deferred = $q.defer();
			$http.get(serviceCallBaseUrl+"weights")
			.success(function(data, status, headers, config) {				
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;
		};

		this.createWeight = function(request){
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"weights",request)
			.success(function(data,status,headers,config) {
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;
		};

		this.updateWeight = function(request) {
			var deferred = $q.defer();
			$http.put(serviceCallBaseUrl+"weights",request)
			.success(function(data,status,headers,config) {
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;			
		};

		this.deleteWeight = function(request) {
			var deferred = $q.defer();
			$http.delete(serviceCallBaseUrl+"weights",request)
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