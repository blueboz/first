<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/22
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title>请假</title>
</head>
<body>
<h2>请假单</h2>
<s:form modelAttribute="qingjiadan" method="post">
    <!--这个是固定需要加的-->
    <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey }">
   申请人: <s:input path="user"></s:input><br>
   申请日期: <s:input path="date"></s:input><br>
   申请原因: <s:input path="reason"></s:input><br>
    <input type="submit" name="_eventId_submit" value="提交">
</s:form>
</body>
</html>
