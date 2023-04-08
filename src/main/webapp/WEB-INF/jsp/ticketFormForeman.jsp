<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<section>
    <jsp:useBean id="ticket" type="com.example.application.model.Ticket" scope="request"/>
<%--    `ticket.new` cause javax.el.ELException - bug tomcat --%>
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
<section>
    <hr>
    <button class="btn btn-primary">
        <a class="button_users" href="tickets/materials/create"><spring:message code="material.add"/></a>
    </button>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th><spring:message code="ticket.name"/></th>
            <th><spring:message code="material.name"/></th>
            <th><spring:message code="material.quantity"/></th>
            <th><spring:message code="material.characteristics"/></th>
            <th><spring:message code="material.hasFactoryMarriage"/></th>
            <th><spring:message code="material.marriageDetectionDate"/></th>
            <th><spring:message code="material.marriageDetectedBy"/></th>
            <th><spring:message code="material.marriageDescription"/></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.materials}" var="material">
            <jsp:useBean id="material" type="com.example.application.model.Material"/>
            <tr>
                <td>${material.ticket.name}</td>
                <td>${material.name}</td>
                <td>${material.quantity}</td>
                <td>${material.characteristics}</td>
                <td>${material.hasFactoryMarriage}</td>
                <td>${material.marriageDetectionDate}</td>
                <td>${material.marriageDetectedBy}</td>
                <td>${material.marriageDescription}</td>
                <td><button class="btn btn-primary"><a class="button_users" href="tickets/update?id=${material.id}"><spring:message code="material.edit"/></a></button></td>
                <td><button class="btn btn-primary"><a class="button_users" href="tickets/delete?id=${material.id}"><spring:message code="common.delete"/></a></button></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
