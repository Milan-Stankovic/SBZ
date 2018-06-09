(function () {
    'use strict';

    angular
        .module('app')
        .directive('ngConfirmClick', [
            function(){
                return {
                    link: function (scope, element, attr) {
                        var msg = attr.ngConfirmClick || "Are you sure?";
                        var clickAction = attr.confirmedClick;
                        element.bind('click',function (event) {
                            if ( window.confirm(msg) ) {
                                scope.$eval(clickAction)
                            }
                        });
                    }
                };
            }])
        .controller('adminController', adminController);

    adminController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$state'];
    function adminController($location, $scope, $rootScope, $http, $window, $cookies, $state) {
        var ac = this;

        $scope.user = {};
        $scope.users=[];

        $scope.editProfile= function(id){
            $state.go("core.editProfile", {"id" : id} );
        }

        $scope.deleteProfile = function(id){
            $http({
                method: 'DELETE',
                url: 'http://localhost:8096/users/'+id
            }).then(function successCallback(response){

                for(var i=0; i<$scope.users.length; i++){
                    if($scope.users[i].id==id){
                        $scope.users.splice(i, 1);
                        break;
                    }
                }
                alert("USER DELETED");
            }, function errorCallback(response) {
                alert("The account is being used and cannot be deleted");
            });



        }

        $scope.addUser = function () {
            $location.path("/addProfile");
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

                    if($scope.user.tip !="ADMIN"){
                            $location.path("/home");
                    }else{

                        $http({
                            method: 'GET',
                            url: 'http://localhost:8096/users'
                        }).then(function successCallback(response){
                            $scope.users = response.data;

                        });


                    }

                });



            }



        };
        init();

    }


})();