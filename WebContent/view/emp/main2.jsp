<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	errorPage="error.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/mycss.css" />
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand"><span>Community</span>Service</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="view/emp/main2.jsp">Home</a></li>
			</ul>
			<ul class="user-menu">
				<li class="dropdown pull-right"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
						class="glyphicon glyphicon-user"></span> User <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="user!showInfo" target="b"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
						<li><a href="employee!showInfo" target="b"><span class="glyphicon glyphicon-zoom-in"></span> Professional Info</a></li>
						<li><a href="user!logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
	<div class="col-md-2 sidebar">
		<ul class="nav nav-sidebar">
			<li onclick="$('li').removeClass('active'),this.className='active'"><a
				href="serve!showOrder" target="b"><span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;Pending
					appointment</a></li>
			<li onclick="$('li').removeClass('active'),this.className='active'"><a
				href="serve!showOrder2" target="b"><span class="glyphicon glyphicon-fire"></span>&nbsp;&nbsp;Replied
					appointment</a></li>
			<li onclick="$('li').removeClass('active'),this.className='active'"><a
				href="employee!serveApply" target="b"><span class="glyphicon glyphicon-leaf"></span>&nbsp;&nbsp;Service
					application</a></li>
		</ul>
	</div>
	<iframe width="100%" name="b" onload="this.height=document.body.scrollHeight-60" frameborder="0"
		scrolling="no" src="index.html"></iframe>
</body>

</html>