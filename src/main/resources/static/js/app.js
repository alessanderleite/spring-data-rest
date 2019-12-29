var app = angular.module('app', []);

app.controller('UserCRUDCtrl', ['$scope', 'UserCRUDService', function($scope, UserCRUDService) {
	
	$scope.getUser = function() {
		var id = $scope.user.id;
		UserCRUDService.getUser($scope.user.id)
			.then(function success(response) {
				$scope.user = response.data;
				$scope.user.id = id;
				$scope.message = '';
				$scope.errorMessage = '';
			},
			function error (response) {
				$scope.message = '';
				if (response.status === 404) {
					$scope.errorMessage = 'User not found!';
				}
				else {
					$scope.errorMessage = 'Error getting user!';
				}
			});
	}
	
	$scope.getAllUsers = function() {
		UserCRUDService.getAllUsers()
			.then(function success(response) {
				$scope.users = response.data;
				$scope.message = '';
				$scope.errorMessage = '';
			},
			function error(response) {
				$scope.message = '';
				$scope.errorMessage = 'Error getting users!';
			});
	}
}]);

app.service('UserCRUDService', ['$http', function($http) {
	
	this.getUser = function getUser(userId) {
		return $http({
			method: 'GET',
			url: 'users/' + userId
		});
	}
	
	this.getAllUsers = function getAllUsers(){
        return $http({
          method: 'GET',
          url: 'users'
        });
    }
}]);