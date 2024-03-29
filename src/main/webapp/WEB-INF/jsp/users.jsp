<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <h3 style="color: black"><spring:message code="user.title"/></h3>
        <a href="users/create"><button class="btn btn-primary">
            <span class="fa fa-plus"></span>
            <spring:message code="common.add"/>
        </button></a>
        <table class="table table-striped mt-3">
            <thead>
            <tr>
                <th><spring:message code="user.name"/></th>
                <th><spring:message code="user.email"/></th>
                <th><spring:message code="user.roles"/></th>
<%--                <th><spring:message code="user.active"/></th>--%>
                <th><spring:message code="user.registered"/></th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${requestScope.users}" var="user">
                <jsp:useBean id="user" type="com.example.application.model.User"/>
                <tr>
                    <td><c:out value="${user.name}"/></td>
                    <td><a href="mailto:${user.email}">${user.email}</a></td>
                    <td>${user.roles}</td>
<%--                    <td><input type="checkbox" <c:if test="${user.enabled}">checked</c:if>/></td>--%>
                    <td><fmt:formatDate value="${user.registered}" pattern="dd-MMMM-yyyy"/></td>
                    <td><button><a class="button_users" href="users/update?id=${user.id}"><span class="fa fa-pencil"></span></a></button></td>
                    <td><button><a class="button_users" href="users/delete?id=${user.id}"><span class="fa fa-remove"></span></a></button></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>