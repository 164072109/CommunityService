<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	errorPage="error.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Users | Strass</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/site.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="brand" href="#">Strass Administration</a>
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
						<li class="active"><a>Order</a></li>
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
							Orders <small>All orders</small>
						</h1>
					</div>
					<table class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>No.</th>
								<th>State</th>
								<th>User</th>
								<th>Employee</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#request.orderList" var="order" status="st">
								<tr class="list-users">
									<td><s:property value="#st.index+1" /></label></td>
									<td><s:property value="#order.state" /></td>
									<td><s:property value="#order.user.name" /></td>
									<td><s:property value="#order.employee.user.name" /></td>
									<td>NICO</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<div class="pagination">
						<ul>
							<s:if test="#request.page.hasPrePage==false">
								<li class="disabled"><a>Prev</a></li>
							</s:if>
							<s:else>
								<li><a href="admin!showOrder?cp=${page.currentPage-1 }">Prev</a></li>
							</s:else>
							<s:iterator begin="1" end="#request.page.totalPage" status="st">
								<s:if test="#st.index+1==#request.page.currentPage">
									<li class="active"><a><s:property value="#st.index+1" /></a></li>
								</s:if>
								<s:else>
									<li><a href="admin!showOrder?cp=<s:property value="#st.index+1" />"><s:property
												value="#st.index+1" /></a></li>
								</s:else>
							</s:iterator>
							<s:if test="#request.page.hasNextPage==false">
								<li class="disabled"><a>Next</a></li>
							</s:if>
							<s:else>
								<li><a href="admin!showOrder?cp=${page.currentPage+1 }">Next</a></li>
							</s:else>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<hr>


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

			if ($(window).width() > 760) {
				$('tr.list-users td div ul').addClass('pull-right');
			}
		});
	</script>
</body>
</html>
