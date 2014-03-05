/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Variablenamecv;

/**
 *
 * @author Raphaël
 */
@Stateless
public class VariablenamecvFacade extends AbstractFacade<Variablenamecv>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public VariablenamecvFacade()
        {
        super(Variablenamecv.class);
        }
    
    }
