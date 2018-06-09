(function () {
    'use strict';

    angular
        .module('app')
        .controller('editProfileController', editProfileController);

    editProfileController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$stateParams'];
    function editProfileController($location, $scope, $rootScope, $http, $window, $cookies, $stateParams) {
        var epc = this;

        $scope.user = {};

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
                        alert("Edit successful");
                        $location.path("/admin");
                    }else{
                        alert("Edit not successful, please input valid values");
                    }



                });


            }else{
                alert("All fields must be entered, please repeat the password");
            }

        }



        var init = function (){

            console.log("UPO U INIT");
            var userId = $stateParams.id;
            var userName = $cookies.get('user');
            if($cookies.get('user') == null || userId == undefined){
                $location.path("/home")
            }else{



                $http({
                    method: 'GET',
                    url: 'http://localhost:8096/users/get/'+userId
                }).then(function successCallback(response){
                    $scope.user = response.data;
                    console.log($scope.user);
                });
            }

        };
        init();

    }


})();