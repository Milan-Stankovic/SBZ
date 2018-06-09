(function () {
    'use strict';

    angular
        .module('app')
        .controller('editMedicineController', editMedicineController);

    editMedicineController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$stateParams'];
    function editMedicineController($location, $scope, $rootScope, $http, $window, $cookies, $stateParams) {
        var emc = this;

        $scope.sastojci=[];
        $scope.medicine={};

        $scope.saveEdit = function (naziv, tip, id) {

            var b=false;
            if(naziv)
                if(tip)
                    if(naziv.length>0)
                        if(tip.length>0)
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
                    "naziv" : naziv,
                    "tip" : tip,
                    "sastojci" : niz

                }

                $http({
                    method: 'PUT',
                    url: 'http://localhost:8096/medicine/edit/'+id,
                    data: data
                }).then(function successCallback(response){
                    var temp = response.data;


                    if(temp != null){
                        alert("Edit successful");
                        $location.path("/medicine");
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
            $scope.medicine={};


            var medicineId = $stateParams.id;
            if($cookies.get('id') == null || medicineId == undefined){
                $location.path("/home")
            }else{

                $http({
                    method: 'GET',
                    url: 'http://localhost:8096/medicine/get/'+medicineId
                }).then(function successCallback(response){
                    $scope.medicine = response.data;

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
                            for(var j=0; j< $scope.medicine.sastojci.length; j++){
                                if($scope.sastojci[i].id==$scope.medicine.sastojci[j].id){
                                    $scope.sastojci[i].izabrano=true;
                                }
                            }
                        }

                    });

                });
            }

        };
        init();
    }


})();