(function () {
    'use strict';

    angular
        .module('app')
        .controller('coreController', coreController);

    coreController.$inject = ['$location', '$scope', '$rootScope','$http', '$cookies', '$window'];
    function coreController($location, $scope, $rootScope,$http, $cookies, $window) {
        var cc = this;
        $scope.logged = false;
        var userCookie;
        var userId;
        $scope.isAdmin = false;
        $scope.loggedin = false;

        $scope.logout = function(){
            $cookies.remove('id');
            $cookies.remove('user');
            $location.path("/home");
        }


        $scope.provera = function(){

            var b = false;
            userCookie = $cookies.get('user');
            userId = $cookies.get('id');
            if(userCookie && userId)
                b=true;

            return b;
        }

        $scope.proveraAdmin = function(){

            var b = false;

            if($scope.isAdmin){
               b=true;
            }else{
                userCookie = $cookies.get('user');
                userId = $cookies.get('id');
                if(userCookie && userId){

                    $http({
                        method: 'GET',
                        url: 'http://localhost:8096/users/get/'+userId
                    }).then(function successCallback(response){

                        $scope.korisnik = response.data;

                        if(response.data!="")
                            if($scope.korisnik.tip == "ADMIN") {
                                $scope.isAdmin = true;
                                b=true;
                            }
                    });


                }
            }


            return b;
        }


        $scope.korisnik={};

        var init = function () {
            $scope.isAdmin = false;
             userCookie = $cookies.get('user');
             userId = $cookies.get('id');

             console.log("UPAO U INIT, COOKIE : " +userCookie +" " +userId );
             if (userCookie && userId){
                 console.log("EVO U IFU SAM");
                 $scope.loggedin = true;
                 $http({
                     method: 'GET',
                     url: 'http://localhost:8096/users/get/'+userId
                 }).then(function successCallback(response){

                     $scope.korisnik = response.data;

                     if(response.data!="")
                         if($scope.korisnik.tip == "ADMIN")
                            $scope.isAdmin = true;
                 });
             }

             else $scope.logged=false;



        };
        init();

    }

})();