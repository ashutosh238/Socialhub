myApp.controller("c_contactController", function($scope, $http, $rootScope, $location,$route)
		{
	$scope.suggestion = {'name':'', 'emailid':'', 'added_date':'', 'message':''}
	
	
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
	});