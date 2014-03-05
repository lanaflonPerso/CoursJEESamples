<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing City Items</title>
            <link rel="stylesheet" type="text/css" href="/myJSF/faces/jsfcrud.css" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Listing City Items</h1>
        <h:form styleClass="jsfcrud_list_form">
            <h:outputText escape="false" value="(No City Items Found)<br />" rendered="#{city.pagingInfo.itemCount == 0}" />
            <h:panelGroup rendered="#{city.pagingInfo.itemCount > 0}">
                <h:outputText value="Item #{city.pagingInfo.firstItem + 1}..#{city.pagingInfo.lastItem} of #{city.pagingInfo.itemCount}"/>&nbsp;
                <h:commandLink action="#{city.prev}" value="Previous #{city.pagingInfo.batchSize}" rendered="#{city.pagingInfo.firstItem >= city.pagingInfo.batchSize}"/>&nbsp;
                <h:commandLink action="#{city.next}" value="Next #{city.pagingInfo.batchSize}" rendered="#{city.pagingInfo.lastItem + city.pagingInfo.batchSize <= city.pagingInfo.itemCount}"/>&nbsp;
                <h:commandLink action="#{city.next}" value="Remaining #{city.pagingInfo.itemCount - city.pagingInfo.lastItem}"
                               rendered="#{city.pagingInfo.lastItem < city.pagingInfo.itemCount && city.pagingInfo.lastItem + city.pagingInfo.batchSize > city.pagingInfo.itemCount}"/>
                <h:dataTable value="#{city.cityItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Id"/>
                        </f:facet>
                        <h:outputText value="#{item.id}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Name"/>
                        </f:facet>
                        <h:outputText value="#{item.name}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="CountryCode"/>
                        </f:facet>
                        <h:outputText value="#{item.countryCode}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="District"/>
                        </f:facet>
                        <h:outputText value="#{item.district}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Population"/>
                        </f:facet>
                        <h:outputText value="#{item.population}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText escape="false" value="&nbsp;"/>
                        </f:facet>
                        <h:commandLink value="Show" action="#{city.detailSetup}">
                            <f:param name="jsfcrud.currentCity" value="#{jsfcrud_class['sample.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][city.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Edit" action="#{city.editSetup}">
                            <f:param name="jsfcrud.currentCity" value="#{jsfcrud_class['sample.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][city.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Destroy" action="#{city.remove}">
                            <f:param name="jsfcrud.currentCity" value="#{jsfcrud_class['sample.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][city.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                    </h:column>

                </h:dataTable>
            </h:panelGroup>
            <br />
            <h:commandLink action="#{city.createSetup}" value="New City"/>
            <br />
            <br />
            <h:commandLink value="Index" action="welcome" immediate="true" />


        </h:form>
        </body>
    </html>
</f:view>
