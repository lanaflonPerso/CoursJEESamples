package managedBeans;

import entities.Role;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "roleController")
@SessionScoped
public class RoleController extends AbstractController<Role> implements Serializable
    {
    @EJB
    private sessionBeans.RoleFacade ejbFacade;
    public RoleController()
        {
        super(Role.class);
        }
    @PostConstruct
    public void init()
        {
        super.setFacade(ejbFacade);
        }
    }
