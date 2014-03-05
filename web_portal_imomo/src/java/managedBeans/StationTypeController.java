package managedBeans;

import entities.StationType;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sessionBeans.StationTypeFacade;

@ManagedBean(name = "stationTypeController")
@ViewScoped
public class StationTypeController extends AbstractController<StationType> implements Serializable {

    @EJB
    private StationTypeFacade ejbFacade;

    public StationTypeController() {
        super(StationType.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
