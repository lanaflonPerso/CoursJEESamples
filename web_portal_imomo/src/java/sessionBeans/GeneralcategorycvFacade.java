/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Generalcategorycv;

/**
 *
 * @author Raphaël
 */
@Stateless
public class GeneralcategorycvFacade extends AbstractFacade<Generalcategorycv>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public GeneralcategorycvFacade()
        {
        super(Generalcategorycv.class);
        }
    
    }
