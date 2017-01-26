<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-1.11.1.min.js"></script>
</head>
<body>
	<div class="col-md-10 col-md-offset-2">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<s:if test="#request.flag==2">
					<li class="active"><a href="serve!showOrder2">Replied appointment</a></li>
					<li class="active">Service evaluation</li>
				</s:if>
				<s:else>
					<li class="active"><a href="serve!showOrder">Pending appointment</a></li>
					<li class="active">Details</li>
				</s:else>
			</ol>
		</div>
		<br>
		<table class="table ">
			<tr>
				<td>OrderID:</td>
				<td>${order.id }</td>
			</tr>
			<tr>
				<td>Serve:</td>
				<td>${order.serve.name }</td>
			</tr>
			<tr>
				<td>State:</td>
				<td>${order.state }</td>
			</tr>
			<tr>
				<td>User:</td>
				<td>${order.user.name }</td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td>${order.user.phone }</td>
			</tr>
			<tr>
				<td width="350">Email:</td>
				<td>${order.user.email }</td>
			</tr>
			<s:if test="#request.flag==2">
				<tr>
					<td>StartTime:</td>
					<td><s:date name="#request.order.startTime"/></td>
				</tr>
				<tr>
					<td>FinishTime:</td>
					<td><s:date name="#request.order.finishTime"/></td>
				</tr>
				<tr>
					<td>Comments:</td>
					<td style="word-break: break-all">${order.comment.comments }</td>
				</tr>
			</s:if>
			<s:else>
				<tr>
					<td>Address:</td>
					<td>${order.user.address }</td>
				</tr>
				<tr>
					<td>Message:</td>
					<td style="word-break: break-all">${order.message }</td>
				</tr>
				<tr>
					<td><a href="serve!replyOrder?id=${order.id}&reply=已接受" target="bb"><button
								type="button" class="btn btn-info" onclick="$('.btn').addClass('disabled')">Accept</button></a></td>
					<td><a href="serve!replyOrder?id=${order.id}&reply=拒绝" target="bb"><button
								type="button" class="btn btn-warning" onclick="$('.btn').addClass('disabled')">Refuse</button></a></td>
				</tr>
				<tr>
					<td colspan="2"><iframe width="100%" name="bb" frameborder="0" scrolling="no"></iframe></td>
				</tr>
			</s:else>
		</table>
	</div>
</body>
</html>