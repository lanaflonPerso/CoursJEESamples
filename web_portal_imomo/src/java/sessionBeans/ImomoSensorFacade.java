/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.ImomoSensor;

/**
 *
 * @author Raphaël
 */
@Stateless
public class ImomoSensorFacade extends AbstractFacade<ImomoSensor>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public ImomoSensorFacade()
        {
        super(ImomoSensor.class);
        }
    
    }
