<%-- 
    Document   : accessCount
    Created on : 5 oct. 2013, 21:51:11
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

        <%! private int accessCount = 0;%> 
        Accesses to page since server reboot: <%= ++accessCount%>
        
        <p> Votre Session ID est <%=session.getId()%>
    </body>
</html>
