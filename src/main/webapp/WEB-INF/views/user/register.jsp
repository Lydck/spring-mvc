<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<form action="/user.html" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>手机号码：</td>
				<td><input type="number" name="mobile"></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><input type="radio" name="gender" value="男" checked="true"><label for="男">男</label></td>
				<td><input type="radio" name="gender" value="女"><label for="女">女</label></td>
			</tr>
		</table>
	</form>
</body>
</html>