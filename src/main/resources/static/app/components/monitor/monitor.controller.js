(function () {
    'use strict';

    angular
        .module('app')
        .controller('monitorController', monitorController);

    monitorController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$state', '$timeout'];
    function monitorController($location, $scope, $rootScope, $http, $window, $cookies, $state,$timeout) {
        var mc = this;

        var vremeCekanja= 5000;


        var isConnected=false;

        var ponavljanje = 10;

        var trenutno = 0;

        $scope.user = {};
        $scope.notifications=[];

        var socket = new SockJS('/gs-guide-websocket');
        var  stompClient = Stomp.over(socket);


        var mytimeout = null;


        var showGreeting =  function (message) {
            console.log("TREBAO BI SLATI NA FRONT");
            console.log(message);
            $scope.notifications.push(message.poruka);
        }


        $scope.rekurzijaCekaj = function () {
            sendName();
            console.log("KAO JE U REKURZIJI");

            trenutno++;

            if(trenutno < ponavljanje )
                mytimeout= $timeout($scope.rekurzijaCekaj,vremeCekanja);
        }



        var sendName=  function() {
            console.log("KAO SALJE PORUKU");
            stompClient.send("/app/monitorBack", {}, JSON.stringify({'poruka': "POSLAO PORUKU"}));
        }

        var connect= function() {

            if(trenutno>=2)
                disconnect();

            stompClient.connect({}, function (frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/monitor', function (message) {
                    showGreeting(JSON.parse(message.body));

                });
            });
        }

       var disconnect= function () {
            if (stompClient !== null) {
                stompClient.disconnect();
            }

            console.log("Disconnected");
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
                    }
                }).then( connect());

            }

        };
        init();


    }


})();