<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div class="col-md-10 col-md-offset-2">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">Professional information</li>
			</ol>
		</div>
		<form class="form-horizontal" action="employee!submitPinfo" method="post">
			<h2 style="margin-top: -10px">Previous Employment</h2>
			<textarea class="form-control" name="str1" rows="4">${currentUser.emp.empInfo.str1 }</textarea>
			<h2>Professional skills</h2>
			<textarea class="form-control" name="str2" rows="4">${currentUser.emp.empInfo.str2 }</textarea>
			<h2>Education</h2>
			<textarea class="form-control" name="str3" rows="4">${currentUser.emp.empInfo.str3 }</textarea>
			<br>
			<button class="btn btn-primary btn-lg btn-block" type="submit">Save</button>
		</form>
	</div>
</body>
</html>