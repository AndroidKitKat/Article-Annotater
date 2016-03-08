 angular
    	.module('ArticleAnnotater')
    	.controller('ExtractorCtrl', function($scope, $http, $sce) {
			$scope.url = "";
			$scope.article = "";
			$scope.displayProgressBar = false;

			$scope.extract = function() {
				$scope.displayProgressBar = true;
				$http
					.get('/article?url=' + encodeURIComponent($scope.url))
			        .success(function(data) {
			        	$scope.displayProgressBar = false;
			            $scope.article = $sce.trustAsHtml(data.text);
			        });
			};
			$scope.isUrlEmpty = function() {
				return $scope.url == null || $scope.url.length == 0;
			};
		});