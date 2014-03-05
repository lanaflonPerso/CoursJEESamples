package managedBeans;

import entities.GameUser;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "gameUserController")
@SessionScoped
public class GameUserController extends AbstractController<GameUser> implements Serializable
    {
    @EJB
    private sessionBeans.GameUserFacade ejbFacade;
    public GameUserController()
        {
        super(GameUser.class);
        }
    @PostConstruct
    public void init()
        {
        super.setFacade(ejbFacade);
        }
    }
