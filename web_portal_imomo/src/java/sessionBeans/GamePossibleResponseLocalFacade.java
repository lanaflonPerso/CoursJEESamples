/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.GamePossibleResponseLocal;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Raphaël
 */
@Stateless
public class GamePossibleResponseLocalFacade extends AbstractFacade<GamePossibleResponseLocal>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public GamePossibleResponseLocalFacade()
        {
        super(GamePossibleResponseLocal.class);
        }
    
    //todo : query 
    public List<GamePossibleResponseLocal> getallPossibleResponseLocal(Integer possibleResponseID){
        try{
            Query queryGetAllPossibleResponseLocal = em.createNamedQuery("GamePossibleResponseLocal.findByPossibleResponseID");
            queryGetAllPossibleResponseLocal.setParameter("possibleResponseID", possibleResponseID);
            return (List<GamePossibleResponseLocal>) queryGetAllPossibleResponseLocal.getResultList();           
        }
        catch(Exception e){
            System.out.println(e.toString());        
        }
        return null;
    }
    
    public GamePossibleResponseLocal getGamePossibleResponseLocalTranslation(Integer possibleResponseID, String code) {
        Query q = em.createQuery("SELECT q FROM GamePossibleResponseLocal q WHERE q.gamePossibleResponseLocalPK.possibleResponseID = :possibleResponseID AND q.gamePossibleResponseLocalPK.cultureCode = :code");
        q.setParameter("possibleResponseID", possibleResponseID);
        q.setParameter("code", code);
        GamePossibleResponseLocal g = (GamePossibleResponseLocal) q.getSingleResult();        
        return g;
    }
    
    public int deleteTranslations(Integer possibleResponseID){
        Query q = em.createQuery("DELETE FROM GamePossibleResponseLocal u  WHERE u.gamePossibleResponseLocalPK.possibleResponseID = :possibleResponseID");
        q.setParameter("possibleResponseID", possibleResponseID);
        return q.executeUpdate();
    }
}
