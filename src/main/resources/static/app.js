 angular
    	.module('ArticleAnnotater', ['ngMaterial', 'ui.router', 'article-directive', 'comment-directive'])
    	.config(function($stateProvider, $urlRouterProvider) {
			$stateProvider
			  .state('home', {
			    url: '/',
			    controller: 'ExtractorCtrl',
			    templateUrl: 'extractor/extractor.html'
			  });

			  $urlRouterProvider.otherwise('/');;
    	});
		