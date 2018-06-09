(function () {
    'use strict';

    angular
        .module('app')
        .controller('addMedicineController', addMedicineController);

    addMedicineController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies'];
    function addMedicineController($location, $scope, $rootScope, $http, $window, $cookies) {
        var amc = this;

        $scope.sastojci=[];

        $scope.addMedicine = function (naziv, tip) {

            var b= false;

            console.log(tip);

            if(naziv)
                if(tip)
                    if(naziv.length>0)
                        if(tip.length>0)
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
                    "naziv" : naziv,
                    "tip" : tip,
                    "sastojci" : niz

                }

                //    console.log(data);
                $http({
                    method: 'POST',
                    url: 'http://localhost:8096/medicine/add',
                    data: data
                }).then(function successCallback(response){
                    var temp = response.data;

                    if(temp != null){
                        //$scope.user=temp;
                        alert("Add successful");
                        $location.path("/medicine");
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
                    for(var i =0; i< $scope.sastojci.length; i++){
                        $scope.sastojci[i].izabrano=false;
                    }
                }

            });

        };
        init();

    }


})();