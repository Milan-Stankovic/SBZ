(function () {
    'use strict';

    angular
        .module('app')
        .controller('addPatientController', addPatientController);

    addPatientController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies'];
    function addPatientController($location, $scope, $rootScope, $http, $window, $cookies) {
        var apac = this;

        $scope.sastojci=[];

        $scope.addPatient = function (num, firstname, lastname) {

          //  console.log(lastname);

            var b=false;
            if(num)
                if(firstname)
                    if(lastname)
                        if(num.length > 0)
                            if(firstname.length > 0)
                                if(lastname.length > 0)
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

            //    console.log(data);
                $http({
                    method: 'POST',
                    url: 'http://localhost:8096/patient/add',
                    data: data
                }).then(function successCallback(response){
                    var temp = response.data;

                    if(temp != null){
                        //$scope.user=temp;
                        alert("Add successful");
                        $location.path("/patient");
                    }else{
                        alert("Add not successful, please input valid values");
                    }



                });


            }else{
                alert("All fields must be entered");
            }

        }



        var init = function (){

            $http({
                method: 'GET',
                url: 'http://localhost:8096/ingredient',
            }).then(function successCallback(response){
                var temp = response.data;

                if(temp != null){
                    $scope.sastojci=temp;
                    for(var i = $scope.sastojci.length; i++;){
                        $scope.sastojci[i].izabrano=false;
                    }
                }

            });


        };
        init();

    }


})();