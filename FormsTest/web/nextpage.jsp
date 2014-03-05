<%-- 
    Document   : index
    Created on : 4 nov. 2013, 13:48:22
    Author     : nabil.ouerhani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="count" scope="application" class="model.Counter" />
<jsp:setProperty name="count" property="*" />



<html>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <h1>Next page</h1>

        <form name="myFormR" action="nextpage.jsp">


            <P> <input type="text" name="count" value="" />Note TP (float)</P>

            <!-- <P> <input type="text" name="myCours" value="" />sample text</P> -->

            <P> <input type="submit" value="Soumettre" name="Soumettre" /> </P>

        </form>

        <p> current count is <%=count.getCount() %> <p> 
        
        <form name="myFormI" action="response.jsp">

            <P> <input type="submit" value="SoumettreF" name="SoumettreF" /> </P>

        </form>  
    </body>
</html>
