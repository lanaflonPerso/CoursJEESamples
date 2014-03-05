/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entities.Spatialreferences;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Raphaël
 */
@Stateless
public class SpatialreferencesFacade extends AbstractFacade<Spatialreferences>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public SpatialreferencesFacade()
        {
        super(Spatialreferences.class);
        }
    
    }
