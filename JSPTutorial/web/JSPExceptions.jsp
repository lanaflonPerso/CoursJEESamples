<%-- 
    Document   : JSPExceptions
    Created on : 5 oct. 2013, 17:31:44
    Author     : nabil.ouerhani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/JSPErrorPage.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to my JSP Exception</h1>

        <% int var = 90;%>
        Division par <% var = var / 0;%> <%= var%>

    </body>
</html>
