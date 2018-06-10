(function () {
    'use strict';

    angular
        .module('app')
        .controller('dijagnozaController', dijagnozaController);

    dijagnozaController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$state','$stateParams'];
    function dijagnozaController($location, $scope, $rootScope, $http, $window, $cookies, $state,$stateParams) {
        var dc = this;

        $scope.user = {};
        $scope.patient = {};
        $scope.symptom=[];




        var init = function (){

            var patientId = $stateParams.id;
            var userName = $cookies.get('user');
            if($cookies.get('user') == null || patientId == undefined){
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
                            url: 'http://localhost:8096/patient/get/'+patientId
                        }).then(function successCallback(response){
                            $scope.patient = response.data;

                            if($scope.patient){


                                $http({
                                    method: 'GET',
                                    url: 'http://localhost:8096/symptom',
                                }).then(function successCallback(response){
                                    var temp = response.data;

                                    if(temp != null){
                                        $scope.symptom=temp;
                                        for(var i =0; i< $scope.symptom.length; i++){
                                            $scope.symptom[i].izabrano=false;
                                        }

                                    }

                                });

                            }


                        });


                    }

                });



            }



        };
        init();

    }


})();