<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<link href="css/style_log.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
</head>
<script src="js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
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
		$("[name='birthdate']").change(function() {
			var a = $("[name='birthdate']").val();
			var b = a.substring(0, a.indexOf('-'));
			$("[name='age']").val(2017 - b)
		})
		$("form").submit(function() {
			var p1 = $("[name='passwd']").val();
			var p2 = $("[name='passwd2']").val();
			if (p1 != p2) {
				alert('两次密码不一致')
				return false;
			}
		})
	});
</script>

<body class="login" mycollectionplug="bind">
	<form action="register" method="post" enctype="multipart/form-data">
		<div class="login_m">
			<div class="login_boder">
				<div class="login_padding" id="login_model">
					<table>
						<tr>
							<td colspan="2">
								<table>
									<tr>
										<td height="100px" width="200px" align="center"><img id="img" alt="picture"
											class="img-circle"></td>
										<td align="center"><a href="#" class="file">上传头像 <input type="file"
												id="upload_image" name="pic" accept="image/jpeg,image/png"></a></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>username</td>
							<td><input type="text" class="form-control" name="loginId" required pattern="\w{6,12}"
								oninvalid="setCustomValidity('用户名为6到12位字符数字下划线!');" oninput="setCustomValidity('');" /></td>
						</tr>
						<tr>
							<td>password</td>
							<td><input type="password" class="form-control" name="passwd" required
								pattern="\w{6,12}" oninvalid="setCustomValidity('密码为6到12位字符数字下划线!');"
								oninput="setCustomValidity('');" /></td>
						</tr>
						<tr>
							<td>password</td>
							<td><input type="password" class="form-control" name="passwd2" /></td>
						</tr>
						<tr>
							<td>name</td>
							<td><input type="text" class="form-control" name="name" required /></td>
						</tr>
						<tr>
							<td>email address</td>
							<td><input type="email" class="form-control" name="email" required /></td>
						</tr>
						<tr>
							<td>family address</td>
							<td><input type="text" class="form-control" name="address" required /></td>
						</tr>
						<tr>
							<td>phone number</td>
							<td><input type="text" class="form-control" name="phone" pattern="\d{8,12}"
								oninvalid="setCustomValidity('手机号为8到12位数字!');" oninput="setCustomValidity('');" /></td>
						</tr>
						<tr>
							<td>sex</td>
							<td align="center"><input type="radio" name="sex" id="age1" value="male" /><label
								for="age1">male</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="sex"
								id="age2" value="female" /><label for="age2">female</label></td>
						</tr>
						<tr>
							<td>birthdate</td>
							<td><input type="date" class="form-control" min="1900-01-01" name="birthdate" /></td>
						</tr>
						<tr>
							<td>age</td>
							<td><input type="number" class="form-control" max="120" min="1" name="age" /></td>
						</tr>
					</table>
					<div class="rem_sub" align="center">
						<label> <input type="submit" class="sub_button" name="button" id="button"
							value="Register" style="opacity: 0.7;"></label> <font color="red">${errors.loginId[0] }</font><br>
					</div>
				</div>
				<!--login_padding  Sign up end-->
			</div>
			<!--login_boder end-->
		</div>

		<!--login_m end-->
	</form>
</body>

</html>