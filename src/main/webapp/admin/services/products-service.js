angular.module("shopApp").service("productsService",
	function($http,$q,serviceCallBaseUrl){

		this.createProduct = function(request){
			var deferred = $q.defer();

			$http({
			    url: serviceCallBaseUrl+"productService/insert",			    
			    method: "POST",
			    data: request,
			}).success(function(response){
			    deferred.resolve(response);
			}).error(function(error){
			    deferred.reject(error);
			});
			
  			return deferred.promise;
		};

		this.getProducts = function(){
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"productService/getAll")
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