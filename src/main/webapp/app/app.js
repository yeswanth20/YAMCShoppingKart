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

        $urlRouterProvider.otherwise("home");

    }
]);