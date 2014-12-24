var themeBasePath = 'themes/new_theme';

angular.module("shopApp",
    ['ui.router','ui.tree']).
    value("serviceCallBaseUrl","../rest/").
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
            controller: "cartController",
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
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) != -1) return c.substring(name.length,c.length);
    }
    return "";
}