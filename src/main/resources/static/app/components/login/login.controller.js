(function () {
    'use strict';

    angular
        .module('app')
        .controller('loginController', loginController);

    loginController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies'];
    function loginController($location, $scope, $rootScope, $http, $window, $cookies) {
        var lc = this;


        console.log("U JS JE ");

        var init = function (){
            console.log("EVO U INITU SAM");

            if($cookies.get('user'))
                $location.path("/home")
        };
        init();



        $scope.login = function(username, pass){

            console.log("NIJE DO OVOGA ? ");

            if(username===undefined || pass===undefined || username==="" || pass===""){
                alert("Enter both username and password.");
                return;
            }

            var data = {
                "username" :username,
                "password" : pass
            }

            console.log("IZNAD POSTA SAM");


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


                    $cookies.put("user", user.username, {
                        path: 'core'
                    });
                    $cookies.put("id", user.id, {
                        path: 'core'
                    });
                    console.log("Uspesno logovanje: " + $cookies.get('user') + ", id: " +  $cookies.get('id'));
                    $location.path("/home");
                }


            }, function errorCallback(response) {
                alert("Error check your internet connection");



            });


        }
    }


})();