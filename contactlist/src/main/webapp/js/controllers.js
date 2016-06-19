'use strict';

var contactControllers = angular.module('contactControllers',[]);
		
contactControllers.controller('ContactListController', ['$scope', 'ContactFactory', '$location',
  function ($scope, ContactFactory, $location) {
	
    /* for ng-click 'createNewContact': */
    $scope.createNewContact = function () {
      $location.path('/add-contact');
    };

    $scope.contacts = ContactFactory.query();
  }]);

contactControllers.controller('AddContactController', ['$scope', 'ContactFactory', '$location',
    function ($scope, ContactFactory, $location) {

      /* for ng-click 'createNewContact': */
      $scope.createNewContact = function () {
    	  ContactFactory.create($scope.contact) 
    	  .success(function(result) {  
    	     console.log("New contact was successfully added.");
    	     $scope.info = "New contact was successfully added.";
     		$location.path('/contacts');
    	  })
    	  .error(function(response, status) {  
    	     console.log("The request failed with response " + response + " and status code " + status);
    	  });	  
      }
    }]);
