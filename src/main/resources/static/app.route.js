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
		}).state('core.profile', {
          url: 'profile',
          templateUrl: 'app/components/profile/profile.html',
          controller: 'profileController',
          controllerAs: 'pc'
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
