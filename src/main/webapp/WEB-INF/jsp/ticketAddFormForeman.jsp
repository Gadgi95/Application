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
                <button class="btn btn-primary" type="submit">
                    <span class="fa fa-check"></span>
                    <spring:message code="common.save"/>
                </button>
                <a href="tickets/">
                    <button class="btn btn-primary" type="button">
                        <span class="fa fa-close"></span>
                        <spring:message code="common.cancel"/>
                    </button
                </a>
            </form>
        </section>
<%--        <section>--%>
<%--            <jsp:include page="materials.jsp"/>--%>
<%--        </section>--%>
        <section>
                <hr>
                <a href="tickets/materials/create"><button class="btn btn-primary">
                    <span class="fa fa-plus"></span>
                    <spring:message code="material.add"/>
                </button></a>
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
                        <td><button><a class="button_users" href="tickets/materials/updateNew?id=${material.id}"><span class="fa fa-pencil"></span></a></button></td>
                        <td><button><a class="button_users" href="tickets/materials/deleteNew?id=${material.id}"><span class="fa fa-remove"></span></a></button></td>
                    </tr>
                </c:forEach>
            </table>
        </section>
    </div>
</div>


<%--<section class="modal fade">--%>
<%--    <jsp:useBean id="material" type="com.example.application.model.Material" scope="request"/>--%>
<%--    &lt;%&ndash;    `material.new` cause javax.el.ELException - bug tomcat &ndash;%&gt;--%>
<%--    <h3><spring:message code="${material.isNew() ? 'material.add' : 'material.edit'}"/></h3>--%>
<%--    <hr>--%>
<%--    <form method="post" action="tickets/materials">--%>
<%--        <input type="hidden" name="id" value="${material.id}">--%>
<%--        <dl>--%>
<%--            <dt><spring:message code="material.name"/>:</dt>--%>
<%--            <dd><input type="text" value="${material.name}" size=40 name="name" required></dd>--%>
<%--        </dl>--%>
<%--        <dl>--%>
<%--            <dt><spring:message code="material.quantity"/>:</dt>--%>
<%--            <dd><input type="number" value="${material.quantity}" name="quantity" required></dd>--%>
<%--        </dl>--%>
<%--        <dl>--%>
<%--            <dt><spring:message code="material.characteristics"/>:</dt>--%>
<%--            <dd><input type="text" value="${material.characteristics}" name="characteristics" required></dd>--%>
<%--        </dl>--%>
<%--        <button type="submit"><spring:message code="common.save"/></button>--%>
<%--        <button onclick="window.history.back()" type="button"><spring:message code="common.cancel"/></button>--%>
<%--    </form>--%>
<%--</section>--%>
</body>
</html>
