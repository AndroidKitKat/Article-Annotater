angular
	.module('ArticleAnnotater')
	.controller('NavbarCtrl', function($scope, $location, $auth) {
		$scope.isAuthenticated = function() {
			return $auth.isAuthenticated();
		};
		$scope.logout = function() {
			if (!$auth.isAuthenticated()) { return; }
			$auth.logout().then(function() {
				$location.path('/');
			});
		}
	});