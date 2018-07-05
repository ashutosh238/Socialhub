myApp.controller("c_friendController", function($scope, $rootScope, $location, $http, $route)
{
	$scope.Friend = {'friendid':0, 'friendloginname':' ', 'loginname':' ', 'status':' '}
	
	$scope.user={'loginname':'','password':'','username':'','emailid':'','mobile':'','role':'','address':''}
	$scope.CurrentUser;
	$scope.friendlistsize;
	$scope.requestlistsize;
	$scope.friends;
	$scope.suggestedList;
	$scope.pendingRequests;
	
	function friendList()
	{
		$http.get('http://localhost:8081/SocialHubMiddelware/friend/list/'+$rootScope.CurrentUser.loginname)
		.then(function(response)
				{
					console.log("i am in friend List function");
					$scope.friends = response.data;
					$scope.friendlistsize = response.data;
					
				},
				function(response)
				{
					$scope.friendlistsize = undefined;
				});
	}
	friendList();


	function pendingFriendRequests()
	{
		$http.get('http://localhost:8081/SocialHubMiddelware/friend/pendingRequest')
		.then(function(response)
				{
					console.log("pending request list function");
					$scope.pendingRequests = response.data;
					$scope.requestlistsize = response.data;
				},
				function(response)
				{
					$scope.requestlistsize = undefined;
				});
	}
	pendingFriendRequests();
	
	
	$scope.sendRequest = function(username)
	{
		$http.get('http://localhost:8081/SocialHubMiddelware/friend/sendRequest/'+username)
		.then(function(response)
				{
					console.log("Friend Request Sent");
					/*$location.path("/friendrequests");*/
					$route.reload();
				});
	}
	
	
	$scope.acceptRequest = function(friendid)
	{
		$http.post('http://localhost:8081/SocialHubMiddelware/friend/acceptRequest/'+friendid)
		.then(function(response)
				{
					console.log("Friend Request Accepted");
					$location.path("/friends");
				});
	}
	
	
	$scope.deleteRequest = function(friendid)
	{
		$http.delete('http://localhost:8081/SocialHubMiddelware/friend/deleteRequest/'+friendid)
		.then(function(response)
				{
					console.log("Friend Request Deleted");
					/*$location.path("/friends");*/
					$route.reload();
				});
	}
	
	function SuggestedList()
	{
		console.log('Suggested List Displaying');
		$http.get('http://localhost:8081/SocialHubMiddelware/friend/suggested')
		.then(function(response)
				{
					$scope.suggestedList = response.data;
				});
	}
	SuggestedList();
	
	$scope.unfriend = function(friendid)
	{
		$http.delete('http://localhost:8081/SocialHubMiddelware/friend/deleteRequest/'+friendid)
		.then(function(response)
				{
					console.log("Friend Removed Successfully");
					/*$location.path("/showfriends");*/
					$route.reload();
				});
	}
	
});