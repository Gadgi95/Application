<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<header>
    <a href="tickets"><img src="resources/images/home.png"></a>
    <a href="tickets"> <spring:message code="app.title"/></a>
    <sec:authorize access="isAuthenticated()">
        <sec:authorize access="hasRole('ADMIN')">
            <a href="users"><spring:message code="user.title"/></a>
        </sec:authorize>
        <a href="profile">${userTo.name} <spring:message code="app.profile"/></a>
        <a href="logout"> выход</a>
    </sec:authorize>
</header>
