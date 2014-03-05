package managedBeans;

import entities.Culture;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "cultureController")
@SessionScoped
public class CultureController extends AbstractController<Culture> implements Serializable
    {
    @EJB
    private sessionBeans.CultureFacade ejbFacade;
    
    private List<String> allCultureCodes;
 
    public CultureController()
        {
        super(Culture.class);
        }
    @PostConstruct
    public void init()
        {
        super.setFacade(ejbFacade);
        }
   
    public List<String> getAllCultureCodes() {
        return allCultureCodes;
    }

    public void setAllCultureCodes(List<String> allCultureCodes) {
        this.allCultureCodes = allCultureCodes;
    }  

}
