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
      }).state('core.symptom', {
          url: 'symptom',
          templateUrl: 'app/components/symptom/symptom.html',
          controller: 'symptomController',
          controllerAs: 'sc'
      }).state('core.addSymptom', {
          url: 'addSymptom',
          templateUrl: 'app/components/addSymptom/addSymptom.html',
          controller: 'addSymptomController',
          controllerAs: 'asc'
      }).state('core.editSymptom', {
          url: 'editSymptom',
          templateUrl: 'app/components/editSymptom/editSymptom.html',
          controller: 'editSymptomController',
          controllerAs: 'esc',
          params: {id :null}
      }).state('core.medicine', {
          url: 'medicine',
          templateUrl: 'app/components/medicine/medicine.html',
          controller: 'medicineController',
          controllerAs: 'mc'
      }).state('core.addMedicine', {
          url: 'addMedicine',
          templateUrl: 'app/components/addMedicine/addMedicine.html',
          controller: 'addMedicineController',
          controllerAs: 'amc'
      }).state('core.editMedicine', {
          url: 'editMedicine',
          templateUrl: 'app/components/editMedicine/editMedicine.html',
          controller: 'editMedicineController',
          controllerAs: 'emc',
          params: {id :null}
      }).state('core.illness', {
          url: 'illness',
          templateUrl: 'app/components/illness/illness.html',
          controller: 'illnessController',
          controllerAs: 'ilc'
      }).state('core.addIllness', {
          url: 'addIllness',
          templateUrl: 'app/components/addIllness/addIllness.html',
          controller: 'addIllnessController',
          controllerAs: 'ailc'
      }).state('core.editIllness', {
          url: 'editIllness',
          templateUrl: 'app/components/editIllness/editIllness.html',
          controller: 'editIllnessController',
          controllerAs: 'ailc',
          params: {id :null}
      }).state('core.ingredient', {
          url: 'ingredient',
          templateUrl: 'app/components/ingredient/ingredient.html',
          controller: 'ingredientController',
          controllerAs: 'ic'
      }).state('core.addIngredient', {
          url: 'addIngredient',
          templateUrl: 'app/components/addIngredient/addIngredient.html',
          controller: 'addIngredientController',
          controllerAs: 'aic'
      }).state('core.monitor', {
          url: 'monitor',
          templateUrl: 'app/components/monitor/monitor.html',
          controller: 'monitorController',
          controllerAs: 'mc'
      }).state('core.report', {
          url: 'report',
          templateUrl: 'app/components/report/report.html',
          controller: 'reportController',
          controllerAs: 'rc'
      }).state('core.editIngredient', {
          url: 'editIngredient',
          templateUrl: 'app/components/editIngredient/editIngredient.html',
          controller: 'editIngredientController',
          controllerAs: 'eic',
          params: {id :null}
      }).state('core.checkIllness', {
          url: 'checkIllness',
          templateUrl: 'app/components/checkIllness/checkIllness.html',
          controller: 'checkIllnessController',
          controllerAs: 'cic',
          params: {id :null}
      }).state('core.dijagnoza', {
          url: 'dijagnoza',
          templateUrl: 'app/components/dijagnoza/dijagnoza.html',
          controller: 'dijagnozaController',
          controllerAs: 'dic',
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
