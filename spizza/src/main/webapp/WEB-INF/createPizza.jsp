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
	<h2>Create Pizza</h2>
	<sf:form commandName="pizza">
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey }">
		<b>Size:</b><br/>
		<sf:radiobutton path="size" label="Small(12-inch)" value="SMALL"/><br/>
		<sf:radiobutton path="size" label="Medium(14-inch)" value="MEDIUM"/><br/>
		<sf:radiobutton path="size" label="Large(16-inch)" value="LARGE"/><br/>
		<sf:radiobutton path="size" label="Ginormous(20-inch)" value="GINORMOUS"/><br/><br/>
		
		<b>Toppings:</b><br/>
		<sf:checkboxes items="${toppingsList }" path="toppings" delimiter="&lt;br/&gt;"/><br/><br/>
		<input type="submit" name="_eventId_addPizza" value="Continue">
		<input type="submit" name="_eventId_cancel" value="Cancel">
	</sf:form>
</body>
</html>