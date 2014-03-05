/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.GameQuestionLocal;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Raphaël
 */
@Stateless
public class GameQuestionLocalFacade extends AbstractFacade<GameQuestionLocal>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public GameQuestionLocalFacade()
        {
        super(GameQuestionLocal.class);
        }

    public GameQuestionLocal getGameQuestionLocalTranslation(Integer questionID, String code) {
        Query q = em.createQuery("SELECT q FROM GameQuestionLocal q WHERE q.gameQuestionLocalPK.questionID = :questionID AND q.gameQuestionLocalPK.cultureCode = :code");
        q.setParameter("questionID", questionID);
        q.setParameter("code", code);
        GameQuestionLocal g = (GameQuestionLocal) q.getSingleResult();        
        return g;
    }
    
    public int deleteTranslations(Integer questionID){
        Query q = em.createQuery("DELETE FROM GameQuestionLocal u  WHERE u.gameQuestionLocalPK.questionID = :questionID");
        q.setParameter("questionID", questionID);
        return q.executeUpdate();
    }
    
    }
