(function () {
    'use strict';

    angular
        .module('app')
        .controller('addIllnessController', addIllnessController);

    addIllnessController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies'];
    function addIllnessController($location, $scope, $rootScope, $http, $window, $cookies) {
        var ailc = this;

        $scope.symptom=[];

        $scope.addIllness = function (naziv) {

            var b= false;


            if(naziv)
                if(naziv.length>0)
                    b=true;


            if(b){


                var niz =[];

                for(var i =0; i<$scope.symptom.length; i++){
                    if($scope.symptom[i].izabranoOpste){
                        if($scope.symptom[i].izabranoOpste==true)
                            niz.push($scope.symptom[i].id);
                    }
                }

                var niz2 =[];

                for(var i =0; i<$scope.symptom.length; i++){
                    if($scope.symptom[i].izabranoSpecificno){
                        if($scope.symptom[i].izabranoSpecificno==true)
                            niz2.push($scope.symptom[i].id);
                    }
                }


                var data ={
                    "naziv" : naziv,
                    "opsti" : niz,
                    "specificni" : niz2

                }

                console.log(data);

                //    console.log(data);
                $http({
                    method: 'POST',
                    url: 'http://localhost:8096/illness/add',
                    data: data
                }).then(function successCallback(response){

                    console.log(response.data);


                    var temp = response.data;

                    if(temp != null){
                        //$scope.user=temp;
                        alert("Add successful");
                        $location.path("/illness");
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
                url: 'http://localhost:8096/symptom',
            }).then(function successCallback(response){
                var temp = response.data;

                if(temp != null){
                    $scope.symptom=temp;
                    for(var i =0; i< $scope.symptom.length; i++){
                        $scope.symptom[i].izabranoOpste=false;
                        $scope.symptom[i].izabranoSpecificno=false;
                    }
                }

            });

        };
        init();

    }


})();