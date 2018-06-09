(function () {
    'use strict';

    angular
        .module('app')
        .controller('addProfileController', addProfileController);

    addProfileController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies'];
    function addProfileController($location, $scope, $rootScope, $http, $window, $cookies) {
        var apc = this;

        $scope.addUser = function (username, firstname, lastname) {

            var b=false;
            if(username)
                if(firstname)
                    if(lastname)
                        if(username.length > 0)
                            if(firstname.length > 0)
                                if(lastname.length > 0)
                                    b=true;

            if(b){
                var data ={
                    "username" : username,
                    "password" : "password",
                    "ime" : firstname,
                    "prezime" : lastname,
                    "tip" : "LEKAR"

                }
                $http({
                    method: 'POST',
                    url: 'http://localhost:8096/users/add',
                    data: data
                }).then(function successCallback(response){
                    var temp = response.data;

                    if(temp != null){
                        //$scope.user=temp;
                        alert("Add successful");
                        $location.path("/admin");
                    }else{
                        alert("Add not successful, please input valid values");
                    }

                    $scope.add=false;


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