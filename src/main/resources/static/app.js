 angular
    	.module('ArticleAnnotater', 
    			['ngMaterial', 'ui.router', 'article-directive',
    			 'comment-directive', 'satellizer'])
    	.config(function($stateProvider, $urlRouterProvider, $authProvider) {
			$stateProvider
				.state('home', {
					url: '/',
					controller: 'HomeCtrl',
					templateUrl: 'home/home.html'
				})
				.state('extractor', {
					url: '/extractor',
					controller: 'ExtractorCtrl',
					templateUrl: 'extractor/extractor.html',
					resolve: {
						loginRequired: loginRequired
			        }
				})
				.state('login', {
					url: '/login',
					templateUrl: 'login/login.html',
					controller: 'LoginCtrl',
					resolve: {
					  skipIfLoggedIn: skipIfLoggedIn
					}
				});

			$urlRouterProvider.otherwise('/');

			$authProvider.facebook({
				clientId: '217136761769180'
			});

			function skipIfLoggedIn($q, $auth) {
				var deferred = $q.defer();
				if ($auth.isAuthenticated()) {
					deferred.reject();
				} else {
					deferred.resolve();
				}
				return deferred.promise;
			}

			function loginRequired($q, $location, $auth) {
				var deferred = $q.defer();
				if ($auth.isAuthenticated()) {
					deferred.resolve();
				} else {
					$location.path('/login');
				}
				return deferred.promise;
			}
    	});
		