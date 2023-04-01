<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<section>
    <jsp:useBean id="ticket" type="com.example.application.model.Ticket" scope="request"/>
<%--    `meal.new` cause javax.el.ELException - bug tomcat --%>
    <h3><spring:message code="${ticket.isNew() ? 'ticket.add' : 'ticket.edit'}"/></h3>
    <hr>
    <form method="post" action="tickets">
        <input type="hidden" name="id" value="${ticket.id}">
        <dl>
            <dt><spring:message code="ticket.name"/>:</dt>
            <dd><input type="text" value="${ticket.name}" size=40 name="name" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="ticket.objectName"/>:</dt>
            <dd><input type="text" value="${ticket.objectName}" name="objectName" required></dd>
        </dl>
        <button type="submit"><spring:message code="common.save"/></button>
        <button onclick="window.history.back()" type="button"><spring:message code="common.cancel"/></button>
    </form>
</section>
</body>
</html>
