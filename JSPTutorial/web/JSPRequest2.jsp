<%-- 
    Document   : JSPRequest2
    Created on : 6 oct. 2013, 21:23:31
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
        <h1>Welcome to my first JSP using Request Object!</h1>
        
        <p> This is the submitted text: "<%=request.getParameter("mytext")%>" </p>
        
        
    </body>
</html>
