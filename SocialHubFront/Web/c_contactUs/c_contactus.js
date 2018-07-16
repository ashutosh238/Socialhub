myApp.controller("c_contactController", function($scope, $http, $rootScope, $location,$route)
		{
	$scope.suggestion = {'name':'', 'emailid':'', 'message':'', 'added_date':''}
	$scope.allsuggestion
	
	$scope.addSuggestion = function()
	{
		console.log("This is add Suggestion Function");		
		$http.post('http://localhost:8081/SocialHubMiddelware/addSuggestion', $scope.suggestion)
		.then(function(response)
				{
					alert('Addded Successfully');
					console.log(response.statusText);
									
				});
	}
	
	function showSuggestion()
	{
		$http.get('http://localhost:8081/SocialHubMiddelware/listSuggestions')
		.then(function(response){
			$scope.allsuggestion=response.data;
			console.log($scope.allsuggestion);
		});
	}
	showSuggestion();
	});