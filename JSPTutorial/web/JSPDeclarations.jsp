<%-- 
    Document   : JSPDeclarations
    Created on : 5 oct. 2013, 11:01:22
    Author     : nabil.ouerhani
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to my first JSP declarations !</h1>

        <%! Date date = new java.util.Date();%>
        <%! int i = 5;%>
        <%! int j = 10;%>

        <%
            // This scriptlet declares and initializes "date"
            System.out.println("Evaluating date now");
            out.println(String.valueOf(date));

            // The following scriptlets generate HTML output
            out.println("<br>The sum of (i,j): ");
            out.println(i + j);
        %>

    </body>
</html>
