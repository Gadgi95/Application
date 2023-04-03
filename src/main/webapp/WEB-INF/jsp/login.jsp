<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body class="body_login">
<form action="spring_security_check" method="post" class="form">
    <div class="wrapper">
        <div class="title"> <img src="resources/images/topdom.png"></div>
        <div class="container"> <spring:message code="app.title"/> </div>
    </div>
    <br>
    <div class="wrapper">
        <c:if test="${param.error}">
            <div class="error">Неверные учетные данные</div>
        </c:if>
        <c:if test="${not empty param.message}">
            <div><spring:message code="${param.message}" text=""/></div>
        </c:if>
    </div>
    <div class="input-container ic2">
        <!--Без атрибута name сприг не отправляет значения input-->
        <input id="email" class="input" type="email" placeholder=" " value="alexander@example.com" name="username">
        <div class="cut cut-short"></div>
        <label for="email" class="placeholder">Email</label>
    </div>
    <div class="input-container ic1">
        <input id="password" class="input" type="password" placeholder=" " value="admin" name="password">
        <div class="cut"></div>
        <label for="password" class="placeholder">Password</label>
    </div>
    <button type="submit" class="submit">
        Вход
    </button>
    <br>
    <br>
    <div class="wrapper"><a class="submit_reg" href="profile/register"><spring:message code="app.register"/></a></div>
    <br>
    <div class="footer">
        <spring:message code="app.footer"/>
    </div>
</form>
</body>
</html>

