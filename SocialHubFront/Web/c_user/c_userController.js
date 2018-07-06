myApp.controller("c_userController", function($scope, $http, $rootScope, $location)
{
	$scope.user={'loginname':'','password':'','username':'','emailid':'','mobile':'','role':'','address':''};
	
	$scope.CurrentUser;
	
	$scope.login = function()
	{
		console.log('Im in check login');		
		console.log($scope.user);
		$http.post('http://localhost:8081/SocialHubMiddelware/checkLogin', $scope.user)
		.then(function(response)
				{
					console.log("login function");
					$scope.user = response.data;
					$rootScope.CurrentUser = $scope.user;
					console.log("login Successful: ");
					
					$location.path("/loggedin");
				}
			);
	}
	
	$scope.register = function()
	{
		console.log("register page");
		console.log("email" + $scope.user.emailId);
		console.log("password" + $scope.user.password);
		
		$http.post('http://localhost:8081/SocialHubMiddelware/registerUser', $scope.user)
		.then(function(response)
				{
				alert("added successfully")
					console.log("registered successfully");
					console.log(response.statusText);
					$location.path("/login");
					
				}
			);
	}
	

});