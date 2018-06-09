(function () {
    'use strict';

    angular
        .module('app')
        .controller('symptomController', symptomController);

    symptomController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$state'];
    function symptomController($location, $scope, $rootScope, $http, $window, $cookies, $state) {
        var sc = this;

        $scope.symptoms=[];


        $scope.editSymptom= function(id){

            $state.go("core.editSymptom", {"id" : id} );
        }

        $scope.deleteSymptom = function(id){
            $http({
                method: 'DELETE',
                url: 'http://localhost:8096/symptom/'+id
            }).then(function successCallback(response){

                for(var i=0; i<$scope.symptoms.length; i++){
                    if($scope.symptoms[i].id==id){
                        $scope.symptoms.splice(i, 1);
                        break;
                    }
                }
                alert("Symptom deleted");
            }, function errorCallback(response) {
                alert("The symptom is being used and cannot be deleted");
            });



        }

        $scope.addSymptom = function () {
            $location.path("/addSymptom");
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
                            url: 'http://localhost:8096/symptom'
                        }).then(function successCallback(response){
                            $scope.symptoms = response.data;

                        });
                    }

                });

            }

        };
        init();

    }


})();