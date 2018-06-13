(function () {
    'use strict';

    angular
        .module('app')
        .controller('loginController', loginController);

    loginController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies'];
    function loginController($location, $scope, $rootScope, $http, $window, $cookies) {
        var lc = this;



        var init = function (){

            if($cookies.get('user'))
                $location.path("/home")
        };
        init();



        $scope.login = function(username, pass){

            if(username===undefined || pass===undefined || username==="" || pass===""){
                alert("Enter both username and password.");
                return;
            }

            var data = {
                "username" :username,
                "password" : pass
            }


            $http({
                method: 'POST',
                url: 'http://localhost:8096/login',
                data: data
            }).then(function successCallback(response) {

                var user = response.data;

                console.log(user);

                if(user===null || user===undefined || user===""){
                    alert("Login error. Please check your credentials.");

                }


                else{


                    $http({
                        method: 'PUT',
                        url: 'http://localhost:8096/drools/session/login/'+user.id,
                    }).then(function successCallback(response) {


                    });


                    $cookies.put("user", user.username, {
                        path: 'core'
                    });
                    $cookies.put("id", user.id, {
                        path: 'core'
                    });
                    console.log("Uspesno logovanje: " + $cookies.get('user') + ", id: " +  $cookies.get('id'));

                    $rootScope.$broadcast('login');


                    $location.path("/home");
                }


            }, function errorCallback(response) {
                alert("Error check your internet connection");



            });


        }
    }


})();