 angular
    	.module('ArticleAnnotater')
    	.controller('HomeCtrl', function($scope, $http) {
			$scope.url = "";
			$scope.article = "";
			$scope.displayProgressBar = false;

			$http.get('/article')
				.then(function (response) {
					$scope.articles = response.data;
				})
				.catch(function (response) {
					console.log("article error", response);
				});

			$scope.isUrlEmpty = function() {
				return $scope.url == null || $scope.url.length == 0;
			};
		});