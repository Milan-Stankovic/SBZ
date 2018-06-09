(function () {
    'use strict';

    angular
        .module('app')
        .controller('editSymptomController', editSymptomController);

    editSymptomController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$stateParams'];
    function editSymptomController($location, $scope, $rootScope, $http, $window, $cookies, $stateParams) {
        var esc = this;


        $scope.saveEdit = function (naziv, id) {

            var b=false;
            if(naziv)
                if(naziv.length>0)
                    b=true;

            if(b){

                var data ={
                    "naziv" : naziv

                }
                $http({
                    method: 'PUT',
                    url: 'http://localhost:8096/symptom/edit/'+id,
                    data: data
                }).then(function successCallback(response){
                    var temp = response.data;


                    if(temp != null){
                        alert("Edit successful");
                        $location.path("/symptom");
                    }else{
                        alert("Edit not successful, please input valid values");
                    }

                });


            }else{
                alert("All fields must be entered");
            }

        }

        $scope.symptom={};

        var init = function (){

            var symptomId = $stateParams.id;
            if($cookies.get('id') == null || symptomId == undefined){
                $location.path("/home")
            }else{

                $http({
                    method: 'GET',
                    url: 'http://localhost:8096/symptom/get/'+symptomId
                }).then(function successCallback(response){
                    $scope.symptom = response.data;

                    if($scope.symptom == null){
                        alert("ERROR");
                        $location.path("/symptom");
                    }

                    console.log($scope.patient);

                });
            }
        };
        init();

    }


})();