<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<s:if test="#request.flag==true">
		<div class="alert alert-success" role="alert">
			<span class="glyphicon glyphicon-ok"></span> <strong>congratulations!</strong> You make a appointment successfully.
		</div>
	</s:if>
	<s:else>
		<div class="alert alert-warning" role="alert">
			<span class="glyphicon glyphicon-warning-sign"></span> <strong>Warning!</strong> You have made a appointment before.
		</div>
	</s:else>
</body>
</html>