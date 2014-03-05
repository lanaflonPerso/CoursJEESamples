/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.RequestScoped;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nabil.ouerhani
 */
@Named(value = "country")
@SessionScoped
public class CountryBean implements Serializable{
 
	//private static final long serialVersionUID = 1L;
 	private static Map<String,String> countries;
 	private String localeCode = "en"; //default value 
        
        private UIInput myText = null;
        
 	static{
		countries = new LinkedHashMap<String,String>();
		countries.put("United Kingdom", "en"); //label, value
		countries.put("French", "fr");
		countries.put("German", "de");
		countries.put("China", "zh_CN");
	}
 	public void countryLocaleCodeChanged(ValueChangeEvent e){
		//assign new value to localeCode
		localeCode = e.getNewValue().toString();
                 //localeCode = "TN";
                System.out.println("Event Listner called"+ " localCode = "+localeCode);
                myText.setValue(localeCode);
                
           
          //  setLocaleCode("TEST");
                
                invalidateCache();
 	}
 	public Map<String,String> getCountryInMap() {
		return this.countries;
	}
 	public String getLocaleCode() {
		return localeCode;
	}
 	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

    public UIInput getMyText() {
        return myText;
    }

    public void setMyText(UIInput myText) {
        this.myText = myText;
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
