<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/reset.css">
<link rel="stylesheet" href="assets/css/supersized.css">
<link rel="stylesheet" href="assets/css/style.css">
<script src="js/modernizr.custom.63321.js"></script>
</head>
<script type="text/javascript">
	// 登录页面若在框架内，则跳出框架
	if (self != top) {
		top.location = self.location;
	};
</script>
<body>
	<div class="page-container">
		<form action="user!checkUser" method="post" autocomplete="off">
			<select>
				<option value="-1">User</option>
				<option value="1" selected>User</option>
				<option value="2">Employee</option>
				<option value="3">Administrator</option>
			</select> <input type="text" name="userName" class="username" placeholder="Username"> <input
				type="password" name="password" class="password" placeholder="Password"> <a
				href="register.jsp"><button class="register" type="button"
					style="background-color: #2359A4; border-color: #3476A4;">Register</button></a>
			<button type="submit">Sign in</button>
			<div class="error">
				<span>+</span>
			</div>
		</form>
	</div>

	<!-- Javascript -->
	<script src="assets/js/jquery-1.8.2.min.js"></script>
	<script src="assets/js/supersized.3.2.7.min.js"></script>
	<script src="assets/js/supersized-init.js"></script>
	<script src="assets/js/scripts.js"></script>
	<script src="js/jquery.dropdown.js"></script>
	<script>
		$(function() {
			$('select').dropdown({
				gutter : 5,
				stack : false,
				slidingIn : 100
			});
		});
	</script>
</body>

</html>