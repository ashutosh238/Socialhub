myApp.controller("c_blogController", function($scope, $http, $rootScope, $location,$route)
{
	$scope.blog = {'blogname':'', 'blogcontent':'', 'createdate':'', 'loginname':'', 'status':'', 'likes':0, 'dislikes':0, 'blogId':0}
	$scope.blogComment = {'blogid':'','commenttext':'', 'loginname':'', 'commentdate':'','commentid':'' }
	$scope.allBlogData;
	$scope.commentid;
	
	$scope.addBlog = function()
	{
		console.log("This is add Blog Function");		
		$http.post('http://localhost:8081/SocialHubMiddelware/addBlog', $scope.blog)
		.then(function(response)
				{
					alert('Addded Successfully');
					console.log(response.statusText);
					$location.path("/myBlog");					
				});
	}
	
	
	$scope.deleteblog = function(blogId)
	{
		console.log("deleting blog");		
		$http.get('http://localhost:8081/SocialHubMiddelware/deleteBlog/'+blogId)
		.then(function(response)
				{
					alert("blog deleted");
					console.log(response.statusText);
					$location.path("/showBlog");
				});
	}

	
	function showBlog()
	{
		$http.get('http://localhost:8081/SocialHubMiddelware/listBlogs')
		.then(function(response){
			$scope.allBlogData=response.data;
			console.log($scope.allBlogData);
		});
	};
	
	$scope.approve=function(blogId)
	{
		$http.get('http://localhost:8081/SocialHubMiddelware/blog/approve/'+blogId)
		.then(function(response){
			console.log('Approving the Blog');
		});
		
	}
	
	$scope.reject=function(blogId)
	{
		$http.get('http://localhost:8081/SocialHubMiddelware/blog/reject/'+blogId)
		.then(function(response){
			console.log('Rejecting the Blog');
		});
	}
	
	$scope.incLike=function(blogId)
	{
		$http.get('http://localhost:8081/SocialHubMiddelware/blog/incLike/'+blogId)
		.then(function(response){
			console.log('Incrementing the Likes in Blog');
		});
	}
	
	$scope.incDisLike=function(blogId)
	{
		$http.get('http://localhost:8081/SocialHubMiddelware/blog/incDisLike/'+blogId)
		.then(function(response){
			console.log('Decrementing the Likes in Blog');
		});
	}
	
	$scope.commentedblog = function(blogid)
	{
		$http.get('http://localhost:8081/SocialHubMiddelware/getBlog/'+blogid)
		.then(function(response)
				{
					$rootScope.commentid = blogid;
					$location.path("/blogcomment");
				});
		
}
	
	$scope.commentblog = function()
	{
		$http.post('http://localhost:8081/SocialHubMiddelware/blog/comment/', $scope.blogComment)
		.then(function(response)
				{
					$route.reload();
					alert("Thank u for commenting");
					console.log("commented succesfully");
				});
}
	
	
	function commentlist()
	{
		$http.post('http://localhost:8081/SocialHubMiddelware/blog/listComments/'+$rootScope.commentid)
		.then(function(response)
				{
					console.log("loading comments");
					$rootScope.commentedData = response.data;
				});
	}
commentlist();
	showBlog();
});
