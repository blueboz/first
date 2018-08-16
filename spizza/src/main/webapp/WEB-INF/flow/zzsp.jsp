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
<h2>组长审批</h2>
${qingjiadan.user}


<s:form modelAttribute="qingjiadan">
    <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey }">
    申请人:${qingjiadan.user }<br>
    申请日期:${qingjiadan.date}<br>
    申请理由:${qingjiadan.reason}<br>
    <input type="submit" name="_eventId_yes" value="同意">
    <input type="submit" name="_eventId_no" value="不同意">
</s:form>
</body>
</html>
