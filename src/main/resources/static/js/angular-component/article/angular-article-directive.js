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
      
          function init() {
              vm.items = angular.copy(vm.text);
          }
          
          init();
          
          vm.addItem = function () {
              vm.add();

              //Add new customer to directive scope
              vm.items.push({
                  name: 'New Directive Controller Item'
              });
          };
      };    

      return {
          restrict: 'EA', //Default for 1.3+
          scope: {
        	  text: '@text',
              add: '&',
          },
          controller: controller,
          controllerAs: 'vm',
          bindToController: true, //required in 1.3+ with controllerAs
          templateUrl: '/js/angular-component/article/article.html'
      };
  });

}());