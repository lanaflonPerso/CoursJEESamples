/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Countrylanguage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;
import sessionbeans.CountrylanguageFacade;

/**
 *
 * @author nabil.ouerhani
 */
@Named(value = "pageController")
@RequestScoped
public class PageController {

    @EJB
    private CountrylanguageFacade countrylanguageFacade;
        private String[] resultPages = {"page1", "page2", "page3"};

    public String PageController() {

        incalidateCache();
        Random random = new Random();

        int i = random.nextInt(3);
        return (resultPages[i]);
    }

    public List<SelectItem> getList() {

        List<SelectItem> list = new ArrayList<SelectItem>();
        SelectItem e = new SelectItem("Item1", "item1");
        list.add(e);
        e = new SelectItem("Item2", "item2");
        list.add(e);
        e = new SelectItem("Item3", "item3");
        list.add(e);

        return list;
    }

    // la méthode façade doit ête appelée à l'intérieur d'une méthode de la calsse actuelle
    public List<Countrylanguage> getAllLanguages() {

        incalidateCache();
        List<Countrylanguage> mylist = countrylanguageFacade.findAll();

        return mylist;
    }

    //Requête custom
    public List<Countrylanguage> getLanguagesByCountryCode(String code) {

        incalidateCache();
        List<Countrylanguage> mylist = countrylanguageFacade.getLanguages(code);

        return mylist;
    }

    public void incalidateCache() {

        ExternalContext context =
                FacesContext.getCurrentInstance().getExternalContext();

        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        response.setContentType("text/html;charset=UTF-8");

        response.setHeader("Cache-Control", "no-cache, no-store, mu st-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.
    }
}
