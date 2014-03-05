/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;



import java.util.Random;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;


@Named(value = "pileOuFace")
@SessionScoped

/**
 *
 * @author nabil.ouerhani
 */
public class PileOuFace implements Serializable{
    
    private String pf;;

    /**
     * Creates a new instance of PileOuFace
     */
    public String PileOuFace() {
        
        invalidateCache();
        
        Random random = new Random();
              
        int i = random.nextInt(2);
        
        if(i==0) {
            pf = "Pile";
            return ("pile");
        }
        else {
            pf = "Face";
            return ("face");
        }
    }

    public void PileOuFaceII() {
        
        invalidateCache();
        
        Random random = new Random();
              
        int i = random.nextInt(2);
        
        if(i==0) {
            pf = "Pile";
        }
        else {
            pf = "Face";
        }
    }
    
    public String getPf() {
        return pf;
    }

    public void setPf(String pf) {
        this.pf = pf;
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
