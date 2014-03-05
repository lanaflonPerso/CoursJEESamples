<%-- 
    Document   : index
    Created on : 5 nov. 2013, 14:02:38
    Author     : nabil.ouerhani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="prod" scope="session" class="model.Produit" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Application simple : Panier</h1>
        
        <form name="myForm" action="response.jsp">

            <P>       <select name="produit">
                    <option>Ordinateur</option>
                    <option> iPad</option>
                    <option>iPhone</option>
                </select> Choisir un produit
            </P>
            
            <P> <input type="text" name="note1" value="" /> choisir quantité</P>
            

            <!-- <P> <input type="text" name="myCours" value="" />sample text</P> -->

            <P> <input type="submit" value="Soumettre" name="Soumettre" /> </P>
            
            <table border="2">
                <thead>
                    <tr>
                        <th>Article</th>
                        <th>Quantité</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> Ordinateur</td>
                        <td> 2      </td>
                    </tr>
                    <tr>
                        <td>iPad  </td>
                        <td>3   </td>
                    </tr>
                    <tr>
                        <td>iPhone</td>
                        <td>4</td>
                    </tr>
                </tbody>
            </table>

            
    </body>
</html>
