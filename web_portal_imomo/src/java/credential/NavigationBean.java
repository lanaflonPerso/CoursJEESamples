/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package credential;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Raphaël
 */
@Named(value = "navigationBean")
@SessionScoped
public class NavigationBean implements Serializable
    {
    /*-------------------------------------------------------------------------------------
     Constructor
     --------------------------------------------------------------------------------------*/
    public NavigationBean()
        {
        }
    /**
     * Redirect to login page.
     *
     * @return Login page name.
     */
    /*-------------------------------------------------------------------------------------
     Methods public
     --------------------------------------------------------------------------------------*/
    public String redirectToIndex()
        {
        return "/index.xhtml?faces-redirect=true";
        }
    /**
     * Go to login page.
     *
     * @return Login page name.
     */
    public String toIndex()
        {
        return "/index.xhtml";
        }
    /**
     * Redirect to welcome page.
     *
     * @return Welcome page name.
     */
    public String redirectToWelcome()
        {
        return "/private/welcome.xhtml?faces-redirect=true";
        }
    /**
     * Go to welcome page.
     *
     * @return Welcome page name.
     */
    public String toWelcome()
        {
        return "/private/welcome.xhtml";
        }
    /**
     * Go to the same page
     *
     * @return
     */
    public String toSamePage()
        {
        return tools.Tools.getCurrentPageAdress();
        }
    public String redirectToSamePageFullPath()
        {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest servletRequest = (HttpServletRequest) ctx.getExternalContext().getRequest();
        return servletRequest.getRequestURI() + "?faces-redirect=true";
        }
    }
