(function () {
    'use strict';

    angular
        .module('app')
        .controller('ingredientController', ingredientController);

    ingredientController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$state'];
    function ingredientController($location, $scope, $rootScope, $http, $window, $cookies, $state) {
        var ic = this;

        $scope.user = {};
        $scope.ingredients=[];


        $scope.editIngredient= function(id){

            $state.go("core.editIngredient", {"id" : id} );
        }

        $scope.deleteIngredient = function(id){
            $http({
                method: 'DELETE',
                url: 'http://localhost:8096/ingredient/'+id
            }).then(function successCallback(response){

                for(var i=0; i<$scope.ingredients.length; i++){
                    if($scope.ingredients[i].id==id){
                        $scope.ingredients.splice(i, 1);
                        break;
                    }
                }
                alert("Ingredient deleted");
            }, function errorCallback(response) {
                alert("The ingredient is being used and cannot be deleted");
            });



        }

        $scope.addIngredient = function () {
            $location.path("/addIngredient");
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
                            url: 'http://localhost:8096/ingredient'
                        }).then(function successCallback(response){
                            $scope.ingredients = response.data;

                        });
                    }

                });

            }

        };
        init();

    }


})();