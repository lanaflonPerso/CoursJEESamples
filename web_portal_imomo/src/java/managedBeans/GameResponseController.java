package managedBeans;

import entities.GameResponse;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "gameResponseController")
@SessionScoped
public class GameResponseController extends AbstractController<GameResponse> implements Serializable
    {
    @EJB
    private sessionBeans.GameResponseFacade ejbFacade;
    public GameResponseController()
        {
        super(GameResponse.class);
        }
    @PostConstruct
    public void init()
        {
        super.setFacade(ejbFacade);
        }
    }
