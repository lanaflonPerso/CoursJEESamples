<%-- 
    Document   : response
    Created on : 6 oct. 2013, 12:57:33
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
        <h1>Calculateur de la note moyenne!</h1>

        <%

            float a = Float.parseFloat(request.getParameter("Note_TE_1"));
            float b = Float.parseFloat(request.getParameter("Note_TE_2"));
            float c = Float.parseFloat(request.getParameter("Note_TP"));


            out.println("Le cours choisi est: " + request.getParameter("Cours"));
        %>
        <p>Note TE 1 = <%=a%> </p>
        <p>Note TE 2 = <%=b%> </p>
        <p>Note TE 3 = <%=c%> </p>

        <h3>
            <p>Note Moyenne = <%=(a+b+c)/3.0%> </p>
        </h3>
        <p></p> <p></p>
        <p> Votre Session ID est <%=session.getId()%>
    </body>
</html>
