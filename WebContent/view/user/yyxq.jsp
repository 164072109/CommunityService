<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/mycss2.css" rel="stylesheet">
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="col-md-10 col-md-offset-2">
		<div class="row 1">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">Dashboard</li>
			</ol>
		</div>
		<div class="row">
			<form id="form" action="serve!order?id=${emp.id }&serveId=${serve.id}" method="post">
				<div class="col-md-2" style="padding-left: 35px;">

					<br> <br>
					<s:if test="#request.emp.user.img!=null">
						<img alt="123" width="100%" src="user!showImg?id=${emp.user.id }" class="img-circle">
					</s:if>
					<br> <label>姓名:</label>
					<s:property value="#request.emp.user.name" />
					<br> <label>年龄:</label>
					<s:property value="#request.emp.user.age" />
					<br> <label>性别:</label>
					<s:property value="#request.emp.user.sex" />
					<br> <label>手机:</label>
					<s:property value="#request.emp.user.phone" />
					<br> <label>服务类型:</label>
					<s:property value="#request.serve.name" />
					<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"
						onclick="init()">Submit</button>

				</div>
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">leave a message</h4>
							</div>
							<div class="modal-body" align="center">
								<textarea id="message" rows="15" cols="70" style="overflow-y: hidden; resize: none;"></textarea>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="a(); d()">Order</button>
							</div>
						</div>
					</div>
				</div>
			</form>
			<div class="col-md-9 cc">
				<h3 class="clr1">Previous Employment</h3>
				<p style="height: 100px">${emp.empInfo.str1 }</p>
				<h3 class="clr2">Professional skills</h3>
				<p style="height: 100px">${emp.empInfo.str2 }.</p>
				<h3 class="clr3">Education</h3>
				<p style="height: 100px">${emp.empInfo.str3 }</p>
			</div>
		</div>
		<div id="info"></div>
		<div class="progress sr-only" id="ff">
			<div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar"
				style="width: 0%;"></div>
		</div>

	</div>
	<script>
		var p = 0;
		function a() {
			if (p == 0) {
				$(".progress").removeClass("sr-only")
			}
			p += 1;
			if (p < 101) {
				$(
						"div[class='progress-bar progress-bar-info progress-bar-striped']")
						.css("width", p + "%");
				var timer = setTimeout("a()", 10);
			}
		}
		var c
		function d() {
			c = setInterval("b()", 10)
		}
		function b() {
			var a
			var b
			a = $(
					"div[class='progress-bar progress-bar-info progress-bar-striped']")
					.width();
			b = $("div[class='progress").width();
			if (a == b) {
				//document.getElementById("form").submit();
				clearInterval(c);
				document.getElementById('ff').className = 'progress sr-only';
				$("#info").load("serve!order", {
					"id" : '${emp.id }',
					"serveId" : '${serve.id}',
					"message" : $("#message").val()
				});
			}
		}
		function init() {
			p = 0;
			$(
					"div[class='progress-bar progress-bar-info progress-bar-striped']")
					.css("width", p + "%");
			$("#info").html("");

		}
	</script>
</body>
</html>