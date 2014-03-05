package managedBeans;

import entities.Spatialreferences;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sessionBeans.SpatialreferencesFacade;

@ManagedBean(name = "spatialreferencesController")
@ViewScoped
public class SpatialreferencesController extends AbstractController<Spatialreferences> implements Serializable {

    @EJB
    private SpatialreferencesFacade ejbFacade;

    public SpatialreferencesController() {
        super(Spatialreferences.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
