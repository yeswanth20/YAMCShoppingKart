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

	}
);