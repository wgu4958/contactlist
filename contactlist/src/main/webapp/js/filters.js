'use strict';

var contactFilters = angular.module('contactFilters', []);

//format 10 digits to (999) 999-9999
contactFilters.filter('phonenumber', function() {
    return function (number) {
        if (!number || number.length != 10) { 
        	return ''; 
        }

        number = String(number);
        var formattedNumber = number;

        var area = number.substring(0,3);
        var front = number.substring(3, 6);
        var end = number.substring(6, 10);
        
        formattedNumber = "(" + area + ") " + front + "-" + end;

        return formattedNumber;
    };
});