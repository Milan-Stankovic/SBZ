(function () {
    'use strict';

    angular
        .module('app')
        .controller('medicineController', medicineController);

    medicineController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$state'];
    function medicineController($location, $scope, $rootScope, $http, $window, $cookies, $state) {
        var mc = this;

        $scope.user = {};
        $scope.medicine=[];


        $scope.more = function(broj){
            $scope.medicine[broj].more=  !$scope.medicine[broj].more;
        }


        $scope.editMedicine= function(id){

            $state.go("core.editMedicine", {"id" : id} );
        }

        $scope.deleteMedicine = function(id){
            $http({
                method: 'DELETE',
                url: 'http://localhost:8096/medicine/'+id
            }).then(function successCallback(response){

                for(var i=0; i<$scope.medicine.length; i++){
                    if($scope.medicine[i].id==id){
                        $scope.medicine.splice(i, 1);
                        break;
                    }
                }
                alert("Medicine deleted");
            }, function errorCallback(response) {
                alert("The medicine is being used and cannot be deleted");
            });



        }

        $scope.addMedicine = function () {
            $location.path("/addMedicine");
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
                            url: 'http://localhost:8096/medicine'
                        }).then(function successCallback(response){
                            $scope.medicine = response.data;

                            if($scope.medicine){
                                for(var i=0; i<$scope.medicine.length; i++){
                                    $scope.medicine[i].more = false;

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