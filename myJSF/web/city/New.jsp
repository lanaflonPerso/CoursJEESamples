<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New City</title>
            <link rel="stylesheet" type="text/css" href="/myJSF/faces/jsfcrud.css" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>New City</h1>
        <h:form>
            <h:inputHidden id="validateCreateField" validator="#{city.validateCreate}" value="value"/>
            <h:panelGrid columns="2">
                <h:outputText value="Name:"/>
                <h:inputText id="name" value="#{city.city.name}" title="Name" required="true" requiredMessage="The name field is required." />
                <h:outputText value="CountryCode:"/>
                <h:inputText id="countryCode" value="#{city.city.countryCode}" title="CountryCode" required="true" requiredMessage="The countryCode field is required." />
                <h:outputText value="District:"/>
                <h:inputText id="district" value="#{city.city.district}" title="District" required="true" requiredMessage="The district field is required." />
                <h:outputText value="Population:"/>
                <h:inputText id="population" value="#{city.city.population}" title="Population" required="true" requiredMessage="The population field is required." />

            </h:panelGrid>
            <br />
            <h:commandLink action="#{city.create}" value="Create"/>
            <br />
            <br />
            <h:commandLink action="#{city.listSetup}" value="Show All City Items" immediate="true"/>
            <br />
            <br />
            <h:commandLink value="Index" action="welcome" immediate="true" />

        </h:form>
        </body>
    </html>
</f:view>
