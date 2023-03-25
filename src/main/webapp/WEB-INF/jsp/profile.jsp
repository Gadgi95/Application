<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>


<div>
    <h3>${userTo.name} <spring:message code="${register ? 'app.register' : 'app.profile'}"/></h3>
    <form:form class="form-group" modelAttribute="userTo" method="post" action="${register ? 'profile/register' : 'profile'}"
               charset="utf-8" accept-charset="UTF-8">

        <label>Введите имя
            <input type="text" placeholder="${userTo.name}" id="name"/>
        </label>
        <br>
        <label>Введите почту
            <input type="email" placeholder="${userTo.email}" id="email"/>
        </label>
        <br>
        <label>Введите пароль
            <input type="password" id="password"/>
        </label>

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

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>