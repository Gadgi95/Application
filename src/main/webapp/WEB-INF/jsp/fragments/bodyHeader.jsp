<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<header>
    <div style="display: table;">
        <div>
            <a href="tickets"><img src="resources/images/topdomBlack.png"></a>
        </div>
        <div style="display: table-cell;">${userTo.name}
            <a class="header_title" href="tickets"><spring:message code="${register ? 'app.home' : 'app.title'}"/></a>
        </div>
        <sec:authorize access="isAuthenticated()">
            <sec:authorize access="hasRole('ADMIN')">
                <div class="header_div_reference">
                    <a class="header_reference" href="users"><spring:message code="user.titleS"/></a>
                </div>
            </sec:authorize>
            <div class="header_div_reference">
                <a class="header_reference" href="profile">${userTo.name} <spring:message code="app.profile"/></a>
            </div>
            <div class="header_div_reference">
                <a class="header_reference" href="logout"> выход</a>
            </div>
        </sec:authorize>
    </div>
</header>
