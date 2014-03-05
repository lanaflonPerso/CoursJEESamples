package managedBeans;

import entities.Variables;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "variablesController")
@SessionScoped
public class VariablesController extends AbstractController<Variables> implements Serializable
    {
    @EJB
    private sessionBeans.VariablesFacade ejbFacade;
    private List<Variables> crowdsourcingVariables;
    private Variables variable;

    public VariablesController()
        {
            super(Variables.class);
        }
    @PostConstruct
    public void init()
        {
        super.setFacade(ejbFacade);
        } 

    public List<Variables> getCrowdsourcingVariables() {
        return ejbFacade.getCrowdsourcingVariables();
    }
    
    public void setCrowdsourcingVariables(List<Variables> crowdsourcingVariables) {
        this.crowdsourcingVariables = crowdsourcingVariables;
    }
    
    public Variables getVariable(Integer variableID){
         return ejbFacade.getVariable(variableID);
    }
    
    public void setVariable(Variables variable){
        this.variable = variable;
    }
    
    
    }

