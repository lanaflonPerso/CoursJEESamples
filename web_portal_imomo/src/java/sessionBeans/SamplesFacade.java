/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Samples;

/**
 *
 * @author Raphaël
 */
@Stateless
public class SamplesFacade extends AbstractFacade<Samples>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public SamplesFacade()
        {
        super(Samples.class);
        }
    
    }
