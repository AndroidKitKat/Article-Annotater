(function() {
	var app = angular.module('comment-directive', ['pageslide-directive']);
//	  app.config(function($sceProvider) {
//		  $sceProvider.enabled(false);
//	  });
	app.directive('comment', function() {
		var controller = function($scope, $http) {
			$scope.myFace = "";
			$scope.myName = "Anonymous";
			$http.get('/user')
				.then(function (response) {
					var user = response.data;
					$scope.myFace = user.picture.data.url;
					$scope.myName = user.name;
				})
				.catch(function (response) {
					console.log("getUserInfo error", response);
				});
			$http.get('/comments?url=' + encodeURIComponent($scope.comment.url))
				.then(function (response) {
					$scope.comments = response.data;
				})
				.catch(function (response) {
					console.log("comments error", response);
				});

			$scope.open = false;
			$scope.toggle = function() {
				$scope.open = !$scope.open;
			}

			$scope.newComment = "";
			$scope.addComment = function() {
				var comment = {
					face: $scope.myFace,
					who: $scope.myName,
					when: new Date(),
					notes: $scope.newComment
				};

				$scope.comments.push(comment);
				$scope.newComment = "";

				var commentToSave = {};
				commentToSave.articleId = $scope.comment.url;
				commentToSave.comment = comment;
				var parameter = JSON.stringify(commentToSave);
				$http.post('/comment', parameter);
			};

			$scope.isNewCommentEmpty = function() {
				return $scope.newComment == null || $scope.newComment.length == 0;
			};

			$scope.$on('event:toggle', function(event, data) {
				$scope.toggle();
	    	});
	      };
	     
	      return {
	          restrict: 'EA', //Default for 1.3+
	          scope: {
	        	  url: '@url'
	          },
	          controller: controller,
	          controllerAs: 'comment',
	          bindToController: true, //required in 1.3+ with controllerAs
	          templateUrl: '/js/angular-component/comment/comment.html'
	      };
	  });
}());