var myApp=angular.module("myApp", ["ngRoute"]);

myApp.config(
			function($routeProvider)
			{
				alert("i am route configuration file")
				
				$routeProvider
			
				.when("/",{templateUrl : "/index.html"})
				.when("/login",	{templateUrl : "c_user/login.html"})
				.when("/loggedin",{templateUrl : "welcomepage.html"})
				.when("/register",{templateUrl : "c_user/register.html"})
				.when("/addBlog",{templateUrl : "c_blog/addBlog.html"})
				.when("/allBlog",{templateUrl : "c_blog/showBlog.html"})
				.when("/editprofile", {templateUrl : "c_user/editProfile.html"})

				
				
			});

