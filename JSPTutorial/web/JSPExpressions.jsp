<%-- 
    Document   : tests
    Created on : 5 oct. 2013, 10:25:36
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
        <h1>Welcome to my first JSP expressions!</h1>

        <p>The sum of (195, 9, 273) is: <%= (195 + 9 + 273)%><p>
        <p>The square root of 5 is <%= Math.sqrt(5)%></p>
        <p>Current time is: <%=  new java.util.Date()%></p>
   
    </body>
</html>
