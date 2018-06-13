(function () {
    'use strict';

    angular
        .module('app')
        .controller('dijagnozaController', dijagnozaController);

    dijagnozaController.$inject = ['$location', '$scope', '$rootScope','$http', '$window', '$cookies', '$state','$stateParams'];
    function dijagnozaController($location, $scope, $rootScope, $http, $window, $cookies, $state,$stateParams) {
        var dc = this;

        $scope.user = {};
        $scope.patient = {};
        $scope.symptom=[];

        $scope.lekovi = [];
        $scope.lekoviNajverovatnije =[];
        $scope.lekoviSvi=[];

        $scope.bolesti = [];
        $scope.bolestiSve = [];
        $scope.verovatnaBolest =[];

        $scope.pacijentId = null;

        $scope.pickNajverovatnija =false;
        $scope.pickLicno =false;
        $scope.pickSveMoguce = false;
        
        $scope.najverovatnije = function () {

            $scope.pickLicno =false;
            $scope.pickSveMoguce = false;

            var lista=[];

            for(var i =0; i<$scope.symptom.length; i++){
                if($scope.symptom[i].izabrano)
                    lista.push($scope.symptom[i].naziv);
            }



            var data = {
                "korisnik" : $scope.pacijentId,
                "simptomi" : lista

            }

            console.log(data);

            $http({
                method: 'POST',
                url: 'http://localhost:8096/drools/naj',
                data: data
            }).then(function successCallback(response){
                var temp = response.data;

                console.log(temp);

                if(temp != null){
                    $scope.verovatnaBolest=temp.bolesti;
                    for(var i =0; i<$scope.verovatnaBolest.length; i++){
                        $scope.verovatnaBolest[i].izabrano =false;

                    }
                    $scope.pickNajverovatnija = !$scope.pickNajverovatnija;
                }

            });



        }
        
        $scope.sveMoguce = function () {
            $scope.pickNajverovatnija =false;
            $scope.pickLicno =false;



            var lista=[];

            for(var i =0; i<$scope.symptom.length; i++){
                if($scope.symptom[i].izabrano)
                    lista.push($scope.symptom[i].naziv);
            }



            var data = {
                "korisnik" : $scope.pacijentId,
                "simptomi" : lista

            }

            console.log(data);

            $http({
                method: 'POST',
                url: 'http://localhost:8096/drools/sve',
                data: data
            }).then(function successCallback(response){
                var temp = response.data;

                console.log(temp);

                if(temp != null){
                    $scope.bolestiSve=temp;
                    for(var i =0; i<$scope.bolestiSve.length; i++){
                        $scope.bolestiSve[i].izabrano =false;

                    }
                    $scope.pickSveMoguce = !$scope.pickSveMoguce;
                }

            });




        }
        
        $scope.proveriBolest = function (id) {
            $window.open('http://localhost:8096/#!/checkIllness?id='+id, '_blank');
        }
        
        $scope.licno = function () {

            $scope.pickNajverovatnija =false;
            $scope.pickLicno = !$scope.pickLicno;
            $scope.pickSveMoguce = false;
        }


        $scope.diagnoseSve = function () {


            var doktorId = $cookies.get('id');
            var b = false;

            if(doktorId)
                if(doktorId >0)
                    if($scope.pacijentId)
                        if($scope.pacijentId>0)
                            b=true;


            if(b){

                var simptomi=[];

                for(var i =0; i<$scope.symptom.length; i++){
                    if($scope.symptom[i].izabrano)
                        simptomi.push($scope.symptom[i].id);
                }

                var bolesti=[];

                for(var i =0; i<$scope.bolestiSve.length; i++){
                    if($scope.bolestiSve[i].izabrano)
                        bolesti.push($scope.bolestiSve[i].id);
                }

                var lekovi=[];

                for(var i =0; i<$scope.lekoviSvi.length; i++){
                    if($scope.lekoviSvi[i].izabrano)
                        lekovi.push($scope.lekoviSvi[i].id);
                }


                var data ={
                    "simptomi" :simptomi,
                    "bolesti" : bolesti,
                    "terapije" :lekovi,
                    "doktorId" :doktorId

                };


                var lekoviSastojci =[];

                var alergije =[];

                for(var i =0; i<$scope.alergije.length; i++){
                    alergije.push($scope.alergije[i].naziv);
                }

                for(var i =0; i<$scope.lekovi.length; i++){
                    if($scope.lekovi[i].izabrano){
                        for(var j =0; j<$scope.lekovi[i].sastojci.length; j++){
                            lekoviSastojci.push($scope.lekovi[i].sastojci[j].naziv);
                        }
                    }

                }

                var validData = {
                    "alergije" :alergije,
                    "sastojci" :lekoviSastojci
                }


                console.log(validData);
                console.log(data);


                $http({
                    method: 'POST',
                    url: 'http://localhost:8096/drools/validiraj',
                    data :validData
                }).then(function successCallback(response){

                    var odgovor = response.data;
                    if(odgovor.tekst !="OK"){

                        alert("The patient is allergic to some of the prescribed medicine, the diagnosis was not saved");

                    }else{

                        $http({
                            method: 'PUT',
                            url: 'http://localhost:8096/patient/'+ $scope.pacijentId +'/history',
                            data :data
                        }).then(function successCallback(response){

                            alert("Patient diagnosed successfully");
                            $location.path("/home");

                        });
                    }


                });

            }




        }
        
        $scope.diagnoseNajverovatnije = function () {


            var doktorId = $cookies.get('id');
            var b = false;

            if(doktorId)
                if(doktorId >0)
                    if($scope.pacijentId)
                        if($scope.pacijentId>0)
                            b=true;


            if(b){

                var simptomi=[];

                for(var i =0; i<$scope.symptom.length; i++){
                    if($scope.symptom[i].izabrano)
                        simptomi.push($scope.symptom[i].id);
                }

                var bolesti=[];

                for(var i =0; i<$scope.verovatnaBolest.length; i++){
                    if($scope.verovatnaBolest[i].izabrano)
                        bolesti.push($scope.verovatnaBolest[i].id);
                }

                var lekovi=[];

                for(var i =0; i<$scope.lekoviNajverovatnije.length; i++){
                    if($scope.lekoviNajverovatnije[i].izabrano)
                        lekovi.push($scope.lekoviNajverovatnije[i].id);
                }


                var data ={
                    "simptomi" :simptomi,
                    "bolesti" : bolesti,
                    "terapije" :lekovi,
                    "doktorId" :doktorId

                };


                var lekoviSastojci =[];

                var alergije =[];

                for(var i =0; i<$scope.alergije.length; i++){
                    alergije.push($scope.alergije[i].naziv);
                }

                for(var i =0; i<$scope.lekovi.length; i++){
                    if($scope.lekovi[i].izabrano){
                        for(var j =0; j<$scope.lekovi[i].sastojci.length; j++){
                            lekoviSastojci.push($scope.lekovi[i].sastojci[j].naziv);
                        }
                    }

                }


                var validData = {
                    "alergije" :alergije,
                    "sastojci" :lekoviSastojci
                }


                console.log(validData);
                console.log(data);


                $http({
                    method: 'POST',
                    url: 'http://localhost:8096/drools/validiraj',
                    data :validData
                }).then(function successCallback(response){

                    var odgovor = response.data;
                    if(odgovor.tekst !="OK"){

                        alert("The patient is allergic to some of the prescribed medicine, the diagnosis was not saved");

                    }else{

                        $http({
                            method: 'PUT',
                            url: 'http://localhost:8096/patient/'+ $scope.pacijentId +'/history',
                            data :data
                        }).then(function successCallback(response){

                            alert("Patient diagnosed successfully");
                            $location.path("/home");

                        });
                    }


                });




            }


        }
        
        $scope.diagnose = function () {


            var doktorId = $cookies.get('id');
            var b = false;

            if(doktorId)
                if(doktorId >0)
                    if($scope.pacijentId)
                        if($scope.pacijentId>0)
                            b=true;


            if(b){

                var simptomi=[];

                for(var i =0; i<$scope.symptom.length; i++){
                    if($scope.symptom[i].izabrano)
                        simptomi.push($scope.symptom[i].id);
                }

                var bolesti=[];

                for(var i =0; i<$scope.bolesti.length; i++){
                    if($scope.bolesti[i].izabrano)
                        bolesti.push($scope.bolesti[i].id);
                }

                var lekovi=[];

                for(var i =0; i<$scope.lekovi.length; i++){


                    if($scope.lekovi[i].izabrano)
                        lekovi.push($scope.lekovi[i].id);
                }


                var data ={
                    "simptomi" :simptomi,
                    "bolesti" : bolesti,
                    "terapije" :lekovi,
                    "doktorId" :doktorId

                };

                var lekoviSastojci =[];

                var alergije =[];

                for(var i =0; i<$scope.alergije.length; i++){
                    alergije.push($scope.alergije[i].naziv);
                }

                for(var i =0; i<$scope.lekovi.length; i++){
                    if($scope.lekovi[i].izabrano){
                        for(var j =0; j<$scope.lekovi[i].sastojci.length; j++){
                            lekoviSastojci.push($scope.lekovi[i].sastojci[j].naziv);
                        }
                    }

                }

                var validData = {
                    "alergije" :alergije,
                    "sastojci" :lekoviSastojci
                }


                console.log(validData);
                console.log(data);


                $http({
                    method: 'POST',
                    url: 'http://localhost:8096/drools/validiraj',
                    data :validData
                }).then(function successCallback(response){

                    var odgovor = response.data;

                    console.log(odgovor);

                    if(odgovor.tekst !="OK"){

                        alert("The patient is allergic to some of the prescribed medicine, the diagnosis was not saved");

                    }else{

                        $http({
                            method: 'PUT',
                            url: 'http://localhost:8096/patient/'+ $scope.pacijentId +'/history',
                            data :data
                        }).then(function successCallback(response){

                            alert("Patient diagnosed successfully");
                            $location.path("/home");

                        });
                    }


                });

            }

        }
        

        var getIllness = function () {

            $http({
                method: 'GET',
                url: 'http://localhost:8096/illness',
            }).then(function successCallback(response){
                var temp = response.data;

                if(temp != null){
                    $scope.bolesti=temp;
                    for(var i =0; i< $scope.bolesti.length; i++){
                        $scope.bolesti[i].izabrano=false;
                    }

                }

            });
        }

        var getMedicine = function () {
            $http({
                method: 'GET',
                url: 'http://localhost:8096/medicine',
            }).then(function successCallback(response){
                var temp = response.data;

                if(temp != null){
                    $scope.lekovi=temp;
                    $scope.lekoviNajverovatnije= temp;
                    $scope.lekoviSvi = temp;
                    for(var i =0; i< $scope.lekovi.length; i++){
                        $scope.lekovi[i].izabrano=false;
                        $scope.lekoviNajverovatnije[i].izabrano=false;
                        $scope.lekoviSvi[i].izabrano=false;
                    }

                }

            });
        }

        var getAlergije = function () {

            $http({
                method: 'GET',
                url: 'http://localhost:8096/patient/alergije/'+$scope.pacijentId,
            }).then(function successCallback(response){
                $scope.alergije  = response.data;
            });

        }


        var getSastojak = function (id) {

            $http({
                method: 'GET',
                url: 'http://localhost:8096/medicine/sastojci/'+id,
            }).then(function successCallback(response){
                return response.data;
            });

        }

        var init = function (){

            var patientId = $stateParams.id;
            var userName = $cookies.get('user');
            if($cookies.get('user') == null || patientId == undefined){
                $location.path("/home")
            }else{

                $scope.pacijentId = patientId;

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
                            url: 'http://localhost:8096/patient/get/'+patientId
                        }).then(function successCallback(response){
                            $scope.patient = response.data;

                            if($scope.patient){


                                $http({
                                    method: 'GET',
                                    url: 'http://localhost:8096/symptom',
                                }).then(function successCallback(response){
                                    var temp = response.data;

                                    if(temp != null){
                                        $scope.symptom=temp;
                                        for(var i =0; i< $scope.symptom.length; i++){
                                            $scope.symptom[i].izabrano=false;
                                        }

                                    }

                                });

                            }


                        });


                    }

                });



            }



        };
        init();

        getIllness();

        getMedicine();

        getAlergije();

    }


})();