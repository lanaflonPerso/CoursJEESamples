<%-- 
    Document   : JSPUseBeans
    Created on : 7 oct. 2013, 08:23:10
    Author     : nabil.ouerhani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="myPackage.User" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to my first JSP Using javaBeans</h1>

        <jsp:useBean id="myUser" scope="session" class="myPackage.User" />

        <jsp:setProperty name="myUser" property="first_name" value="John" />
        <jsp:setProperty name="myUser" property="las_name" value="Mustermann" />
        <jsp:setProperty name="myUser" property="age" value="35" />

        <p> The first name is: <%=myUser.getFirst_name()%> </p>
        <p> The last name is: <%=myUser.getLas_name()%> </p>
        <p> The Age is: <%=myUser.getAge()%> </p>

    </body>
</html>
