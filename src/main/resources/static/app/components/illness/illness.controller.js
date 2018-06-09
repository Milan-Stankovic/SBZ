(function () {
    'use strict';

    angular
        .module('app')
        .controller('illnessController', illnessController);

    illnessController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$state'];
    function illnessController($location, $scope, $rootScope, $http, $window, $cookies, $state) {
        var ilc = this;

        $scope.user = {};
        $scope.illness=[];


        $scope.more = function(broj){
            $scope.illness[broj].more=  !$scope.illness[broj].more;
        }


        $scope.editIllness= function(id){

            $state.go("core.editIllness", {"id" : id} );
        }

        $scope.deleteIllness = function(id){
            $http({
                method: 'DELETE',
                url: 'http://localhost:8096/illness/'+id
            }).then(function successCallback(response){

                for(var i=0; i<$scope.illness.length; i++){
                    if($scope.illness[i].id==id){
                        $scope.illness.splice(i, 1);
                        break;
                    }
                }
                alert("Illness deleted");
            }, function errorCallback(response) {
                alert("The illness is diagnosed to a patient and cannot be deleted");
            });



        }

        $scope.addIllness = function () {
            $location.path("/addIllness");
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
                            url: 'http://localhost:8096/illness'
                        }).then(function successCallback(response){
                            $scope.illness = response.data;

                            if($scope.illness){
                                for(var i=0; i<$scope.illness.length; i++){
                                    $scope.illness[i].more = false;

                                }
                            }

                        });
                    }

                });

            }

        };
        init();

    }


})();