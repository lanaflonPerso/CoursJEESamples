<%-- 
    Document   : moreInformationRequestWithBean
    Created on : 3 nov. 2013, 22:15:38
    Author     : nabil.ouerhani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="beans.MoreInfoRequest"%>

<jsp:useBean id="infoRequest" scope="session" class="beans.MoreInfoRequest"/>
<jsp:setProperty name="infoRequest" property="*"/>
<html>
<head>
<title>Thankyou for your request</title>
</head>
<body>
<h1>Thankyou for your request</h1>
Thankyou for your request for more information.
It will be sent to you shortly.

<p> The value of email is: <% infoRequest.getEmail();%> <p>
<p>Click <a href="displayYourRequest.jsp">here</a> to view your request.
</body>
</html>

