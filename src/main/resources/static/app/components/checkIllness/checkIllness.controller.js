(function () {
    'use strict';

    angular
        .module('app')
        .controller('checkIllness', checkIllness);

    checkIllness.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$stateParams'];
    function checkIllness($location, $scope, $rootScope, $http, $window, $cookies, $stateParams) {
        var ci = this;

        $scope.symptom=[];
        $scope.illness={};

        var init = function (){

            $scope.illness={};


            var illnessId = $stateParams.id;
            if($cookies.get('id') == null || illnessId == undefined){
                $location.path("/home")
            }else{

                $http({
                    method: 'GET',
                    url: 'http://localhost:8096/illness/get/'+illnessId
                }).then(function successCallback(response){
                    $scope.illness = response.data;


                });
            }

        };
        init();
    }


})();