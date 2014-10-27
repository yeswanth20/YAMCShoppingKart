angular.module('shopApp').directive('header', 
	['$rootScope',
	function($rootScope){	
		return {
	        templateUrl: themeBasePath+"/header.html",
	        link : function($scope,element) {
	        	
	        	$scope.data = [
				  {
				    "id": 1,
				    "title": "node1",
				    "nodes": [
				      {
				        "id": 11,
				        "title": "node1.1",
				        "nodes": [
				          {
				            "id": 111,
				            "title": "node1.1.1",
				            "nodes": []
				          }
				        ]
				      },
				      {
				        "id": 12,
				        "title": "node1.2",
				        "nodes": []
				      }
				    ]
				  },
				  {
				    "id": 2,
				    "title": "node2",
				    "nodes": [
				      {
				        "id": 21,
				        "title": "node2.1",
				        "nodes": []
				      },
				      {
				        "id": 22,
				        "title": "node2.2",
				        "nodes": []
				      }
				    ]
				  },
				  {
				    "id": 3,
				    "title": "node3",
				    "nodes": [
				      {
				        "id": 31,
				        "title": "node3.1",
				        "nodes": []
				      }
				    ]
				  },
				  {
				    "id": 4,
				    "title": "node4",
				    "nodes": [
				      {
				        "id": 41,
				        "title": "node4.1",
				        "nodes": []
				      }
				    ]
				  }
				];	

	        	var pathArray = window.location.hash.split( '/' );
				$scope.currentPageName = pathArray[1];
				$rootScope.$on('$stateChangeStart', function(event, toState, toParams){
					$scope.currentPageName = toState.data.action;
				});

	        }
		}
	}
]);