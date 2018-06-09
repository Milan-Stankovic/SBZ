(function () {
    'use strict';

    angular
        .module('app')
        .controller('editPatientController', editPatientController);

    editPatientController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$stateParams'];
    function editPatientController($location, $scope, $rootScope, $http, $window, $cookies, $stateParams) {
        var epac = this;

        $scope.sastojci=[];
        $scope.patient={};

        $scope.saveEdit = function (num, firstname, lastname,id) {

            var b=false;
                if(firstname)
                    if(lastname)
                        if(firstname.length > 0)
                            if(lastname.length > 0)
                                if(id)
                                    if(id>0)
                                        b=true;

            if(b){

                var niz =[];

                for(var i =0; i<$scope.sastojci.length; i++){
                    if($scope.sastojci[i].izabrano){
                        if($scope.sastojci[i].izabrano==true)
                            niz.push($scope.sastojci[i].id);
                    }
                }


                var data ={
                    "brojZdravstveneKartice" : num,
                    "ime" : firstname,
                    "prezime" : lastname,
                    "alergije" : niz

                }
                $http({
                    method: 'PUT',
                    url: 'http://localhost:8096/patient/edit/'+id,
                    data: data
                }).then(function successCallback(response){
                    var temp = response.data;


                    if(temp != null){
                        alert("Edit successful");
                        $location.path("/admin");
                    }else{
                        alert("Edit not successful, please input valid values");
                    }



                });


            }else{
                alert("All fields must be entered");
            }

        }



        var init = function (){

            $scope.sastojci=[];
            $scope.patient={};


            var patientId = $stateParams.id;
            if($cookies.get('id') == null || patientId == undefined){
                $location.path("/home")
            }else{

                $http({
                    method: 'GET',
                    url: 'http://localhost:8096/patient/get/'+patientId
                }).then(function successCallback(response){
                    $scope.patient = response.data;

                    console.log($scope.patient);


                    $http({
                        method: 'GET',
                        url: 'http://localhost:8096/ingredient',
                    }).then(function successCallback(response){
                        var temp = response.data;

                        console.log(temp);

                        if(temp != null){
                            $scope.sastojci=temp;

                            console.log($scope.sastojci);

                            for(var i =0; i< $scope.sastojci.length; i++){
                                $scope.sastojci[i].izabrano=false;
                            }

                            console.log($scope.sastojci);
                        }

                        for(var i =0; i< $scope.sastojci.length; i++){
                            for(var j=0; j< $scope.patient.alergije.length; j++){
                                if($scope.sastojci[i].id==$scope.patient.alergije[j].id){
                                    $scope.sastojci[i].izabrano=true;
                                }
                            }
                        }

                        console.log("KONACNI SASATOJCI : "+ $scope.sastojci);



                    });


                });






            }

        };
        init();

    }


})();