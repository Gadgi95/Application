<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<%--<jsp:include page="fragments/bodyHeader.jsp"/>--%>

<section>
    <jsp:useBean id="material" class="com.example.application.model.Material" scope="request"/>
    <%--    `material.new` cause javax.el.ELException - bug tomcat --%>
    <h3><spring:message code="${material.isNew() ? 'material.add' : 'material.edit'}"/></h3>
    <hr>
    <form method="post" action="tickets/materials/create">
        <input type="hidden" name="id" value="${material.id}">
        <dl>
            <dt><spring:message code="material.name"/>:</dt>
            <dd><input type="text" value="${material.name}" size=40 name="name" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="material.quantity"/>:</dt>
            <dd><input type="number" value="${material.quantity}" name="quantity" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="material.characteristics"/>:</dt>
            <dd><input type="text" value="${material.characteristics}" name="characteristics" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="material.hasFactoryMarriage"/>:</dt>
            <dd><input type="checkbox" value="${material.hasFactoryMarriage}" name="hasFactoryMarriage"></dd>
        </dl>
        <dl>
            <dt><spring:message code="material.marriageDescription"/>:</dt>
            <dd><input type="text" value="${material.marriageDescription}" name="marriageDescription"></dd>
        </dl>
        <button type="submit"><spring:message code="common.save"/></button>
        <button onclick="window.history.back()" type="button"><spring:message code="common.cancel"/></button>
    </form>
</section>
</body>
</html>