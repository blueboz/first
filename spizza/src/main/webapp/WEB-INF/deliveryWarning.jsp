<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spizza</title>
</head>
<body>
	<h2>Delivery Unavailable</h2>
	<p>这个地址已经超出了配送范围，你可以继续使用这个地址，但是需要你自己去店里取货</p>
	<a href="${flowExecutionUrl }&_eventId=accept">接受这个建议</a>
	<a href="${flowExecutionUrl }&_eventId=cancel">放弃</a>
</body>
</html>