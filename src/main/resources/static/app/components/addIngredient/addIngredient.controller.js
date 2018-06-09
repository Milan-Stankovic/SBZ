(function () {
    'use strict';

    angular
        .module('app')
        .controller('addIngredientController', addIngredientController);

    addIngredientController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies'];
    function addIngredientController($location, $scope, $rootScope, $http, $window, $cookies) {
        var aic = this;


        $scope.addIngredient = function (naziv) {

            //  console.log(lastname)
            var b = false;
            if(naziv)
                if(naziv.length>0)
                    b=true;

            if(b){

                var data ={
                    "naziv" : naziv
                }

                //    console.log(data);
                $http({
                    method: 'POST',
                    url: 'http://localhost:8096/ingredient/add',
                    data: data
                }).then(function successCallback(response){
                    var temp = response.data;

                    if(temp != null){
                        //$scope.user=temp;
                        alert("Add successful");
                        $location.path("/ingredient");
                    }else{
                        alert("Add not successful, please input valid values, the ingredient already exists");
                    }



                });


            }else{
                alert("All fields must be entered");
            }

        }



        var init = function (){
        };
        init();

    }


})();