<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron pt-4">
    <div style="margin-left: 0px;" class="container">
        <section>
            <jsp:useBean id="ticket" type="com.example.application.model.Ticket" scope="request"/>
            <%--    `ticket.new` cause javax.el.ELException - bug tomcat --%>
            <h3><spring:message code="${ticket.isNew() ? 'ticket.add' : 'ticket.edit'}"/></h3>
            <hr>
            <form method="post" action="tickets">
                <input type="hidden" name="id" value="${ticket.id}">
                <dl>
                    <dt><spring:message code="ticket.deliveryDate"/>:</dt>
                    <dd><input type="date" value="${ticket.deliveryDate}" size=40 name="deliveryDate" required></dd>
                </dl>
                <dl>
                    <dt><spring:message code="ticket.status"/>:</dt>
                    <dd><select name="status" value="${ticket.status}" required>
                        <option value="1">Новая</option>
                        <option value="2">В работе</option>
                    </select></dd>
                    <%--                    <dd><input type="checkbox" value="${ticket.status}" name="status" required></dd>--%>
                </dl>
                <button class="btn btn-primary" type="submit">
                    <span class="fa fa-check"></span>
                    <spring:message code="common.save"/>
                </button>
                <button class="btn btn-primary" onclick="window.history.back()" type="button">
                    <span class="fa fa-close"></span>
                    <spring:message code="common.cancel"/>
                </button>
            </form>
        </section>
        <section>
            <hr>
            <table class="table table-striped" id="datatable">
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
                <c:forEach items="${materials}" var="material">
                    <jsp:useBean id="material" type="com.example.application.model.Material"/>
                    <tr>
                        <td>${material.ticket.name}</td>
                        <td>${material.name}</td>
                        <td>${material.quantity}</td>
                        <td>${material.characteristics}</td>
                        <td>${material.broke}</td>
                        <td>${material.marriageDetectionDate}</td>
                        <td>${material.marriageDetectedBy}</td>
                        <td>${material.marriageDescription}</td>
                    </tr>
                </c:forEach>
            </table>
        </section>
    </div>
</div>
</body>
</html>
