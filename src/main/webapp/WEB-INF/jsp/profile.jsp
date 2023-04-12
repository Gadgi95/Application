<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <div class="row">
            <div class="col-5 offset-3">
                <h3>${userTo.name} <spring:message code="${register ? 'app.register' : 'app.profile'}"/></h3>
                <form:form class="form-group" modelAttribute="userTo" method="post" action="${register ? 'profile/register' : 'profile'}"
                           charset="utf-8" accept-charset="UTF-8">
                    <!--Без тега spring:bind сприг не отправляет значения input-->
                    <spring:bind path="name">
                        <div class="form-group ${status.error ? 'error' : '' }">
                            <label class="col-form-label">Имя</label>
                            <form:input path="name" type="text" placeholder="${userTo.name}" name="name" class="form-control ${status.error ? 'is-invalid' : '' }"/>
                            <div class="invalid-feedback">${status.errorMessage}</div>
                        </div>
                    </spring:bind>
                        <br>
                    <spring:bind path="email">
                        <div class="form-group ${status.error ? 'error' : '' }">
                            <label class="col-form-label">Почта</label>
                            <form:input path="email" type="email" placeholder="${userTo.email}" name="email" class="form-control ${status.error ? 'is-invalid' : '' }"/>
                            <div class="invalid-feedback">${status.errorMessage}</div>
                        </div>
                    </spring:bind>
                        <br>
                    <spring:bind path="password">
                        <div class="form-group ${status.error ? 'error' : '' }">
                            <label class="col-form-label">Пароль</label>
                            <form:input path="password" type="password" name="password" class="form-control ${status.error ? 'is-invalid' : '' }"/>
                            <div class="invalid-feedback">${status.errorMessage}</div>
                        </div>
                    </spring:bind>

                    <div class="text-right">
                        <a class="btn btn-secondary" href="#" onclick="window.history.back()">
                            <span class="fa fa-close"></span>
                            <spring:message code="common.cancel"/>
                        </a>
                        <button class="btn btn-primary" type="submit">
                            <span class="fa fa-check"></span>
                            <spring:message code="common.save"/>
                        </button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>