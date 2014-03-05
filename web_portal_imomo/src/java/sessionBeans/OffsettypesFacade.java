/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Offsettypes;

/**
 *
 * @author Raphaël
 */
@Stateless
public class OffsettypesFacade extends AbstractFacade<Offsettypes>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public OffsettypesFacade()
        {
        super(Offsettypes.class);
        }
    
    }
