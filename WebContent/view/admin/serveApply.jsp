<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Roles | Strass</title>
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
					<a class="btn" href="admin!editUser?userId=${currentUser.id }"><i class="icon-user"></i> Admin</a> <a
						class="btn dropdown-toggle" data-toggle="dropdown" href="#"> <span class="caret"></span>
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
						<li><a href="admin!showServe">Serve</a></li>
						<li><a href="admin!showOrder">Order</a></li>
						<li class="active"><a href="#">Apply</a></li>
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
							Service <small>Manage service</small>
						</h1>
					</div>
					<table class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>No.</th>
								<th>Service</th>
								<th>Employee</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#request.saList" var="sa" status="st">
								<tr class="list-roles">
									<td><s:property value="#st.index+1" /></td>
									<td><s:property value="#sa.serve.name" /></td>
									<td><s:property value="#sa.employee.user.name" /></td>
									<td width="15%"><a href="admin!serveApply2?id=<s:property value="#sa.id" />&flag=1" onclick="alert('ok')" class="label label-success">Approve</a></td>
									<td width="15%"><a href="admin!serveApply2?id=<s:property value="#sa.id" />&flag=2" onclick="alert('ok')" class="label label-important">Reject</a></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.dropdown-menu li a').hover(function() {
				$(this).children('i').addClass('icon-white');
			}, function() {
				$(this).children('i').removeClass('icon-white');
			});
		});
	</script>
</body>
</html>
