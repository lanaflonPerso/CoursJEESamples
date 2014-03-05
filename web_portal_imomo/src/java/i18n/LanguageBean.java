/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package i18n;

import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Another important attribute is eager. If eager="true" then managed bean is created before it is requested for the first time otherwise "lazy" initialization is used in which bean will be created
 * only when it is requested.
 *
 * @author Raphaël
 */
@ManagedBean(name = "localeBean")
@SessionScoped
public class LanguageBean implements Serializable
    {
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    public Locale getLocale()
        {
        return locale;
        }
    public String getLanguage()
        {
        return locale.getLanguage();
        }
    public void setLanguage(String language)
        {
        this.locale = new Locale(language);
        }
    }