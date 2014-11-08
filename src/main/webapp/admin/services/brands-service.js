angular.module("shopApp").service("brandsService",
	function($http,$q,serviceCallBaseUrl){

		this.getBrands = function(){
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"brandService/getAll")
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
			$http.post(serviceCallBaseUrl+"brandService/insert",request)
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
			$http.post(serviceCallBaseUrl+"brandService/update",request)
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
			$http.post(serviceCallBaseUrl+"brandService/delete",request)
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