/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.GameNewsLocal;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Andreea Mihet
 */
@Stateless
public class GameNewsLocalFacade extends AbstractFacade<GameNewsLocal>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public GameNewsLocalFacade()
        {
        super(GameNewsLocal.class);
        }
        
    public List<GameNewsLocal> getallNewsLocal(Integer newsID){
        try{
            Query queryGetAllNewsLocal = em.createNamedQuery("GameNewsLocal.findByNewsID");
            queryGetAllNewsLocal.setParameter("newsID", newsID);
            return (List<GameNewsLocal>) queryGetAllNewsLocal.getResultList();           
        }
        catch(Exception e){
            System.out.println(e.toString());        
        }
        return null;
    }
    
    public GameNewsLocal getGameNewsLocalTranslation(Integer newsID, String code) {
        Query q = em.createQuery("SELECT q FROM GameNewsLocal q WHERE q.gameNewsLocalPK.newsID = :newsID AND q.gameNewsLocalPK.cultureCode = :code");
        q.setParameter("newsID", newsID);
        q.setParameter("code", code);
        GameNewsLocal g = (GameNewsLocal) q.getSingleResult();        
        return g;
    }
    
    public int deleteTranslations(Integer newsID){
        Query q = em.createQuery("DELETE FROM GameNewsLocal u  WHERE u.gameNewsLocalPK.newsID = :newsID");
        q.setParameter("newsID", newsID);
        return q.executeUpdate();
    }
}
