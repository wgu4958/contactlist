'use strict';

var myApp = angular.module('contactApp', ['ngRoute', 'contactControllers', 'contactServices','ui.mask']);

myApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
	    when('/contacts', {
	    	templateUrl: 'pages/ContactList.htm', 
	    	controller: 'ContactListController'
	    }).
	    when('/add-contact', {
	    	templateUrl: 'pages/AddContact.htm', 
	    	controller: 'AddContactController'
	    }).
	    otherwise({
	    	redirectTo: '/contacts'
	    });
}]);