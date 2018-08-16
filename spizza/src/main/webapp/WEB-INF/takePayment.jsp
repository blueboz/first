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
<h2>支付</h2>
<sf:form commandName="paymentDetails">
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey }">
		<b>账号:</b>
		<sf:input path="account"/><br/>
		
		<b>支付类型:</b><br/>
		<sf:radiobuttons items="${paymentTypeList }" path="paymentType" delimiter="&lt;br/&gt;"/><br/><br/>
		<input type="submit" name="_eventId_paymentSubmitted" value="Continue">
		<input type="submit" name="_eventId_cancel" value="Cancel">
	</sf:form>
</body>
</html>