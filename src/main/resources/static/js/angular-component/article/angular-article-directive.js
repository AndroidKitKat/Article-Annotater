(function() {
	  var app = angular.module('article-directive', []);
	  app.config(function($sceProvider) {
		  // Completely disable SCE.  For demonstration purposes only!
		  // Do not use in new projects.
		  $sceProvider.enabled(false);
	  });
	  app.directive('article', function () {
	      var controller = function () {
	          var vm = this;
	      };    
	
	      var link = function link(scope, element, attrs) {
	    	  scope.toggleComments = function () {
				scope.$broadcast("event:toggle");
	    	  }
	      };
	     
	      return {
	          restrict: 'EA', //Default for 1.3+
	          scope: {
	        	  text: '@text'
	          },
	          controller: controller,
	          link: link,
	          controllerAs: 'vm',
	          bindToController: true, //required in 1.3+ with controllerAs
	          templateUrl: '/js/angular-component/article/article.html'
	      };
	  });
}());