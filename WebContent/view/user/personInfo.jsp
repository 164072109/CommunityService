<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
<!--
.file {
	position: relative;
	display: inline-block;
	background: #D0EEFF;
	border: 1px solid #99D3F5;
	border-radius: 4px;
	padding: 4px 12px;
	overflow: hidden;
	color: #1E88C7;
	text-decoration: none;
	text-indent: 0;
	line-height: 20px;
}

.file input {
	position: absolute;
	font-size: 100px;
	right: 0;
	top: 0;
	opacity: 0;
}

.file:hover {
	background: #AADFFD;
	border-color: #78C3F3;
	color: #004974;
	text-decoration: none;
}

#img {
	max-width: 120px;
	max-height: 100px;
}
-->
</style>
<script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("[name='birthdate']").change(function() {
			var a = $("[name='birthdate']").val();
			var b = a.substring(0, a.indexOf('-'));
			$("[name='age']").val(2017 - b)
		});

		$('#upload_image').change(function(event) {
			// 根据这个 <input> 获取文件的 HTML5 js 对象
			var files = event.target.files, file;
			if (files && files.length > 0) {
				file = files[0];
				// 那么我们可以做一下诸如文件大小校验的动作
				if (file.size > 1024 * 1024 * 2) {
					alert('图片大小不能超过 2MB!');
					return false;
				}
				// !!!!!!
				// 下面是关键的关键，通过这个 file 对象生成一个可用的图像 URL
				// 获取 window 的 URL 工具
				var URL = window.URL || window.webkitURL;
				// 通过 file 生成目标 url
				var imgURL = URL.createObjectURL(file);
				// 用这个 URL 产生一个 <img> 将其显示出来
				$("#img").attr('src', imgURL);
			}
		});
	})
</script>
<body>
	<div class="col-md-10 col-md-offset-2">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">Personal information</li>
			</ol>
		</div>
		<form class="form-inline" action="register!updateInfo" method="post" enctype="multipart/form-data">
			<table class="table">
				<tr>
					<td style="padding-top: 50px">head portrait</td>
					<td><table>
							<tr>
								<td width="200px" height="100px" align="center"><img id="img" class="img-circle"
									alt="picture" src="user!showImg?id=${currentUser.id }"></td>
								<td><a href="#" class="file">上传头像 <input type="file" id="upload_image" name="pic"
										accept="image/jpeg,image/png"></a></td>
							</tr>
						</table></td>
				</tr>
				<tr>
					<td>name</td>
					<td><input type="text" name="name" class="form-control" value="${currentUser.name }"></td>
				</tr>
				<tr>
					<td>sex</td>
					<td><c:choose>
							<c:when test="${currentUser.sex=='male'}">
								<input type="radio" name="sex" id="sex1" value="male" checked>
								<label for="sex1">male</label>&nbsp;&nbsp;&nbsp;
								<input type="radio" name="sex" id="sex2" value="female">
								<label for="sex2">female</label>
							</c:when>
							<c:when test="${currentUser.sex=='female'}">
								<input type="radio" name="sex" id="sex1" value="male">
								<label for="sex1">male</label>&nbsp;&nbsp;&nbsp;
								<input type="radio" name="sex" id="sex2" value="female" checked>
								<label for="sex2">female</label>
							</c:when>
							<c:otherwise>
								<input type="radio" name="sex" id="sex1" value="male">
								<label for="sex1">male</label>&nbsp;&nbsp;&nbsp;
								<input type="radio" name="sex" id="sex2" value="female">
								<label for="sex2">female</label>
							</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td>birthdate</td>
					<td><input type="date" name="birthdate" class="form-control"
						value="${currentUser.birthdate }"></td>
				</tr>
				<tr>
					<td>age</td>
					<td><input type="number" name="age" class="form-control" max="120" min="1"
						value="${currentUser.age }"></td>
				</tr>
				<tr>
					<td>phone</td>
					<td><input type="text" name="phone" class="form-control" pattern="\d{8,12}"
						value="${currentUser.phone }"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" class="form-control" value="${currentUser.email }"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" class="form-control" value="${currentUser.address }"></td>
				</tr>
				<tr>
					<td align="center"><button class="btn btn-info" type="submit">submit</button></td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>