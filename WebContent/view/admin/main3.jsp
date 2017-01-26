<!DOCTYPE html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>Admin | Strass</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/site.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
</head>

<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="brand">Strass Administration</a>
				<div class="btn-group pull-right">
					<a class="btn" href="admin!editUser?userId=${currentUser.id }"><i class="icon-user"></i>
						Admin</a> <a class="btn dropdown-toggle" data-toggle="dropdown" href="#"> <span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="admin!editUser?userId=${currentUser.id }">Profile</a></li>
						<li class="divider"></li>
						<li><a href="user!logout">Logout</a></li>
					</ul>
				</div>
				<div class="nav-collapse">
					<ul class="nav">
						<li><a>Home</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header"><i class="icon-wrench"></i> Administration</li>
						<li><a href="admin!showUser">Users</a></li>
						<li><a href="admin!showServe">Serve</a></li>
						<li><a href="admin!showOrder">Order</a></li>
						<li><a href="admin!serveApply">Apply</a></li>
						<li class="nav-header"><i class="icon-user"></i> Profile</li>
						<li><a href="admin!editUser?userId=${currentUser.id }">My profile</a></li>
						<li><a href="user!logout">Logout</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<div class="well hero-unit">
					<h1>Welcome, Admin</h1>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Etiam eget ligula eu lectus
						lobortis condimentum. Aliquam nonummy auctor massa. Pellentesque habitant morbi tristique
						senectus et netus et malesuada fames ac turpis egestas.</p>
					<p>
						<a class="btn btn-success btn-large" href="admin!showUser">Manage Users &raquo;</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>