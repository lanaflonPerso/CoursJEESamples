<%-- 
    Document   : response
    Created on : 3 nov. 2013, 22:43:57
    Author     : nabil.ouerhani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="txt" scope="session" class="beans.MonTexte" />
<jsp:setProperty name="txt" property="*" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <p> Txt is: <%= txt.getMonTxt() %>
                    <p> Txt 2 is: <%= txt.getMonTxt2() %>
                    <p> Num is: <%= txt.getNum()%>

    </body>
</html>
