<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Panier d'Achat</title>
    </head>
    <body>
        <a href="Add?fruit=Banane">Ajouter banane</a><br />
        <a href="Add?fruit=Fraise">Ajouter fraise</a><br />
        <a href="Add?fruit=Orange">Ajouter orange</a><br />
        <br />
        <c:if test="${empty sessionScope}">
            <h3>Pas de fruit dans le panier !</h3>
        </c:if>
        <c:if test="${not empty sessionScope }">
            <c:forEach var="fruit" varStatus="status" items="${sessionScope.monPanier.fruits}" >
                <c:if test="${ status.first }">
                    <table border="1">
                        <thead>
                            <tr>
                                <td style="font-weight: bold">Fruit</td>
                                <td style="font-weight: bold">Montant</td>
                            </tr>
                        </thead>
                        <tbody>
                        </c:if>
                        <tr>
                            <td>${fruit.key}</td>
                            <td>${fruit.value}</td>
                        </tr>
                        <c:if test="${ status.last }">
                        </tbody>
                    </table>
                </c:if>
            </c:forEach>
        </c:if>
    </body>
</html>
