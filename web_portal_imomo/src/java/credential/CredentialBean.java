/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package credential;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Raphaël
 */
@ManagedBean(name = "credentialBean")
@SessionScoped
public class CredentialBean implements Serializable
    {
    /*-------------------------------------------------------------------------------------
     Attributs
     --------------------------------------------------------------------------------------*/
    private boolean loggedIn;
    private String username;
    private String password;
    @EJB
    private sessionBeans.UserFacade ejbUser;
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean navigationBean;
    /*-------------------------------------------------------------------------------------
     Constructor
     --------------------------------------------------------------------------------------*/
    public CredentialBean()
        {
        }
    /*-------------------------------------------------------------------------------------
     Methods public
     --------------------------------------------------------------------------------------*/
    public void login(ActionEvent actionEvent)
        {
        String hashedPassword = tools.Tools.hashPassword(password);
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        System.out.println("credential : " + username + " , " + hashedPassword);
        if (this.ejbUser.exists(username, hashedPassword) && this.ejbUser.isActived(username))
            {
            System.out.println("credential ok");
            try
                {
                this.loggedIn = true;
                FacesContext.getCurrentInstance().getExternalContext().redirect(navigationBean.redirectToSamePageFullPath());
                }
            catch (IOException ex)
                {
                Logger.getLogger(CredentialBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        else
            {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            context.addCallbackParam("loggedIn", loggedIn);
            loggedIn = false;
            }
        }
    public String doLogout()
        {
        this.loggedIn = false;
        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return navigationBean.redirectToIndex();
        }
    public boolean hasRequiredRole(String requiredRole)
        {
        return this.ejbUser.hasRequiredRole(requiredRole, username);
        }
    /*-----------------------------------
     get
     ------------------------------------*/
    public String getUsername()
        {
        return username;
        }
    public String getPassword()
        {
        return password;
        }
    public NavigationBean getNavigationBean()
        {
        return navigationBean;
        }
    /*-----------------------------------
     set
     ------------------------------------*/
    public void setUsername(String username)
        {
        this.username = username;
        }
    public void setPassword(String password)
        {
        this.password = password;
        }
    public void setLoggedIn(boolean loggedIn)
        {
        this.loggedIn = loggedIn;
        }
    public void setNavigationBean(NavigationBean navigationBean)
        {
        this.navigationBean = navigationBean;
        }
    /*-----------------------------------
     is
     ------------------------------------*/
    public boolean isLoggedIn()
        {
        return loggedIn;
        }
    }
