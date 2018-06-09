(function () {
    'use strict';

    angular
		.module('app')
        .config(['$stateProvider', '$urlRouterProvider', '$locationProvider', function($stateProvider, $urlRouterProvider, $locationProvider) {

      $urlRouterProvider.otherwise("/home");

      $stateProvider
		 .state('core', {
			 url: '/',
			 templateUrl: 'app/components/core/core.html',
			 controller: 'coreController',
			 controllerAs: 'cc'
		 })
		 .state('core.home', {
			 url: 'home',
			 templateUrl: 'app/components/home/home.html',
			 controller: 'homeController',
			 controllerAs: 'hc'
		}) .state('core.admin', {
          url: 'admin',
          templateUrl: 'app/components/admin/admin.html',
          controller: 'adminController',
          controllerAs: 'ac'
        }).state('core.profile', {
          url: 'profile',
          templateUrl: 'app/components/profile/profile.html',
          controller: 'profileController',
          controllerAs: 'pc'
        }).state('core.editProfile', {
          url: 'editProfile',
          templateUrl: 'app/components/editProfile/editProfile.html',
          controller: 'editProfileController',
          controllerAs: 'epc',
          params: {id :null}
      }).state('core.addProfile', {
          url: 'addProfile',
          templateUrl: 'app/components/addProfile/addProfile.html',
          controller: 'addProfileController',
          controllerAs: 'apc'
      }).state('core.patient', {
          url: 'patient',
          templateUrl: 'app/components/patient/patient.html',
          controller: 'patientController',
          controllerAs: 'pac'
      }).state('core.addPatient', {
          url: 'addPatient',
          templateUrl: 'app/components/addPatient/addPatient.html',
          controller: 'addPatientController',
          controllerAs: 'apac'
      }).state('core.editPatient', {
          url: 'editPatient',
          templateUrl: 'app/components/editPatient/editPatient.html',
          controller: 'editPatientController',
          controllerAs: 'epac',
          params: {id :null}
      }).state('core.login', {
          url: 'login',
          templateUrl: 'app/components/login/login.html',
          controller: 'loginController',
          controllerAs: 'lc'
      });
     /* $locationProvider.html5Mode({
    	  enabled: true,
    	  requireBase: false
    	});*/
    }]);


})();
