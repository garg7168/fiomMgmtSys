var app=angular.module('myApp1',['ngRoute']);

app.config(function($routeProvider){
	$routeProvider
		.when('/',{
			template : '<h1>Welcome To Film Management System</h1>'
			
		})
		.when('/create',{
			//template : '<h1> Create Page</h1>'
			templateUrl : 'createFilm.html',
			controller : 'filmCreateCtrl'
		})
		.when('/update',{
			//template : '<h1> Update Page</h1>',
			templateUrl : 'updateFilm.html',
				controller : 'filmUpdateCtrl'
		})
		.when('/delete',{
			template : '<h1> Delete Page</h1>'
		})
		.when('/listall',{
			//template : '<h1> ListAll Page</h1>'
			templateUrl : 'ListOfAllFilms.html',
				controller:'myCtrl1'
		})
		.when('/search',{
			//template : '<h1> Search Page</h1>'
			templateUrl : 'SpecificFilm.html',
			controller:'myCtrlSpecificFilm'
		})
		.when('/logout',{
			template : '<h1> Logout Page</h1>'
		})
	
});


app.controller('filmCreateCtrl',function($scope){
	$scope.heading='Film Details';
});


app.controller('filmUpdateCtrl',function($scope){
	$scope.heading='Film Details';
});

app.controller('myCtrl1',function($scope,$http){
	
	var url='http://localhost:8080/FilmManagement/ListOfAllFilms';
	
	$http.get(url)
		.success(function(response){
			console.log(response);
			$scope.film=response;
		});
	
	});

app.controller('myCtrlSpecificFilm',function($scope,$http){
	
	var url='http://localhost:8080/FilmManagement/SpecificFilm';
	
	$http.get(url)
		.success(function(response){
			console.log(response);
			$scope.film=response;
		});
	
	});