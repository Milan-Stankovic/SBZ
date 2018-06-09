(function () {
    'use strict';

    angular
        .module('app')
        .controller('editIllnessController', editIllnessController);

    editIllnessController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$stateParams'];
    function editIllnessController($location, $scope, $rootScope, $http, $window, $cookies, $stateParams) {
        var eilc = this;

        $scope.symptom=[];
        $scope.illness={};

        $scope.saveEdit = function (naziv, id) {

            var b=false;
            if(naziv)
                if(naziv.length>0)
                    if(id)
                        if(id>0)
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

                $http({
                    method: 'PUT',
                    url: 'http://localhost:8096/illness/edit/'+id,
                    data: data
                }).then(function successCallback(response){

                    console.log(response.data);

                    var temp = response.data;


                    if(temp != null){
                        alert("Edit successful");
                        $location.path("/illness");
                    }else{
                        alert("Edit not successful, please input valid values");
                    }

                });


            }else{
                alert("All fields must be entered");
            }

        }

        var init = function (){

            $scope.symptom=[];
            $scope.illness={};


            var illnessId = $stateParams.id;
            if($cookies.get('id') == null || illnessId == undefined){
                $location.path("/home")
            }else{

                $http({
                    method: 'GET',
                    url: 'http://localhost:8096/illness/get/'+illnessId
                }).then(function successCallback(response){
                    $scope.illness = response.data;


                    $http({
                        method: 'GET',
                        url: 'http://localhost:8096/symptom',
                    }).then(function successCallback(response){
                        var temp = response.data;

                        console.log(temp);

                        if(temp != null){
                            $scope.symptom=temp;


                            for(var i =0; i< $scope.symptom.length; i++){
                                $scope.symptom[i].izabranoOpste=false;
                                $scope.symptom[i].izabranoSpecificno=false;
                            }

                        }

                        for(var i =0; i< $scope.symptom.length; i++){
                            for(var j=0; j< $scope.illness.specificni.length; j++){
                                if($scope.symptom[i].id==$scope.illness.specificni[j].id){
                                    $scope.symptom[i].izabranoSpecificno=true;
                                }
                            }
                        }



                        for(var i =0; i< $scope.symptom.length; i++){
                            for(var z=0; z<$scope.illness.specificni.length; z++){
                                if($scope.symptom[i].id==$scope.illness.opsti[z].id){
                                    $scope.symptom[i].izabranoOpste=true;
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