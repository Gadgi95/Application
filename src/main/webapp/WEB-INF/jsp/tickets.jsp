<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://Application.example.com/functions" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<section>
    <h3><spring:message code="ticket.title"/></h3>

    <form method="get" action="tickets/filter">
        <dl>
            <dt><spring:message code="ticket.startDate"/>:</dt>
            <dd><input type="date" name="startDate" value="${param.startDate}"></dd>
        </dl>
        <dl>
            <dt><spring:message code="ticket.endDate"/>:</dt>
            <dd><input type="date" name="endDate" value="${param.endDate}"></dd>
        </dl>
        <dl>
            <dt><spring:message code="ticket.startTime"/>:</dt>
            <dd><input type="time" name="startTime" value="${param.startTime}"></dd>
        </dl>
        <dl>
            <dt><spring:message code="ticket.endTime"/>:</dt>
            <dd><input type="time" name="endTime" value="${param.endTime}"></dd>
        </dl>
        <button type="submit"><spring:message code="ticket.filter"/></button>
    </form>
    <hr>
    <a href="meals/create"><spring:message code="ticket.add"/></a>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th><spring:message code="ticket.creationDate"/></th>
            <th><spring:message code="ticket.objectName"/></th>
            <th><spring:message code="ticket.name"/></th>
            <th><spring:message code="ticket.responsibleSupplier"/></th>
            <th><spring:message code="ticket.deliveryDate"/></th>
            <th><spring:message code="ticket.status"/></th>
            <th><spring:message code="ticket.statusChangeDate"/></th>
            <th><spring:message code="ticket.hasFactoryMarriage"/></th>
            <th><spring:message code="ticket.marriageDetectionDate"/></th>
            <th><spring:message code="ticket.marriageDetectedBy"/></th>
            <th><spring:message code="ticket.marriageDescription"/></th>
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
                <td>${ticket.responsibleSupplier}</td>
                <td>${ticket.deliveryDate}</td>
                <td>${ticket.status}</td>
                <td>${ticket.statusChangeDate}</td>
                <td>${ticket.hasFactoryMarriage}</td>
                <td>${ticket.marriageDetectionDate}</td>
                <td>${ticket.marriageDetectedBy}</td>
                <td>${ticket.marriageDescription}</td>
                <td>${ticket.isClosed}</td>
                <td><a href="tickets/update?id=${ticket.id}"><spring:message code="common.update"/></a></td>
                <td><a href="tickets/delete?id=${ticket.id}"><spring:message code="common.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>