<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	errorPage="error.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<div class="col-md-10 col-md-offset-2">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">ServiceAppointment</li>
			</ol>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>name</th>
					<th>age</th>
					<th>sex</th>
					<th>phone</th>
					<th>order</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#request.empList" var="emp">
					<tr>
						<td><s:property value="#emp.user.name" /></td>
						<td><s:property value="#emp.user.age" /></td>
						<td><s:property value="#emp.user.sex" /></td>
						<td><s:property value="#emp.user.phone" /></td>
						<td><a href="user!yuyue?empId=<s:property value="#emp.id"/>&serveId=${serveId}">order</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>

</html>