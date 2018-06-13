(function () {
    'use strict';

    angular
        .module('app')
        .controller('checkIllnessController', checkIllnessController);

    checkIllnessController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$stateParams'];
    function checkIllnessController($location, $scope, $rootScope, $http, $window, $cookies, $stateParams) {
        var ci = this;

        $scope.specificni=[];
        $scope.opsti=[];
        $scope.bolest={};

        var init = function (){

            $scope.bolest={};
            console.log("UPAO U OVAJ DEO ZA BOLEST");
         //   var params = new URL(location.href).searchParams;


            var par = $location.search();
            console.log(par);

            console.log(par.id);

            var illnessId = par.id;


            console.log(illnessId);
            console.log($cookies.get('id'));


            if($cookies.get('id') == null || illnessId == undefined){
                $location.path("/home")
            }else{


                $http({
                    method: 'GET',
                    url: 'http://localhost:8096/illness/get/'+ illnessId
                }).then(function successCallback(response){
                    var temp = response.data;

                    $scope.bolest= temp;

                    var data ={
                        "naziv" : temp.naziv
                    }

                    $http({
                        method: 'POST',
                        url: 'http://localhost:8096/drools/bolest',
                        data:data
                    }).then(function successCallback(response){
                        var dto = response.data;

                        console.log(response.data);

                        $scope.specificni=dto.specificni;
                        $scope.opsti=dto.opsti;


                    });


                });


            }

        };
        init();
    }


})();