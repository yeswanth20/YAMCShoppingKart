angular.module("shopApp").service("categoriesService",
	function($http,$q,serviceCallBaseUrl){

		var categoriesServiceList = [];

		this.getCategories = function(){
			var deferred = $q.defer();
			if(categoriesServiceList.length>0)				
			{
				deferred.resolve(categoriesServiceList);
			}
			else {
				$http.get(serviceCallBaseUrl+"categories")
				.success(function(data, status, headers, config) {				
					categoriesServiceList = data;
					deferred.resolve(data);
				}).
	  			error(function(data, status, headers, config) {
					deferred.reject(data);
	  			});
	  		}
  			return deferred.promise;
		};

		this.createCategory = function(request){
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"categories",request)
			.success(function(data,status,headers,config) {
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;
		};

		this.updateCategory = function(request) {
			var deferred = $q.defer();
			$http.put(serviceCallBaseUrl+"categories",request)
			.success(function(data,status,headers,config) {
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;			
		};

		this.deleteCategory = function(request) {
			var deferred = $q.defer();
			$http.delete(serviceCallBaseUrl+"categories",request)
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