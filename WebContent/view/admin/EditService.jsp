<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>New Role | Strass</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Admin panel developed with the Bootstrap from Twitter.">
<meta name="author" content="travis">

<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/site.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">Strass Administration</a>
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
						<li><a href="view/admin/main3.jsp">Home</a></li>
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
						<li class="active"><a href="#">Serve</a></li>
						<li><a href="admin!showOrder">Order</a></li>
						<li><a href="admin!serveApply">Apply</a></li>
						<li class="nav-header"><i class="icon-user"></i> Profile</li>
						<li><a href="admin!editUser?userId=${currentUser.id }">My profile</a></li>
						<li><a href="user!logout">Logout</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<div class="row-fluid">
					<div class="page-header">
						<h1>
							Service<small> Update info</small>
						</h1>
					</div>
					<form class="form-horizontal" action="admin!submitEdit" method="post" onsubmit="alert('ok!')">
						<fieldset>
							<div class="control-group">
								<label class="control-label" for="role">Service Name</label>
								<div class="controls">
									<input type="text" class="input-xlarge" id="role" name="sname" required
										value="${serve.name }" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="description">Description</label>
								<div class="controls">
									<textarea class="input-xlarge" id="description" name="des" rows="6">${serve.description }</textarea>
								</div>
							</div>
							<input type="hidden" value="${serve.id }" name="serveId">
							<div class="form-actions">
								<input type="submit" class="btn btn-success btn-large" value="Save" /> <a class="btn"
									href="admin!showServe">Cancel</a>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
