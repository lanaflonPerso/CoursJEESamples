/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Sms;

/**
 *
 * @author Raphaël
 */
@Stateless
public class SmsFacade extends AbstractFacade<Sms>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public SmsFacade()
        {
        super(Sms.class);
        }
    
    }
