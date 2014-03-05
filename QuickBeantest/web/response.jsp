<%-- 
    Document   : response
    Created on : 5 nov. 2013, 12:48:49
    Author     : nabil.ouerhani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Compteur" %>

<!DOCTYPE html>

<jsp:useBean id="compteur" scope="session" class="model.Compteur" />
<jsp:setProperty name="compteur" property="*" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p> Compteur = <%=compteur.getCount() %> <p>
    </body>
</html>
