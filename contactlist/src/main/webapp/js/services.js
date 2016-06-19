'use strict'

var contactServices = angular.module('contactServices', ['ngResource']);

contactServices.factory('ContactFactory', function ($resource) {
	return $resource('/contactlist/rest/contactservices/contacts', {}, {
		query: {
			method: 'GET',
			params: {},
			isArray: true
        },
        create: { 
        	method: 'POST'
        }
	});
});
