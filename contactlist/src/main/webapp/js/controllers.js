'use strict';

var contactControllers = angular.module('contactControllers', []);

contactControllers.controller('ContactListController', [ '$scope', '$rootScope', 'ContactFactory', '$location',
	function($scope, $rootScope, ContactFactory, $location) {	
		getContacts();
	
		function getContacts() {
			ContactFactory.getContacts()
		        .then(function (response) {
		            $scope.contacts = response.data;
		        }, function (error) {
		            $scope.status = 'Unable to load contact data: ' + error.message;
		        });
		}
		
		$scope.getContactDetails = function(contactId) {
			ContactFactory.getContactDetails(contactId)
	        .then(function (response) {
	        	$rootScope.contact = response.data;
	            $location.path('contact-details');
	        }, function (error) {
	            $scope.status = 'Unable to load contact details data: ' + error.message;
	        });
		}
	}]);

contactControllers.controller('AddContactController', ['$scope','$rootScope','ContactFactory','$location',                                                      
	function($scope, $rootScope, ContactFactory, $location) {
		
		$scope.createNewContact = function(contact) {
			ContactFactory.addContact(contact)
			.then(function(response) {
				var message = response.data;
				console.log("Response code: " + message.code + " with message: " + message.message);
				if (message.code == 0) {
					$location.path('/contacts');
					$rootScope.info = message.message;
				} else {
					$scope.error = message.message;
				}
			}, 
			function(error) {
				$scope.error = error;
				console.log("The request failed with error " + error);
			});
		}
	} ]);



