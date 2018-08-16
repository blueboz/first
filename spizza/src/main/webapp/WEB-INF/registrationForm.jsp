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
	<h2>Customer Registration</h2>
	<sf:form commandName="customer">
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey }">
		<b>Phone Number：</b><sf:input path="phoneNumber"/><br/>
		<b>Name:</b><sf:input path="name"/><br/>
		<b>Address:</b><sf:input path="address"/><br/>
		<b>City:</b><sf:input path="city"/><br/>
		<b>State:</b><sf:input path="state"/><br/>
		<b>Zip Code:</b><sf:input path="zipCode"/><br/>
		<input type="submit" name="_eventId_submit" value="Submit">
		<input type="submit" name="_eventId_cancel" value="Cancel">
	</sf:form>
</body>
</html>