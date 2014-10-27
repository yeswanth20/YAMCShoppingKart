angular.module('shopApp').service('unitsService',
	function($http,$q,$rootScope,serviceCallBaseUrl) {

		var unitsList = [];

		this.getUnits = function() {
			var deferred = $q.defer();
			if(unitsList.length>0) {				
				deferred.resolve(unitsList);
			}
			else {
				$http.get(serviceCallBaseUrl+"units")
				.success(function(data, status, headers, config) {				
					deferred.resolve(data);
				}).
	  			error(function(data, status, headers, config) {
					deferred.reject(data);
	  			});
	  		}
  			return deferred.promise;
		};

		this.postUnits = function(request) {
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"units",request)
			.success(function(data,status,headers,config) {
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
			return deferred.promise;
		};

		this.putUnits = function(request) {
			var deferred = $q.defer();
			$http.put(serviceCallBaseUrl+"units",request)
			.success(function(data,status,headers,config) {
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
			return deferred.promise;
		};

		this.deleteUnits = function(request) {
			var deferred = $q.defer();
			$http.delete(serviceCallBaseUrl+"units",request)
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