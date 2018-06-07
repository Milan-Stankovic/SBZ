(function () {
    'use strict';

    angular
        .module('app')
        .controller('profileController', profileController);

    profileController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies'];
    function profileController($location, $scope, $rootScope, $http, $window, $cookies) {
        var pc = this;

        $scope.user = {};

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