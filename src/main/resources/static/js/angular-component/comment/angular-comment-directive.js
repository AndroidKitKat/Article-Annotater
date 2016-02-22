(function() {
	  var app = angular.module('comment-directive', ['pageslide-directive']);
	  app.config(function($sceProvider) {
		  $sceProvider.enabled(false);
	  });
	  app.directive('comment', function() {
	      var controller = function($scope) {
				var commentController = this;
				$scope.open = false; // This will be binded using the ps-open attribute
				commentController.toggle = function() {
					$scope.open = !$scope.open
				}

				$scope.$on('event:toggle', function(event, data) {
					commentController.toggle();
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