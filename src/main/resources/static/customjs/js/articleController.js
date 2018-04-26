module = angular.module('articleApp', []);
module.controller('ArticleController', ['$http', '$scope', '$window', '$controller', function ($http, $scope, $window, $controller) {
	 	
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
	    $http.defaults.headers.common[header] = token;
	    console.log(token);
	    
	    $scope.addArticle = function(article, form){
        	
        	  	$http({
	                method: "POST",
	                url: "/api/v1/article/create",
	                data: article,
	            }).then(function mySucces(response) {
	            		$scope.createStatus="Article created";
	            }, function myError(response) {
	            		$scope.createStatus="Error in article creation";
	            });

        };
        
        $scope.loadAllArticles = function(idf){
        
	        	$http({
	                method: "GET",
	                url: "/api/v1/article/findall",
	                params: {}
	            }).then(function succes(response) {
	               
	            		$scope.articles = response.data;
	                
	            }, function error(response) {
	            });
        };

    }])
    