'use strict';

var contactControllers = angular.module('contactControllers', []);

contactControllers.controller('ContactListController', [ '$scope', '$rootScope', 'ContactService', '$location',
	function($scope, $rootScope, ContactService, $location) {	
		ContactService.getContacts()
	        .then(function (response) {
	            $scope.contacts = response.data;
	        }, function (error) {
	            $scope.status = 'Unable to load contact data: ' + error.message;
	        });
	}]);

contactControllers.controller('ContactDetailsController', [ '$scope', '$rootScope', 'ContactService', '$routeParams',
    function($scope, $rootScope, ContactService, $routeParams) {
		$rootScope.info = null;
		
		ContactService.getContactDetails($routeParams.contactId)
	        .then(function (response) {
	        	$scope.contact = response.data;
	        }, function (error) {
	            $scope.status = 'Unable to load contact details data: ' + error.message;
	        });
}]);

contactControllers.controller('AddContactController', ['$scope','$rootScope','ContactService','$location',                                                      
	function($scope, $rootScope, ContactService, $location) {
		$rootScope.info = null;
		$scope.createNewContact = function(contact) {
			ContactService.addContact(contact)
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



