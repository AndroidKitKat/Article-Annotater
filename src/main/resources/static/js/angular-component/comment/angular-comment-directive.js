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
		          })

	    	var imagePath = 'https://material.angularjs.org/latest/img/list/60.jpeg?0';
		    $scope.comments = [
		      {
		        face : imagePath,
		        who: 'Min Li Chan',
		        when: '3:08PM',
		        notes: " Secondary line text Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam massa quam."
		        		+ "Nulla metus metus, ullamcorper vel, tincidunt sed, euismod in, nibh. Quisque volutpat condimentum"
		        		+ "velit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos."
		      },
		      {
		        face : imagePath,
		        who: 'Min Li Chan',
		        when: '3:08PM',
		        notes: " I'll be in your neighborhood doing errands"
		      }
		    ];

			$scope.open = false;
			$scope.toggle = function() {
				$scope.open = !$scope.open;
			}

			$scope.newComment = "";
			$scope.addComment = function() {
				var comment = {
				        face : $scope.myFace,
				        who: $scope.myName,
				        when: '3:08PM',
				        notes: $scope.newComment
				      };
				$scope.comments.push(comment);
				$scope.newComment = "";
			}

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
	        	  open: '@text'
	          },
	          controller: controller,
	          controllerAs: 'comment',
	          bindToController: true, //required in 1.3+ with controllerAs
	          templateUrl: '/js/angular-component/comment/comment.html'
	      };
	  });
}());