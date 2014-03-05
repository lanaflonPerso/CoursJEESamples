<%-- 
    Document   : response
    Created on : 3 nov. 2013, 23:08:56
    Author     : nabil.ouerhani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="note" scope="session" class="beans.Note" />
<jsp:setProperty name="note" property="*" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <p> Le cours choisi est : <%=note.getCours() %> <p>
        
    </body>
</html>
