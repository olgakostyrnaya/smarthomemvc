<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Smarthome</title>
</head>
<body>
<h2>Умный дом</h2>
<br/>
<br/>
<c:if test="${lightState eq 'on'}">
    <img src="${pageContext.request.contextPath}/images/lightBulbOn.jpg" width="100" height="100" alt="lightState:on"/>
</c:if>
<c:if test="${lightState eq 'off'}">
    <img src="${pageContext.request.contextPath}/images/lightBulbOff.jpg" width="100" height="100"
         alt="lightState:off"/>
</c:if>
<p>Состояние освещения: <c:out value="${lightState}"/></p>
</body>
</html>
