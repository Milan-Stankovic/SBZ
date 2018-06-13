(function () {
    'use strict';

    angular
        .module('app')
        .controller('reportController', reportController);

    reportController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$state'];
    function reportController($location, $scope, $rootScope, $http, $window, $cookies, $state) {
        var rc = this;

        $scope.user = {};
        $scope.svi ={};
        $scope.patients1=[];
        $scope.patients2=[];
        $scope.patients3=[];




        var init = function (){
            var userName = $cookies.get('user');
            if($cookies.get('user') == null){
                $location.path("/home")
            }else{
                $http({
                    method: 'GET',
                    url: 'http://localhost:8096/users/'+userName
                }).then(function successCallback(response){
                    $scope.user = response.data;

                    if($scope.user.tip =="ADMIN"){
                        $location.path("/home");
                    }else{

                        $http({
                            method: 'GET',
                            url: 'http://localhost:8096/drools/izvestaj'
                        }).then(function successCallback(response){
                            $scope.svi = response.data;
                            console.log($scope.svi);
                            $scope.patients1 = $scope.svi.hronicni;
                            $scope.patients2 = $scope.svi.imunitet;
                            $scope.patients3 = $scope.svi.zavisnici;



                        });


                    }

                });



            }



        };
        init();

    }


})();