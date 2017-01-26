<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>My Profile | Strass</title>
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
						<c:choose>
							<c:when test="${currentUser.id==user.id }">
								<li><a href="admin!showUser">Users</a></li>
							</c:when>
							<c:otherwise>
								<li class="active"><a href="#">Users</a></li>
							</c:otherwise>
						</c:choose>
						<li><a href="admin!showServe">Serve</a></li>
						<li><a href="admin!showOrder">Order</a></li>
						<li><a href="admin!serveApply">Apply</a></li>
						<li class="nav-header"><i class="icon-user"></i> Profile</li>
						<c:choose>
							<c:when test="${currentUser.id==user.id }">
								<li class="active"><a href="#">My profile</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="admin!editUser?userId=${currentUser.id }">My profile</a></li>
							</c:otherwise>
						</c:choose>
						<li><a href="user!logout">Logout</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<div class="row-fluid">
					<div class="page-header">
						<h1>
							Users <small>Update info</small>
						</h1>
					</div>
					<form class="form-horizontal" action="register!submitEdit" onsubmit="alert('ok!')"
						method="post">
						<fieldset>
							<input type="hidden" name="id" value="${user.id }">
							<div class="control-group">
								<label class="control-label" for="name">Name</label>
								<div class="controls">
									<input type="text" class="input-xlarge" id="name" name="name" value="${user.name }" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="email">E-mail</label>
								<div class="controls">
									<input type="email" class="input-xlarge" id="email" name="email" value="${user.email }" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="phone">Phone</label>
								<div class="controls">
									<input type="text" class="input-xlarge" pattern="\d{8,12}" oninput="setCustomValidity('');"
										oninvalid="setCustomValidity('wrong phone number');" id="phone" name="phone"
										value="${user.phone }" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="age">Age</label>
								<div class="controls">
									<input type="number" max="120" min="1" class="input-xlarge" id="age" name="age"
										value="${user.age }" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="role">Sex</label>
								<div class="controls">
									<select id="role" name="sex">
										<option value="male" selected>Male</option>
										<option value="female">Female</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="bir">Birthdate</label>
								<div class="controls">
									<input type="date" class="input-xlarge" id="bir" name="birthdate" value="${user.birthdate}" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="add">Address</label>
								<div class="controls">
									<input type="text" class="input-xlarge" id="add" name="address" value="${user.address }" />
								</div>
							</div>
							<div class="form-actions">
								<input type="submit" class="btn btn-success btn-large" value="Save Changes" />
								<c:choose>
									<c:when test="${currentUser.id==user.id }">
										<a class="btn" href="view/admin/main3.jsp">Cancel</a>
									</c:when>
									<c:otherwise>
										<a class="btn" href="admin!showUser">Cancel</a>
									</c:otherwise>
								</c:choose>
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
