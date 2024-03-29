<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-dark bg-dark py-0">
    <div class="container">
        <a href="tickets" class="navbar-brand"><img src="resources/images/topdom64.png"><spring:message code="app.title"/></a>
        <sec:authorize access="isAuthenticated()">
            <form class="form-inline my-2">
                <sec:authorize access="hasRole('ADMIN')">
                    <a class="btn btn-info mr-1" href="users"><spring:message code="user.titleS"/></a>
                </sec:authorize>
                <a class="btn btn-info mr-1" href="profile">${userTo.name} <spring:message code="app.profile"/></a>
                <a class="btn btn-primary my-1" href="logout">
                    <span class="fa fa-sign-out"></span>
                </a>
            </form>
        </sec:authorize>
    </div>
</nav>
