/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Station;

/**
 *
 * @author Raphaël
 */
@Stateless
public class StationFacade extends AbstractFacade<Station>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public StationFacade()
        {
        super(Station.class);
        }
    
    }
