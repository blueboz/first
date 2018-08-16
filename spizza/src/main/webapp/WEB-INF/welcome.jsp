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
<h2>Welcome to Spizza!!</h2>
<sf:form>
	<!-- _flowExecutionKey为流程执行的key，提交表单时，key会在“_flowExecutionKey”输入域中返回并在流程暂停的位置进行恢复 -->
	<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey }" />
	
	<label>电话号码:</label>
	<input type="text" name="phoneNumber" /><br/>
	
	<!-- 按钮名字的“_eventID_”部分是提供给Spring Web Flow的一个线索，表明接下来要触发事件phoneEntered -->
	<input type="submit" name="_eventId_phoneEntered" value="Lookup Customer">
</sf:form>
</body>
</html>