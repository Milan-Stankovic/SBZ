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

        $rootScope.$on('login', function(event, data) {
           $scope.provera();
           $scope.proveraAdmin();
        });


        $scope.logout = function(){

            $http({
                method: 'DELETE',
                url: 'http://localhost:8096/drools/session/logout/'+$cookies.get('id'),
            }).then(function successCallback(response) {


            });

            $cookies.remove('id');
            $cookies.remove('user');


            $location.path("/home");
            $scope.provera();
            $scope.proveraAdmin();

        }


        $scope.provera = function(){


            $scope.loggedin=false;
            var b = false;
            userCookie = $cookies.get('user');
            userId = $cookies.get('id');
            if(userCookie && userId)
                b=true;
            if(b)
                $scope.loggedin=true;

            return b;
        }

        $scope.doktorJe= function(){

            var b=false;

            if($scope.loggedin)
                if(!$scope.isAdmin)
                    b=true;

            return b;
        }

        $scope.proveraAdmin = function(){

            var b = false;
            console.log("DA LI TO ULAZI OVDEEEE ??????");


                $scope.isAdmin=false;
                userCookie = $cookies.get('user');
                userId = $cookies.get('id');
                if(userCookie && userId){

                    $http({
                        method: 'GET',
                        url: 'http://localhost:8096/users/get/'+userId
                    }).then(function successCallback(response){

                        $scope.korisnik = response.data;

                        if(response.data!=null)
                            if($scope.korisnik.tip == "ADMIN") {
                                $scope.isAdmin = true;
                                b=true;
                            }else{
                                $scope.isAdmin = false;
                            }
                    });



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

                     console.log("GETUJE IZ INITA");
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