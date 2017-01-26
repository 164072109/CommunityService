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
				<s:if test="#request.flag==1">
					<li class="active">Historical Order</li>
				</s:if>
				<s:else>
					<li class="active">Applying Order</li>
				</s:else>
			</ol>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>No.</th>
					<th>State</th>
					<th>Serve</th>
					<th>Employee</th>
					<s:if test="#request.flag==1">
						<th>RTime</th>
					</s:if>
					<s:else>
						<th>STime</th>
					</s:else>

					<th></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#request.orderList" var="order" status="st">
					<tr>
						<td><s:property value="#st.index+1" /></td>
						<td><s:property value="#order.state" /></td>
						<td><s:property value="#order.serve.name" /></td>
						<td><s:property value="#order.employee.user.name" /></td>
						<s:if test="#request.flag==1">
							<td><s:date name="#order.finishTime" /></td>
							<td><s:if test="#order.state=='已接受'">
									<a href="user!comment?orderId=<s:property value="#order.id" />"> <span
										class="glyphicon glyphicon-pencil"></span>
									</a>
								</s:if></td>
						</s:if>
						<s:else>
							<td><s:date name="#order.startTime" /></td>
							<td><a href="user!deleteOrder?orderId=<s:property value="#order.id" />"
								onclick="return confirm('Are you sure you want to delete?')"> <span
									class="glyphicon glyphicon-remove"></span>
							</a></td>
						</s:else>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<s:if test="#request.flag==1">
			<form action="user!showOrder1" class="form-inline" method="post">
				<nav>
					<ul class="pager pull-right">
						<li><a href="user!showOrder1">First</a></li>
						<s:if test="#request.page.hasPrePage==true">
							<li><a href="user!showOrder1?currentPage=${page.currentPage-1 }">Previous</a></li>
						</s:if>
						<s:if test="#request.page.hasNextPage==true">
							<li><a href="user!showOrder1?currentPage=${page.currentPage+1 }">Next</a></li>
						</s:if>
						<li><a href="user!showOrder1?currentPage=${page.totalPage }">Last</a></li>
						<li><input class="form-control pg" style="width: 100px" type="number" name="currentPage"
							value="${page.currentPage }" /></li>
						<li><a href="#" onclick="a()">Go</a></li>
					</ul>
				</nav>
			</form>
		</s:if>
	</div>
	<script>
		function a() {
			var a = $('.pg').val();
			var type = "^[0-9]*[1-9][0-9]*$";
			var re = new RegExp(type);
			if (a.match(re) == null) {
				alert('请输入合法页码')
				return false
			} else {
				$('form').submit();
			}
		}
	</script>
</body>

</html>