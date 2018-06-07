﻿(function () {
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
		 })
		  .state('core.inbox', {
          url: 'inbox',
          templateUrl: 'app/components/inbox/inbox.html',
          controller: 'inboxController',
          controllerAs: 'ic'
      })
		.state('core.profile', {
			url: 'profile',
			templateUrl: 'app/components/profile/profile.html',
			controller: 'profileController',
			controllerAs: 'pc'
		});
     /* $locationProvider.html5Mode({
    	  enabled: true,
    	  requireBase: false
    	});*/
    }]);


})();
