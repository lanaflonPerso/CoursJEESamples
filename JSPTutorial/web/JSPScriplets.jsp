<%-- 
    Document   : JSPScriplets
    Created on : 5 oct. 2013, 10:49:07
    Author     : nabil.ouerhani
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to first JSP Scriplet!</h1>
        <%
            // This scriptlet declares and initializes "date"
            System.out.println("Evaluating date now");
            java.util.Date date = new java.util.Date();
            out.println(String.valueOf(date));

            // The following scriptlets generate HTML output
            out.println("<br>Your machine's address is: ");
            out.println(request.getRemoteHost());
        %> 
    </body>
</html>
