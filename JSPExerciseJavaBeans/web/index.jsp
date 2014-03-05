<%-- 
    Document   : index
    Created on : 3 nov. 2013, 20:52:57
    Author     : nabil.ouerhani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculateur de la moyenne avec Java Beans</title>
    </head>
        <body>
        <h1>Bienvenue à la page du calculateur de la note moyenne</h1>
        
        <form name="myForm" action="response.jsp">
            <P>       <select name="Cours">
                <option>SW Engineering</option>
                <option>SW Quality</option>
                <option>Entreprise Architecture</option>
            </select> Choisir un cours
            </P>
            <P> <input type="text" name="Note_TE_1" value="" /> Note TE 1 (float)</P>
            <P> <input type="text" name="Note_TE_2" value="" />Note TE 2 (float)</P>
            <P> <input type="text" name="Note_TP" value="" />Note TP (float)</P>
            
            
            
           <P> <input type="submit" value="Soumettre" name="Soumettre" /> </P>
        </form>
        
    </body>
</html>
