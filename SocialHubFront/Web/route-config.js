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
				.when("/myBlog", {templateUrl : "c_blog/myBlog.html"})
				.when("/editprofile", {templateUrl : "c_user/editProfile.html"})
				.when("/blogcomment", {templateUrl : "c_blog/blogcomment.html"})
				.when("/showfriends",{templateUrl : "c_friend/friends.html"})
				.when("/friends",{templateUrl : "c_friend/friends.html"})
				.when("/friendrequests",{templateUrl : "c_friend/pendingRequests.html"})
				.when("/suggestedPeople",{templateUrl : "c_friend/SuggestedList.html"})

				.when("/addForum",{templateUrl : "c_forum/addForum.html"})
				.when("/myForum",{templateUrl : "c_forum/myForum.html"})
				.when("/showForum",{templateUrl : "c_forum/myForum.html"})
				.when("/allForum",{templateUrl : "c_forum/Forum.html"})
				.when("/contactus",	{templateUrl : "c_contactUs/ContactUs.html"})
				
				.when("/applyjob",{templateUrl : "c_job/jobapplicationform.html"})
				.when("/appliedjobs",{templateUrl : "c_job/appliedJobs.html"})
				.when("/postjob",{templateUrl : "c_job/PostJob.html"})
				.when("/jobs",{templateUrl : "c_job/jobs.html"})
				.when("/showjobs",{templateUrl : "c_job/jobs.html"})
				.when("/allapplications", {templateUrl : "c_job/adminjobapp.html"})
				
			});

