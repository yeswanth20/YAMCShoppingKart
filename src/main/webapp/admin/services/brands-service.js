angular.module("shopApp").service("brandsService",
	function($http,$q,serviceCallBaseUrl){

		this.getBrands = function(){
			var deferred = $q.defer();
			$http.get(serviceCallBaseUrl+"brands")
			.success(function(data, status, headers, config) {				
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;
		};

		this.createBrand = function(request){
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"brands",request)
			.success(function(data,status,headers,config) {
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;
		};

		this.updateBrand = function(request) {
			var deferred = $q.defer();
			$http.put(serviceCallBaseUrl+"brands",request)
			.success(function(data,status,headers,config) {
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;			
		};

		this.deleteBrand = function(request) {
			var deferred = $q.defer();
			$http.delete(serviceCallBaseUrl+"brands",request)
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