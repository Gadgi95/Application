<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <h3><spring:message code="${ticket.isFlagToDelete() ? 'ticket.add' : 'ticket.edit'}"/></h3>
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
                <c:if test="${ticket.status.equals('новая')}">
                    <button class="btn btn-primary" type="submit">
                        <span class="fa fa-check"></span>
                        <spring:message code="common.save"/>
                    </button>
                </c:if>
                <c:if test="${ticket.isFlagToDelete()}">
                    <a href="tickets/cancel/">
                        <button class="btn btn-primary" type="button">
                            <span class="fa fa-close"></span>
                            <spring:message code="common.cancel"/>
                        </button
                    </a>
                </c:if>
                <c:if test="${!ticket.isFlagToDelete()}">
                    <a href="tickets/">
                        <button class="btn btn-primary" type="button">
                            <span class="fa fa-close"></span>
                            <spring:message code="common.cancel"/>
                        </button
                    </a>
                </c:if>
            </form>
        </section>
        <section>
            <hr>
<%--            <c:if test="${ticket.status.equals('новая')}">--%>
                <a href="tickets/materials/create">
                    <button class="btn btn-primary">
                        <span class="fa fa-plus"></span>
                        <spring:message code="material.add"/>
                    </button>
                </a>
<%--            </c:if>--%>
            <hr>
            <table class="table table-striped" id="datatable">
                <thead>
                <tr>
                    <th class="th_td"><spring:message code="ticket.name"/></th>
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
                        <td>${material.broke}</td>
                        <td>${material.marriageDetectionDate}</td>
                        <td>${material.marriageDetectedBy}</td>
                        <td>${material.marriageDescription}</td>
                        <c:if test="${ticket.status.equals('новая')}">
                            <td>
                                <c:if test="${ticket.isFlagToDelete()}">
                                    <button><a class="button_users" href="tickets/materials/update/new?id=${material.id}">
                                        <span class="fa fa-pencil"></span></a></button>
                                </c:if>
                                <c:if test="${!ticket.isFlagToDelete()}">
                                    <button><a class="button_users" href="tickets/materials/update?id=${material.id}">
                                        <span class="fa fa-pencil"></span></a></button>
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${ticket.isFlagToDelete()}">
                                    <button><a class="button_users" href="tickets/materials/delete/new?id=${material.id}">
                                        <span class="fa fa-remove"></span></a></button>
                                </c:if>
                                <c:if test="${!ticket.isFlagToDelete()}">
                                    <button><a class="button_users" href="tickets/materials/delete?id=${material.id}">
                                        <span class="fa fa-remove"></span></a></button>
                                </c:if>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </section>
    </div>
</div>
</body>
</html>
