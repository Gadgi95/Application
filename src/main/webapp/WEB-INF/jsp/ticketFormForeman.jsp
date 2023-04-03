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
    <hr>
    <button class="btn btn-primary">
        <a class="button_users" href="material/create"><spring:message code="material.add"/></a>
    </button>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th><spring:message code="ticket.creationDate"/></th>
            <th><spring:message code="ticket.objectName"/></th>
            <th><spring:message code="ticket.name"/></th>
            <th><spring:message code="ticket.responsibleForeman"/></th>
            <th><spring:message code="ticket.responsibleSupplier"/></th>
            <th><spring:message code="ticket.deliveryDate"/></th>
            <th><spring:message code="ticket.status"/></th>
            <th><spring:message code="ticket.statusChangeDate"/></th>
            <th><spring:message code="ticket.isClosed"/></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.tickets}" var="ticket">
            <jsp:useBean id="ticket" type="com.example.application.to.TicketTo"/>
            <tr data-ticket-excess="${ticket.excess}">
                <td>
                        ${fn:formatDateTime(ticket.creationDate)}
                </td>
                <td>${ticket.objectName}</td>
                <td>${ticket.name}</td>
                <td>${ticket.responsibleForeman}</td>
                <td>${ticket.responsibleSupplier}</td>
                <td>${ticket.deliveryDate}</td>
                <td>${ticket.status}</td>
                <td>${ticket.statusChangeDate}</td>
                <td>${ticket.closed}</td>
                <td><button class="btn btn-primary"><a class="button_users" href="tickets/update?id=${ticket.id}"><spring:message code="material.edit"/></a></button></td>
                <td><button class="btn btn-primary"><a class="button_users" href="tickets/delete?id=${ticket.id}"><spring:message code="common.delete"/></a></button></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
