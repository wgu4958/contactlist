'use strict'

angular.module('contactServices',[]).factory('ContactFactory', ['$http', function($http) {
	
	var urlBase = '/contactlist/rest/contactservices/contacts';
	var dataFactory = {};
	
	dataFactory.getContacts = function () {
	    return $http.get(urlBase);
	};

	dataFactory.getContactDetails = function (contactId) {
	    return $http.get(urlBase + '/' + contactId);
	};

	dataFactory.addContact = function (contact) {
	    return $http({
	        url: urlBase,
	        dataType: 'json',
	        method: 'POST',
	        data: JSON.stringify(contact),
	        headers: {
	            "Content-Type": "application/json"
	        }
	    })  
	};
	return dataFactory;
}]);

