<%-- 
    Document   : session
    Created on : 2016-4-10, 14:05:38
    Author     : UUU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>

<%--@elvariable id="ticketId" type="javax.servlet.http.HttpSession"--%>
<!DOCTYPE html>

<%!
    private static String toString(long timeInterval) {
        if (timeInterval < 1_000) {
            return "less than one second";
        }
        if (timeInterval < 60_000) {
            return (timeInterval / 1_000) + "seconds";
        }
        return "about " + (timeInterval / 60_000) + " minutes.";
    }
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Support</title>
    </head>
    <body>
        <a href="<c:url value="/login?logout" />">Logout</a>

        <h2>Sessions</h2>
        There is a total of <c:out value="${numberOfSessions}" /> active sessions in this application. <br /><br />

        <c:set var="timestamp" value="${System.currentTimeMillis()}" />
        <c:forEach var="asession" items="${sessionList}">
            <c:out value="${asession.id}" />-
            <c:out value="${asession.getAttribute('username')}" />
            <c:if test="${asession.id eq pageContext.session.id}">
                <c:out value=" (you) "/>         
            </c:if>
            <c:out value=" - last active " />
            <c:out value="${timestamp - assession.lastAccessedTime()} " /> ago.
            <br />
        </c:forEach>

        <br />
        <br />
        <a href="<c:url value="/tickets" />">Return to list tickets</a>
    </body>
</html>
