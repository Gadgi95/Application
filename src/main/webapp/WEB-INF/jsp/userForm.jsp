<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<section>
    <jsp:useBean id="user" class="com.example.application.model.User" scope="request"/>
    <%--    `meal.new` cause javax.el.ELException - bug tomcat --%>
    <h3><spring:message code="${user.isNew() ? 'user.add' : 'user.edit'}"/></h3>
    <hr>
    <form method="post" action="users">
        <input type="hidden" name="id" value="${user.id}">
        <dl>
            <dt><spring:message code="user.name"/>:</dt>
            <dd><input type="text" value="${user.name}" size=40 name="name" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="user.email"/>:</dt>
            <dd><input type="text" value="${user.email}" name="email" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="user.password"/>:</dt>
            <dd><input type="text" value="${user.password}" name="password" required></dd>
        </dl>
        <button type="submit"><spring:message code="common.save"/></button>
        <button onclick="window.history.back()" type="button"><spring:message code="common.cancel"/></button>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
