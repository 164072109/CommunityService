<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="col-md-10 col-md-offset-2">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">Dashboard</li>
			</ol>
		</div>
		<form action="user!comment2" method="post" onsubmit="alert('ok')">
			<table class="table">
				<tr>
					<td width="30%">name:</td>
					<td><s:property value="#request.order.employee.user.name" /></td>
				</tr>
				<tr>
					<td>age:</td>
					<td><s:property value="#request.order.employee.user.age" /></td>
				</tr>
				<tr>
					<td>sex:</td>
					<td><s:property value="#request.order.employee.user.sex" /></td>
				</tr>
				<tr>
					<td>phone:</td>
					<td><s:property value="#request.order.employee.user.phone" /></td>
				</tr>
				<tr>
					<td>STime:</td>
					<td><s:date name="#request.order.startTime" /></td>
				</tr>
				<tr>
					<td>ETime:</td>
					<td><s:date name="#request.order.finishTime" /></td>
				</tr>
				<tr>
					<td>service:</td>
					<td><s:property value="#request.order.serve.name" /></td>
				</tr>
				<tr>
					<td>comments:</td>
					<td><textarea rows="3" class="form-control" style="overflow-y: hidden; resize: none;"
							maxlength="200" name="message">${request.order.comment.comments }</textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="hidden" name="orderId"
						value="${request.order.id }">
						<button class="btn btn-primary btn-lg" type="submit">Submit</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>