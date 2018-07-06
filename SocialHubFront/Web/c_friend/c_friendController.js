myApp.controller("c_friendController", function($scope, $rootScope, $location, $http, $route)
{
	
	
	$scope.user={'loginname':'','password':'','username':'','emailid':'','mobile':'','role':'','address':''}
	$scope.friend = {'friendid':'','loginname':'','friendname':'','status':''};
	
	$scope.friends;
	$scope.requestlistsize;
	
	$scope.suggestedList;
	$scope.pendingRequests;
	
	function friendList()
	{
		
		$http.get('http://localhost:8081/SocialHubMiddelware/friend/list')
		.then(function(response)
				{
					console.log("i am in friend List function");
					
					$scope.friends = response.data;
					
				});
	};
	friendList();
	
});