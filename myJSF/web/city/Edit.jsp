<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing City</title>
            <link rel="stylesheet" type="text/css" href="/myJSF/faces/jsfcrud.css" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Editing City</h1>
        <h:form>
            <h:panelGrid columns="2">
                <h:outputText value="Id:"/>
                <h:outputText value="#{city.city.id}" title="Id" />
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
            <h:commandLink action="#{city.edit}" value="Save">
                <f:param name="jsfcrud.currentCity" value="#{jsfcrud_class['sample.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][city.city][city.converter].jsfcrud_invoke}"/>
            </h:commandLink>
            <br />
            <br />
            <h:commandLink action="#{city.detailSetup}" value="Show" immediate="true">
                <f:param name="jsfcrud.currentCity" value="#{jsfcrud_class['sample.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][city.city][city.converter].jsfcrud_invoke}"/>
            </h:commandLink>
            <br />
            <h:commandLink action="#{city.listSetup}" value="Show All City Items" immediate="true"/>
            <br />
            <br />
            <h:commandLink value="Index" action="welcome" immediate="true" />

        </h:form>
        </body>
    </html>
</f:view>
