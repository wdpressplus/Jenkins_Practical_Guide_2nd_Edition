<%@ page language="java" contentType="text/html; charset=windows-31j"
    pageEncoding="windows-31j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
		<title>入力画面</title>
	</head>
	<body>
		<h1>サンプルプログラム</h1>
		<form action="./SampleServlet" method="post">
			<label for="LastName">名字</label>: <input type="text" name="LastName" /><br />
			<label for="FirstName">名前</label>: <input type="text" name="FirstName" /><br />
			<input type="hidden" name="action" value="hello" />
			<input type="submit" name="submit" value="送信" />
		</form>
	</body>
</html>