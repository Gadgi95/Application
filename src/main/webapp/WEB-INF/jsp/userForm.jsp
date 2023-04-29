<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="modal-dialog">
    <div class="modal-content">
        <section class="modal-body">
            <jsp:useBean id="user" class="com.example.application.model.User" scope="request"/>
            <%--    `meal.new` cause javax.el.ELException - bug tomcat --%>
            <h3><spring:message code="${user.isNew() ? 'user.add' : 'user.edit'}"/></h3>
            <hr>
            <form method="post" action="users">
                <input type="hidden" name="id" value="${user.id}">
                <div class="form-group">
                    <label for="name" class="col-form-label"><spring:message code="user.name"/>:</label>
                    <input type="text" class="form-control" id="name" name="name" value="${user.name}" size=40 required>
                </div>
                <div class="form-group">
                    <label for="email" class="col-form-label"><spring:message code="user.email"/>:</label>
                    <input type="text" class="form-control" id="email" value="${user.email}" name="email" required>
                </div>
                <div class="form-group">
                    <label for="password" class="col-form-label"><spring:message code="user.password"/>:</label>
                    <input type="password" class="form-control" id="password" value="${user.password}" name="password" required>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">
                        <span class="fa fa-check"></span>
                        <spring:message code="common.save"/>
                    </button>
                    <button onclick="window.history.back()" type="button" class="btn btn-secondary">
                        <span class="fa fa-close"></span>
                        <spring:message code="common.cancel"/>
                    </button>
                </div>
            </form>
        </section>
    </div>
</div>
</body>
</html>
