/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.GameResponse;

/**
 *
 * @author Raphaël
 */
@Stateless
public class GameResponseFacade extends AbstractFacade<GameResponse>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public GameResponseFacade()
        {
        super(GameResponse.class);
        }
    
    }
