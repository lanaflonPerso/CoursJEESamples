<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>City Detail</title>
            <link rel="stylesheet" type="text/css" href="/myJSF/faces/jsfcrud.css" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>City Detail</h1>
        <h:form>
            <h:panelGrid columns="2">
                <h:outputText value="Id:"/>
                <h:outputText value="#{city.city.id}" title="Id" />
                <h:outputText value="Name:"/>
                <h:outputText value="#{city.city.name}" title="Name" />
                <h:outputText value="CountryCode:"/>
                <h:outputText value="#{city.city.countryCode}" title="CountryCode" />
                <h:outputText value="District:"/>
                <h:outputText value="#{city.city.district}" title="District" />
                <h:outputText value="Population:"/>
                <h:outputText value="#{city.city.population}" title="Population" />


            </h:panelGrid>
            <br />
            <h:commandLink action="#{city.remove}" value="Destroy">
                <f:param name="jsfcrud.currentCity" value="#{jsfcrud_class['sample.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][city.city][city.converter].jsfcrud_invoke}" />
            </h:commandLink>
            <br />
            <br />
            <h:commandLink action="#{city.editSetup}" value="Edit">
                <f:param name="jsfcrud.currentCity" value="#{jsfcrud_class['sample.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][city.city][city.converter].jsfcrud_invoke}" />
            </h:commandLink>
            <br />
            <h:commandLink action="#{city.createSetup}" value="New City" />
            <br />
            <h:commandLink action="#{city.listSetup}" value="Show All City Items"/>
            <br />
            <br />
            <h:commandLink value="Index" action="welcome" immediate="true" />

        </h:form>
        </body>
    </html>
</f:view>
