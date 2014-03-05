package managedBeans;

import entities.Verticaldatumcv;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sessionBeans.VerticaldatumcvFacade;

@ManagedBean(name = "verticaldatumcvController")
@ViewScoped
public class VerticaldatumcvController extends AbstractController<Verticaldatumcv> implements Serializable {

    @EJB
    private VerticaldatumcvFacade ejbFacade;

    public VerticaldatumcvController() {
        super(Verticaldatumcv.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
