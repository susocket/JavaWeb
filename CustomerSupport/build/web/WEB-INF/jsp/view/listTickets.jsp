<%@ page session="false" import="java.util.Map" %>

<%--@elvariable id="ticketDatabase" type="java.util.Map<Integer, Ticket>"--%>
<%--@elvariable id="ticket" type="com.wrox.Ticket"--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Customer Support</title>
    </head>
    <body>
        <a href="<c:url value="/login?logout" />">Logout</a> <br /><br />
        <h2>Tickets</h2>
        <a href="<c:url value="/tickets">
               <c:param name="action" value="create" />
           </c:url>">Create Ticket</a><br /><br />
        <c:set var="ticketDatabase" value="${pageContext.request.getAttribute('ticketdatabase')}"/>
        <c:if test="${ticketDatabase.size() == 0}" >
            <i>There is no tickets in the system.</i><br />
        </c:if>

        <c:forEach items="${ticketDatabase}" var="entry">       
            Ticket #<c:out value="${entry.key}" />:
            <a href="<c:url value="tickets">
                   <c:param name="action" value="view" />
                   <c:param name="ticketId" value="${entry.key}" />
               </c:url>">
                <c:out value="${entry.value.subject}" />
            </a>
            (customer: ${entry.value.customerName})<br />
        </c:forEach>
        <br />
        <a href="<c:url value="/sessions" />">View Sessions</a>
    </body>
</html>