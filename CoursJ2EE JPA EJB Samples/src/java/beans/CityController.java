/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.City;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import facades.CityFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nabil.ouerhani
 */
@Named(value = "cityController")
@Dependent
public class CityController {

    //Il Faut ajouter l'annotation EJB
    @EJB
    private CityFacade cityFacade;

    /**
     * Creates a new instance of CityController
     */
    public CityController() {
        invalidateCache();
    }

    public List<City> getAllCities() {

        invalidateCache();
        return cityFacade.findAll();
    }

    public List<City> getCitiesStartingWith(String s) {

        invalidateCache();
        return cityFacade.findCityAlpha(s);
    }

    public void invalidateCache() {

        ExternalContext context =
                FacesContext.getCurrentInstance().getExternalContext();

        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        response.setContentType("text/html;charset=UTF-8");

        response.setHeader("Cache-Control", "no-cache, no-store, mu st-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.
    }
}
