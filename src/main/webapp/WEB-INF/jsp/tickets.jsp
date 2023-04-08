<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://Application.example.com/functions" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <h3 class="text-center"><spring:message code="ticket.title"/></h3>
        <div class="card border-dark">
            <div class="card-body pb-0">
                <form id="filter" method="get" action="tickets/filter">
                    <div class="row">
                        <div class="col-2">
                            <label for="startDate"><spring:message code="ticket.startDate"/>:</label>
                            <input class="form-control" id="startDate" type="date" name="startDate" autocomplete="off" value="${param.startDate}">
                        </div>
                        <div class="col-2">
                            <label for="endDate"><spring:message code="ticket.endDate"/>:</label>
                            <input class="form-control" type="date" name="endDate" id="endDate" autocomplete="off" value="${param.endDate}">
                        </div>
                        <div class="offset-2 col-3">
                            <label for="startTime"><spring:message code="ticket.startTime"/>:</label>
                            <input class="form-control" type="time" name="startTime" id="startTime" autocomplete="off" value="${param.startTime}">
                        </div>
                        <div class="col-3">
                            <label for="endTime"><spring:message code="ticket.endTime"/>:</label>
                            <input class="form-control" name="endTime" id="endTime" type="time" autocomplete="off" value="${param.endTime}">
                        </div>
                        <button class="btn btn-primary" type="submit">
                            <span class="fa fa-filter"></span>
                            <spring:message code="ticket.filter"/>
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <br/>
        <button class="btn btn-primary">
            <span class="fa fa-plus"></span>
            <a class="button_users" href="tickets/create">
                <spring:message code="ticket.add"/>
            </a>
        </button>
        <table class="table table-striped" id="datatable">
            <thead>
            <tr>
                <th><spring:message code="ticket.creationDate"/></th>
                <th><spring:message code="ticket.objectName"/></th>
                <th><spring:message code="ticket.name"/></th>
                <th><spring:message code="ticket.responsibleForeman"/></th>
                <th><spring:message code="ticket.responsibleSupplier"/></th>
                <th><spring:message code="ticket.deliveryDate"/></th>
                <th><spring:message code="ticket.status"/></th>
                <th><spring:message code="ticket.statusChangeDate"/></th>
                <th><spring:message code="ticket.isClosed"/></th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${requestScope.tickets}" var="ticket">
                <jsp:useBean id="ticket" type="com.example.application.to.TicketTo"/>
                <tr data-ticket-excess="${ticket.excess}">
                    <td>
                            ${fn:formatDateTime(ticket.creationDate)}
                    </td>
                    <td>${ticket.objectName}</td>
                    <td>${ticket.name}</td>
                    <td>${ticket.responsibleForeman}</td>
                    <td>${ticket.responsibleSupplier}</td>
                    <td>${ticket.deliveryDate}</td>
                    <td>${ticket.status}</td>
                    <td>${ticket.statusChangeDate}</td>
                    <td>${ticket.closed}</td>
                    <td><button><a class="button_users" href="tickets/update?id=${ticket.id}"><span class="fa fa-pencil"></span></a></button></td>
                    <td><button><a class="button_users" href="tickets/delete?id=${ticket.id}"><span class="fa fa-remove"></span></a></button></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>