<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<section>
    <jsp:useBean id="ticket" type="com.example.Application.model.Ticket" scope="request"/>
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
            <dt><spring:message code="ticket.deliveryDate"/>:</dt>
            <dd><input type="datetime-local" value="${ticket.deliveryDate}" name="deliveryDate" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="ticket.status"/>:</dt>
            <dd><input type="text" value="${ticket.status}" name="status" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="ticket.isClosed"/>:</dt>
            <dd><input type="text" value="${ticket.isClosed}" name="isClosed" required></dd>
        </dl>
        <button type="submit"><spring:message code="common.save"/></button>
        <button onclick="window.history.back()" type="button"><spring:message code="common.cancel"/></button>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
