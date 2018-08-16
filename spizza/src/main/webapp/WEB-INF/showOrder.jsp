<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spizza</title>
</head>
<body>
<sf:form>
<input type="submit" name="_eventId_createPizza" value="createPizza">
<input type="submit" name="_eventId_checkout" value="checkout">
<input type="submit" name="_eventId_cancel" value="cancel">
</sf:form>
</body>
</html>