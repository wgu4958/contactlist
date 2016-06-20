'use strict';

var contactControllers = angular.module('contactControllers', []);

contactControllers.controller('ContactListController', [ '$scope', 'ContactFactory', '$location',
	function($scope, ContactFactory, $location) {

		/* for ng-click 'createNewContact': */
		$scope.createNewContact = function() {
			$location.path('/add-contact');
		};

		$scope.contacts = ContactFactory.query();
	} ]);

contactControllers.controller('AddContactController', ['$scope','$rootScope','ContactFactory','$location',
	function($scope, $rootScope, ContactFactory, $location) {

		/* for ng-click 'createNewContact': */
		$scope.createNewContact = function() {
			ContactFactory.create($scope.contact).$promise.then(function(message) {
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
