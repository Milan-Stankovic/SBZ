(function () {
    'use strict';

    angular
        .module('app')
        .controller('profileController', profileController);

    profileController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies'];
    function profileController($location, $scope, $rootScope, $http, $window, $cookies) {
        var pc = this;

        $scope.user = {};

        $scope.edit = false;

        $scope.editProfile = function(){
            $scope.edit=!$scope.edit;
        }

        $scope.saveEdit = function (username, firstname, lastname, password, password2, tip, id) {

            var b=false;
            if(username)
                if(firstname)
                    if(password)
                        if(lastname)
                            if(password2)
                                if(username.length > 0)
                                    if(firstname.length > 0)
                                        if(lastname.length > 0)
                                            if(password.length > 0)
                                                if(password2.length >0)
                                                    if(password2==password)
                                                        if(id)
                                                            if(id>0)
                                                                b=true;

            if(b){


                var data ={
                    "username" : username,
                    "password" : password,
                    "ime" : firstname,
                    "prezime" : lastname,
                    "tip" : tip

                }
                $http({
                    method: 'PUT',
                    url: 'http://localhost:8096/users/edit/'+id,
                    data: data
                }).then(function successCallback(response){
                    var temp = response.data;


                    if(temp != null){
                        $scope.user=temp;
                        alert("Edit successful");
                    }else{
                        alert("Edit not successful, please input valid values");
                    }

                    $scope.edit=false;


                });


            }else{
                alert("All fields must be entered, please repeat your password");
            }

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
                });
            }

        };
        init();

    }


})();