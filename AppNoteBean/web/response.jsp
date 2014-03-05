<%-- 
    Document   : response
    Created on : 3 nov. 2013, 23:26:35
    Author     : nabil.ouerhani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="mynote" scope="session" class="beans.MaNote" />
<jsp:setProperty name="mynote" property="*" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Calculateur de la note moyenne!</h1>
        
        <p> mon cours est : <%=mynote.getMyCours()%> <p>
        <p> ma note 1 est : <%=mynote.getNote1()%> <p>
        <p> ma note 2 est : <%=mynote.getNote2()%> <p>
        <p> ma note 3 est : <%=mynote.getNote3()%> <p>

        <p> La note moyenne est : <%=mynote.getMoyenne()%> <p>
            
            
            <p></p> <p></p>
        <p> Votre Session ID est <%=session.getId()%>


    </body>
</html>
