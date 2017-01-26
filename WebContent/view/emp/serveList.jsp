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
				<li class="active">Service application</li>
			</ol>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>No.</th>
					<th>Serve name</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#request.serveList" var="serve" status="st">
					<tr>
						<td><s:property value="#st.index+1" /></td>
						<td><s:property value="#serve.name" /></td>
						<td><a href="employee!serveApply2?serveId=<s:property value="#serve.id" />" onclick="alert('ok')"><span
								class="glyphicon glyphicon-thumbs-up"></span></a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>

</html>