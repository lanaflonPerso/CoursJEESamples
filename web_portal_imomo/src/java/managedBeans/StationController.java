package managedBeans;

import entities.Station;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sessionBeans.StationFacade;

@ManagedBean(name = "stationController")
@ViewScoped
public class StationController extends AbstractController<Station> implements Serializable {

    @EJB
    private StationFacade ejbFacade;

    public StationController() {
        super(Station.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
