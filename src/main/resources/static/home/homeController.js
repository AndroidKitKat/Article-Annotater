 angular
    	.module('ArticleAnnotater')
    	.controller('HomeCtrl', function($scope) {
			$scope.url = "";
			$scope.article = "";
			$scope.displayProgressBar = false;

			$scope.isUrlEmpty = function() {
				return $scope.url == null || $scope.url.length == 0;
			};
		});