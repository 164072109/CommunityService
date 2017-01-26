<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="register" method="post" enctype="multipart/form-data">
		角色:<select name="type"><option value="user">会员</option><option value="emp">员工</option></select><br>
		用户名:<input type="text" name="loginId"><font color="red">${errors.loginId[0] }</font><br>
		密码:<input type="password" name="passwd"><font color="red">${errors.passwd[0] }</font><br>
		重复密码:<input type="password" name="passwd2"><font color="red">${errors.passwd2[0] }</font><br>
		姓名:<input type="text" name="name"><font color="red">${errors.name[0] }</font><br>
		性别:<select name="sex"><option value="male">男</option><option value="female">女</option></select><br>
		年龄:<input type="text" name="age"><font color="red">${errors.age[0] }</font><br>
		邮箱:<input type="text" name="email"><font color="red">${errors.email[0] }</font><br>
		手机:<input type="text" name="phone"><font color="red">${errors.phone[0] }</font><br>
		地址:<input type="text" name="address"><font color="red">${errors.address[0] }</font><br>
		头像:<input type="file" name="pic"><br>
		<input type="submit">
	</form>
</body>
</html>