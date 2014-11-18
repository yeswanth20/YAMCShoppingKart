angular.module("shopApp").service("productsService",
	function($http,$q,serviceCallBaseUrl){

		this.createProduct = function(request){
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"productService/insert",request)
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