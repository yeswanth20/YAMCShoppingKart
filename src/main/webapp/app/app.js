var themeBasePath = 'themes/new_theme';

angular.module("shopApp",
    ['ui.router','ui.tree']).
    value("serviceCallBaseUrl","../admin/data/json/").
    config(["$stateProvider","$urlRouterProvider",
        function($stateProvider,$urlRouterProvider){    

        /*
            homepage
            cart page
            login page
            myaccounts
            product view
            order confirmation            
        */

        $stateProvider.state('home', {
            url: "/home",
            templateUrl: themeBasePath+'/home.html',            
            data : {
                action : "home",
            }
        }).state('cart', {
            url: "/cart",
            templateUrl: themeBasePath+'/cart.html',
            data : {
                action : "cart",
            }
        })
        .state('login', {
            url: "/login",
            templateUrl: themeBasePath+'/Login.html',
            data : {
                action : "login",
            }
        })
        .state('myaccounts', {
            url: "/myaccounts",
            templateUrl: themeBasePath+'/Myaccount.html',
            data : {
                action : "Myaccount",
            }
        })
        .state('productview', {
            url: "/productview",
            templateUrl: themeBasePath+'/product_view.html',
            data : {
                action : "productview",
            }
        })  
        .state('orderconformation', {
            url: "/orderconformation",
            templateUrl: themeBasePath+'/orderconformation.html',
            data : {
                action : "orderconformation",
            }
        })        

        $urlRouterProvider.otherwise("home");

    }
]);