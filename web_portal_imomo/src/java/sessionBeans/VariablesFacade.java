/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entities.Valuetypecv;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Variables;
import java.io.Console;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Raphaël
 */
@Stateless
public class VariablesFacade extends AbstractFacade<Variables>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public VariablesFacade()
        {
        super(Variables.class);
        }
    
    public List<Variables> getCrowdsourcingVariables() {
        Query q1 = em.createQuery("SELECT q1 FROM Valuetypecv q1 WHERE q1.term = :term");
        q1.setParameter("term", "Crowdsourcing value");        
        Valuetypecv crowdVar = (Valuetypecv) q1.getSingleResult();        
        Query q2 = em.createQuery("SELECT q2 FROM Variables q2 WHERE q2.valueType = :valType");
        q2.setParameter("valType", crowdVar);
        
        List<Variables> list = q2.getResultList();
        return list;
    }
    
    public Variables getVariable(Integer variableID){
        Query q1 = em.createQuery("SELECT q1 FROM Variables q1 WHERE q1.variableID = :variableID");
        q1.setParameter("variableID", variableID); 
        Variables variable = (Variables) q1.getSingleResult();
        return variable;
    }
    }
