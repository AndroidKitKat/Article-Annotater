angular
	.module('ArticleAnnotater')
	.directive('navbar', function () {
		return {
	          restrict: 'EA', //Default for 1.3+
	          controller: 'NavbarCtrl',
	          controllerAs: 'vm',
	          bindToController: true, //required in 1.3+ with controllerAs
	          templateUrl: '/navbar/navbar.html'
		};
	});