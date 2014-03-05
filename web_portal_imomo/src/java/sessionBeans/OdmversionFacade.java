/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Odmversion;

/**
 *
 * @author Raphaël
 */
@Stateless
public class OdmversionFacade extends AbstractFacade<Odmversion>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public OdmversionFacade()
        {
        super(Odmversion.class);
        }
    
    }
