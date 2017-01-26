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
				<s:if test="#request.flag==2">
					<li class="active">Replied appointment</li>
				</s:if>
				<s:else>
					<li class="active">Pending appointment</li>
				</s:else>
			</ol>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>OrderID</th>
					<th>State</th>
					<th>Name</th>
					<s:if test="#request.flag!=2">
						<th>STime</th>
					</s:if>
					<s:else>
						<th>RTime</th>
					</s:else>
					<th>Serve</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#request.orderList" var="order" status="st">
					<tr>
						<td><s:property value="#st.index+1" /></td>
						<td><s:property value="#order.state" /></td>
						<td><s:property value="#order.user.name" /></td>
						<s:if test="#request.flag!=2">
							<td><s:date name="#order.startTime" /></td>
						</s:if>
						<s:else>
							<td><s:date name="#order.finishTime" /></td>
						</s:else>
						<td><s:property value="#order.serve.name" /></td>
						<td><s:if test="#request.flag==2">
								<a href="employee!showComment?id=<s:property value="#order.id" />"><span
									class="glyphicon glyphicon-log-in"></span></a>
							</s:if> <s:else>
								<a href="serve!showOrderInfo?id=<s:property value="#order.id"/>"><span
									class="glyphicon glyphicon-log-in"></span></a>
							</s:else></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<s:if test="#request.flag!=2">
		</s:if>
		<s:else>
			<form class="form-inline" action="">
				<nav>
					<ul class="pager pull-right">
						<li><a href="serve!showOrder2?currentPage=1">First</a></li>
						<s:if test="#request.page.hasPrePage==true">
							<li><a href="serve!showOrder2?currentPage=${page.currentPage-1 }">Previous</a></li>
						</s:if>
						<s:if test="#request.page.hasNextPage==true">
							<li><a href="serve!showOrder2?currentPage=${page.currentPage+1 }">Next</a></li>
						</s:if>
						<li><a href="serve!showOrder2?currentPage=${page.totalPage }">Last</a></li>
						<li><input class="form-control" type="number" style="width: 20%;" name="currentPage"
							value="${page.currentPage }" /></li>
						<li><a href="#" onclick="a()">Go</a></li>
					</ul>
				</nav>
			</form>
		</s:else>
	</div>
	<script>
		function a() {
			$('form').submit();
		}
	</script>
</body>

</html>