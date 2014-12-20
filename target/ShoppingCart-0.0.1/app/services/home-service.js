angular.module("shopApp").service("homeService",
	function($http,$q,serviceCallBaseUrl){
		
		this.getCategories = function(){
			var deferred = $q.defer();
			var categoriesServiceList = {};
			$http.post(serviceCallBaseUrl+"categoryService/getAll")
			.success(function(data, status, headers, config) {				
				categoriesServiceList = data;
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
	  		
  			return deferred.promise;
		};

		this.getUnits = function() {
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"unitService/getAll")
			.success(function(data, status, headers, config) {				
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;
		};

		this.getWeights = function(){
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"weightService/getAll")
			.success(function(data, status, headers, config) {				
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;
		};

	}
);