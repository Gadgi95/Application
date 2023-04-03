<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
    <div class="form_profile">
        <h3 class="title_profile">${userTo.name} <spring:message code="${register ? 'app.register' : 'app.profile'}"/></h3>
        <form:form modelAttribute="userTo" method="post" action="${register ? 'profile/register' : 'profile'}"
                   charset="utf-8" accept-charset="UTF-8">
            <div class="input_profile">
                <!--Без тега spring:bind сприг не отправляет значения input-->
                <spring:bind path="name">
                <div ${status.error ? 'error' : '' }>
                    <form:input path="name" type="text" placeholder="${userTo.name}" name="name"/>
                    <label>Введите имя</label>
                </div>
                </spring:bind>
                    <br>
                <spring:bind path="email">
                <div ${status.error ? 'error' : '' }>
                    <form:input path="email" type="email" placeholder="${userTo.email}" name="email"/>
                    <label>Введите почту</label>
                </div>
                </spring:bind>
                    <br>
                <spring:bind path="password">
                <div ${status.error ? 'error' : '' }>
                    <form:input path="password" type="password" name="password"/>
                    <label>Введите пароль</label>
                </div>
                </spring:bind>

                <div>
                    <a class="submit_reg_cancel" href="#" onclick="window.history.back()">
                        <span class="fa fa-close"></span>
                        <spring:message code="common.cancel"/>
                    </a>
                    <button class="submit_reg_save" type="submit">
                        <span class="fa fa-check"></span>
                        <spring:message code="common.save"/>
                    </button>
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>