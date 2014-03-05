<%-- 
    Document   : mainJSP
    Created on : 26 sept. 2013, 15:59:44
    Author     : nabil.ouerhani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <%
            // This scriptlet declares and initializes "date"
            System.out.println("Evaluating date now");
            java.util.Date date = new java.util.Date();
        %>
        Hello!  The time is now
        <%
            out.println(date);
            out.println("<BR>Your machine's address is ");
            out.println(request.getRemoteHost());
        %>

    </body>
</html>
