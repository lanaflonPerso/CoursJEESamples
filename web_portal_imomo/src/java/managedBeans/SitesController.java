package managedBeans;

import entities.Sites;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sessionBeans.SitesFacade;

@ManagedBean(name = "sitesController")
@ViewScoped
public class SitesController extends AbstractController<Sites> implements Serializable {

    @EJB
    private SitesFacade ejbFacade;

    public SitesController() {
        super(Sites.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
