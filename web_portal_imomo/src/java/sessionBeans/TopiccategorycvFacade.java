/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Topiccategorycv;

/**
 *
 * @author Raphaël
 */
@Stateless
public class TopiccategorycvFacade extends AbstractFacade<Topiccategorycv>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public TopiccategorycvFacade()
        {
        super(Topiccategorycv.class);
        }
    
    }
