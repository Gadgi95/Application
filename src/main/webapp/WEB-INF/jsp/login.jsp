<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<div>
    <div>
        <img src="resources/images/home.png"> <big><big><spring:message code="app.title"/></big></big>
    </div>
    <form action="spring_security_check" method="post">
        <input type="text" placeholder="Email" name="username">
        <input type="password" placeholder="Password" name="password"> <input type="submit" value="Вход">
    </form>
</div>

<div>
    <div>
        <c:if test="${param.error}">
            <div>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>
        </c:if>
        <c:if test="${not empty param.message}">
            <div><spring:message code="${param.message}" text=""/></div>
        </c:if>
        <div><a href="profile/register"><spring:message code="app.register"/></a></div>
        <br/>
        <section>
            <form method="post" action="users">
                <spring:message code="app.login"/>: <select name="userId">
                <option value="1" selected>Admin</option>
                <option value="2">User</option>
            </select>
                <button type="submit"><spring:message code="common.select"/></button>
            </form>
        </section>
        <br/>
    </div>
</div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>