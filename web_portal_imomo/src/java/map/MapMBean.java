/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import com.google.gson.Gson;
import entities.Datavalues;
import entities.Sites;
import entities.User;
import entities.Variables;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Raphaël
 */
@ManagedBean(name = "mapBean")
@SessionScoped
public class MapMBean implements Serializable
    {
    /*-------------------------------------------------------------------------------------
     Attributs
     --------------------------------------------------------------------------------------*/
    private MapModel model;
    @EJB
    private sessionBeans.SitesFacade ejbSites;
    @EJB
    private sessionBeans.DatavaluesFacade ejbDatavalues;
    @EJB
    private sessionBeans.VariablesFacade ejbVariables;
    @EJB
    private sessionBeans.UserFacade ejbUser;
    private String siteName;
    /*-------------------------------------------------------------------------------------
     Constructor
     --------------------------------------------------------------------------------------*/
    public MapMBean()
        {
        }
    /*-------------------------------------------------------------------------------------
     Methods public
     --------------------------------------------------------------------------------------*/
    public void onMarkerSelect(OverlaySelectEvent event)
        {
        System.out.println("onMarkerSelect");
        Marker marker = (Marker) event.getOverlay();
        System.out.println("MARKER title : " + marker.getTitle());
        this.siteName = marker.getTitle();
//        this.getData();
        }
    public void addMessage(FacesMessage message)
        {
        FacesContext.getCurrentInstance().addMessage(null, message);
        }
    /*-----------------------------------
     get
     ------------------------------------*/
    public String getData()
        {
        //Création des containers pour JSON
        List<Object> listForJSON = new ArrayList<Object>();
        Sites currentSite = this.getCurrentSite();
        if (currentSite != null)
            {
            System.out.println("getData : " + currentSite.getSiteName());
            //Récupération des infos du site courrant et de ces valeurs
            this.takeSiteInfo(listForJSON, currentSite);
            this.takeAllData(listForJSON, currentSite);
            }
        Gson gson = new Gson();
        String json = gson.toJson(listForJSON);
        return json;
        }
    public MapModel getModel()
        {
        if (model == null)
            {
            model = new DefaultMapModel();
            }

        List<Sites> listSites = this.ejbSites.findAll();
        for (Sites site : listSites)
            {
            LatLng c = new LatLng(site.getLatitude(), site.getLongitude());
            model.addOverlay(new Marker(c, site.getSiteName()));
            }
        return model;
        }
    /*-----------------------------------
     set
     ------------------------------------*/
    public void setModel(MapModel model)
        {
        this.model = model;
        }
    /*-------------------------------------------------------------------------------------
     Methods private
     --------------------------------------------------------------------------------------*/
    private Sites getCurrentSite()
        {
        try
            {
            System.out.println("BEFORE ejbSites : SiteName = " + this.siteName);
            return this.ejbSites.getSite(this.siteName);
            }
        catch (Exception e)
            {
            return null;
            }
        }
    /**
     * Récupération des informations du site courrant Si il y a une erreur, celle-ci est récupérée momentanément pour être affichée.
     */
    private void takeSiteInfo(List<Object> listForJSON, Sites currentSite)
        {
        Map<String, String> mapSiteInfo = new TreeMap<String, String>();
        try
            {
            //Des numéro on été ajouté au début de chaque clé pour permettre l'affichage dans un certain ordre (utilisation d'un TreeMap)
            mapSiteInfo.put("0", currentSite.getCounty());
            mapSiteInfo.put("10", currentSite.getState());
            mapSiteInfo.put("20", currentSite.getSiteName());
            mapSiteInfo.put("30", currentSite.getLatitude() + "," + currentSite.getLongitude());
            }
        catch (Exception e)
            {
            String strError = "takeSiteInfo : " + e.getMessage();
            System.out.println(strError);
            mapSiteInfo.put("Error takeSiteInfo", strError);
            }
        listForJSON.add(mapSiteInfo);
        }
    /**
     * Récupération des toutes les valeurs du site avec les dates et le nom de la personne ayant pris la mesure
     */
    private void takeAllData(List<Object> listForJSON, Sites currentSite)
        {
        Map<String, Map<String, List<Object>>> mapVariableValue = new TreeMap<String, Map<String, List<Object>>>();
        try
            {
            //Récupération de toutes les valeurs d'un site
            List<Datavalues> listValuesFromSite = this.ejbDatavalues.getDatavalues(currentSite);

            //Pour chaque valeurs, on détermine le nom de la variable associé et la date
            for (Datavalues currentDataValue : listValuesFromSite)
                {
                //Récupération de la variable
                Variables currentVariable = this.ejbVariables.find(currentDataValue.getVariableID().getVariableID());

                //Récupération de la date, du nom de variable et de la valeur
                String currentVariableName = currentVariable.getVariableName().getDefinition();
                String currentDateTime = currentDataValue.getDateTimeUTC().getTime() + "";
                Double currentValue = currentDataValue.getDataValue();

                //Si la map ne contient pas le nom de variable courrante, on crée une nouvelle paire clé valeur
                if (!mapVariableValue.keySet().contains(currentVariableName))
                    {
                    mapVariableValue.put(currentVariableName, new TreeMap<String, List<Object>>());
                    }

                List<Object> listUserValue = new ArrayList<Object>();
                User currentUser;
                try
                    {
                    //Récupération de l'utilisateur
                    currentUser = this.ejbUser.find(currentDataValue.getUserID().getUserID());
                    listUserValue.add(currentUser.getFirstname() + "" + currentUser.getLastname());
                    }
                catch (Exception e)
                    {
                    listUserValue.add("no name");
                    }

                listUserValue.add(currentValue);
                mapVariableValue.get(currentVariableName).put(currentDateTime, listUserValue);
                }
            }
        catch (Exception e)
            {
            String strError = "takeAllData : " + e.toString();
            System.out.println(strError);
            ((Map<String, String>) listForJSON.get(0)).put("Error takeAllDate", strError);
            }

        listForJSON.add(mapVariableValue);
        }
    }
