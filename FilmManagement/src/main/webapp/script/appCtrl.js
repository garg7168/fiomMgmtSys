app.controller('myCtrl',function($scope,$http){
		
	var url='http://localhost:8080/FilmManagement/ListOfAllActors';
	
	$http.get(url)
		.success(function(response){
			console.log(response);
			$scope.actor=response;
		});
	
	});

app.controller('myCtrl1',function($scope,$http){
	
	var url='http://localhost:8080/FilmManagement/ListOfAllFilms';
	
	$http.get(url)
		.success(function(response){
			console.log(response);
			$scope.film=response;
		});
	
	});
