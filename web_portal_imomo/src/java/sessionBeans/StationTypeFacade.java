/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.StationType;

/**
 *
 * @author Raphaël
 */
@Stateless
public class StationTypeFacade extends AbstractFacade<StationType>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public StationTypeFacade()
        {
        super(StationType.class);
        }
    
    }
