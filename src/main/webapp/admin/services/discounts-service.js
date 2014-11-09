angular.module("shopApp").service("discountsService",
	function($http,$q,serviceCallBaseUrl){

		this.getDiscounts = function(){
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"discountTypeService/getAll")
			.success(function(data, status, headers, config) {				
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;
		};

		this.createDiscount = function(request){
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"discountTypeService/insert",request)
			.success(function(data, status, headers, config) {				
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;
		};

		this.updateDiscount = function(request) {
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"discountTypeService/update",request)
			.success(function(data,status,headers,config) {
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;			
		};

		this.deleteDiscount = function(request) {
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"discountTypeService/delete",request)
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