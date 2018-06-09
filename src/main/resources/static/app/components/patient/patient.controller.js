(function () {
    'use strict';

    angular
        .module('app')
        .controller('patientController', patientController);

    patientController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$state'];
    function patientController($location, $scope, $rootScope, $http, $window, $cookies, $state) {
        var pac = this;

        $scope.user = {};
        $scope.patients=[];


        $scope.more = function(broj){
            $scope.patients[broj].more=  !$scope.patients[broj].more;
        }


        $scope.editPatient= function(id){

            $state.go("core.editPatient", {"id" : id} );
        }

        $scope.deletePatient = function(id){
            $http({
                method: 'DELETE',
                url: 'http://localhost:8096/patient/'+id
            }).then(function successCallback(response){

                for(var i=0; i<$scope.patients.length; i++){
                    if($scope.patients[i].id==id){
                        $scope.patients.splice(i, 1);
                        break;
                    }
                }
                alert("PATIENT DELETED");
            });



        }

        $scope.addPatient = function () {
            $location.path("/addPatient");
        }
        
        $scope.diagnose = function (id) {
            
        }


        $scope.format = function(date) {

            console.log("U FORMATIRANJU SAM");
            console.log(date);


            var temp = new Date(date);
            // temp.toLocaleString();


            return temp.toLocaleString();;
        }



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
                            url: 'http://localhost:8096/patient'
                        }).then(function successCallback(response){
                            $scope.patients = response.data;

                            if($scope.patients){
                                for(var i=0; i<$scope.patients.length; i++){
                                    $scope.patients[i].more = false;
                                 /*   for(var j=0; j<$scope.patients[i].istorija; j++){
                                        $scope.patients[i].istorija[j].niceDate= $scope.format($scope.patients[i].istorija[j].vreme);
                                        console.log("Lepo vreme je : " + $scope.patients[i].niceDate);
                                    }
                                    */

                                }
                            }


                        });


                    }

                });



            }



        };
        init();

    }


})();