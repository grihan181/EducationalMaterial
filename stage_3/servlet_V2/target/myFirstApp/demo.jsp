<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"  %>
<%@ taglib prefix="html" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="application" var="appProperties"/>
<html>
<head>
    <title><fmt:message bundle="${appProperties}" key="title"/></title>
</head>
<body>

<ul>
<%--jstl способ--%>
<c:forEach var="num" items="${randomResult}">
    <li> ${num} </li>
</c:forEach>
</ul>
<%--скрпитлетный способ--%>
<ul>
    <%
        int[] randomResult = (int[]) request.getAttribute("randomResult");
    %>
    <%for (int i = 0; i <randomResult.length; i++){%>
        <li><%=randomResult[i]%></li>
    <%}%>
</ul>
</body>
</html>
