 angular
    	.module('ArticleAnnotater')
    	.controller('ExtractorCtrl', function($scope, $http, $sce) {
			$scope.url = "";
			$scope.article = "";

			$scope.extract = function() {
				$http
					.get('/article?url=' + encodeURIComponent($scope.url))
			        .success(function(data) {
			            $scope.article = $sce.trustAsHtml(data.text);
			        });
			};
			$scope.isUrlEmpty = function() {
				return $scope.url == null || $scope.url.length == 0;
			};
		});