<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div>
    <h3>${userTo.name} <spring:message code="${register ? 'app.register' : 'app.profile'}"/></h3>
    <form:form modelAttribute="userTo" method="post" action="${register ? 'profile/register' : 'profile'}"
               charset="utf-8" accept-charset="UTF-8">

        <!--Без тега spring:bind сприг не отправляет значения input-->
        <spring:bind path="name">
        <div>
            <label>Введите имя
                <form:input path="name" type="text" placeholder="${userTo.name}" id="name"/>
            </label>
        </div>
        </spring:bind>
            <br>
        <spring:bind path="email">
        <div>
            <label>Введите почту
                <form:input path="email" type="email" placeholder="${userTo.email}" id="email"/>
            </label>
        </div>
        </spring:bind>
            <br>
        <spring:bind path="password">
        <div>
            <label>Введите пароль
                <form:input path="password" type="password" id="password"/>
            </label>
        </div>
        </spring:bind>

        <div>
            <a href="#" onclick="window.history.back()">
                <span class="fa fa-close"></span>
                <spring:message code="common.cancel"/>
            </a>
            <button type="submit">
                <span class="fa fa-check"></span>
                <spring:message code="common.save"/>
            </button>
        </div>
    </form:form>
</div>
</body>
</html>