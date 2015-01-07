var themeBasePath = 'themes/default';

angular.module("shopApp",
    ['ui.router','ui.tree']).
    value("serviceCallBaseUrl","../rest/").
    config(["$stateProvider","$urlRouterProvider",
        function($stateProvider,$urlRouterProvider){    

        $stateProvider.state('dashboard', {
            url: "/dashboard",
            templateUrl: themeBasePath+'/home.html',
            data : {
                action : "dashboard",
            }
        })
        .state('categories', {
            url: '/categories',
            templateUrl: themeBasePath+'/categories.html',
            controller : "categoriesController",
            data:{
                action : "categories",
            }
        })
        .state('brands', {
            url: '/brands',
            templateUrl: themeBasePath+'/brands.html',
            controller : "brandsController",
            data:{
                action : "brands",
            }
        }).state('units', {
            url: '/units',
            templateUrl: themeBasePath+'/units.html',
            controller: "unitsController",
            data:{
                action : "units",
            }
        }).state('weights', {
            url: '/weights',
            templateUrl: themeBasePath+'/weights.html',
            controller: "weightsController",
            data:{
                action : "weights",
            }
        }).state('products', {
            url: '/products',
            templateUrl: themeBasePath+'/products.html',
            controller : "productsController",
            data:{
                action : "products",
            }
        }).state('discounts', {
            url: '/discounts',
            templateUrl: themeBasePath+'/discounts.html',
            controller : "discountsController",
            data:{
                action : "discounts",
            }
        }).state('users', {
            url: '/users',
            templateUrl: themeBasePath+'/users.html',
            controller : "usersController",
            data:{
                action : "users",
            }
        })

        $urlRouterProvider.otherwise("dashboard");

    }
]);