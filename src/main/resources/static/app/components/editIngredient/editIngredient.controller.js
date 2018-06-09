(function () {
    'use strict';

    angular
        .module('app')
        .controller('editIngredientController', editIngredientController);

    editIngredientController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$stateParams'];
    function editIngredientController($location, $scope, $rootScope, $http, $window, $cookies, $stateParams) {
        var eic = this;


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
                    url: 'http://localhost:8096/ingredient/edit/'+id,
                    data: data
                }).then(function successCallback(response){
                    var temp = response.data;


                    if(temp != null){
                        alert("Edit successful");
                        $location.path("/ingredient");
                    }else{
                        alert("Edit not successful, please input valid values");
                    }

                });


            }else{
                alert("All fields must be entered");
            }

        }

        $scope.ingredient={};

        var init = function (){

            var ingredientId = $stateParams.id;
            if($cookies.get('id') == null || ingredientId == undefined){
                $location.path("/home")
            }else{

                $http({
                    method: 'GET',
                    url: 'http://localhost:8096/ingredient/get/'+ingredientId
                }).then(function successCallback(response){
                    $scope.ingredient = response.data;

                    if($scope.ingredient == null){
                        alert("ERROR");
                        $location.path("/ingredient");
                    }

                    console.log($scope.patient);


                });






            }

        };
        init();

    }


})();