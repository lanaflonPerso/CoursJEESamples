/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import beans.NewsContainer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.GameNews;
import entities.GameNewsLocal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

/**
 *
 * @author Andreea Mihet
 */
@Stateless
public class GameNewsFacade extends AbstractFacade<GameNews> {

    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GameNewsFacade() {
        super(GameNews.class);
    }
    
    public List<NewsContainer> getAllNews() {
        List<NewsContainer> listNewsContainer = new LinkedList<NewsContainer>();

        Query q = em.createNamedQuery("GameNews.findAll");
        List<GameNews> list = q.getResultList();
        
        for (GameNews gameNews : list) {
            Query queryGameNewsLocal = em.createNamedQuery("GameNewsLocal.findByNewsID"); // call en existing query (from entity)
            queryGameNewsLocal.setParameter("newsID", gameNews.getNewsID()); // query key -> find key in query defined in entity 
            List<GameNewsLocal> listGameNewsLocal = queryGameNewsLocal.getResultList();
            listNewsContainer.add(new NewsContainer(gameNews, listGameNewsLocal));
        }

        //return mapQuestions;
        return listNewsContainer;
    }

//    public List<GameQuestionLocal> getGameQuestionLocal(GameQuestion gameQuestion) {
//        Query q = em.createQuery("select g from GameQuestionLocal g where g.gameQuestionLocalPK.questionID = :gameQuestionID");
//        q.setParameter("gameQuestionID", gameQuestion.getQuestionID());
//        return q.getResultList();
//    }

    
//    //Andreea, moved from GamePossibleResponseFacade.java
//    public List<List<GamePossibleResponseLocal>> getGamePossibleResponseLocal(Integer gameQuestion) {
//        Query queryGamePossibleResponse = em.createQuery("SELECT q FROM GamePossibleResponse q WHERE q.questionID.questionID = :questionID");
//        queryGamePossibleResponse.setParameter("questionID", gameQuestion);
//        List<GamePossibleResponse> listGamePossibleResponse = queryGamePossibleResponse.getResultList();
//        List<List<GamePossibleResponseLocal>> listGamePossibleResponseLocal = new ArrayList<List<GamePossibleResponseLocal>>();
//        for (GamePossibleResponse gamePossibleResponse : listGamePossibleResponse) {
//            Query queryGamePossibleResponseLocal = em.createNamedQuery("GamePossibleResponseLocal.findByPossibleResponseID");
//            queryGamePossibleResponseLocal.setParameter("possibleResponseID", gamePossibleResponse.getPossibleResponseID());
//            listGamePossibleResponseLocal.add(queryGamePossibleResponseLocal.getResultList());
//        }
//        return listGamePossibleResponseLocal;
//    }
//    
//    //Andreea, not useful? (get all translations for a given question and a given answer
//    public List<List<GamePossibleResponseLocal>> getGamePossibleResponseL(Integer gameQuestion, Integer gamePossibleResponseID) {
//        Query queryGamePossibleResponse = em.createQuery("SELECT q FROM GamePossibleResponse q WHERE q.questionID.questionID = :questionID AND q.possibleResponseID = :responseID");
//        queryGamePossibleResponse.setParameter("questionID", gameQuestion);
//        queryGamePossibleResponse.setParameter("responseID", gamePossibleResponseID);        
//        GamePossibleResponse gamePossibleResponse = (GamePossibleResponse) queryGamePossibleResponse.getSingleResult();
//        
//        List<List<GamePossibleResponseLocal>> listGamePossibleResponseLocal = new ArrayList<List<GamePossibleResponseLocal>>();
//        Query queryGamePossibleResponseLocal = em.createNamedQuery("GamePossibleResponseLocal.findByPossibleResponseID");
//        queryGamePossibleResponseLocal.setParameter("possibleResponseID", gamePossibleResponseID);
//        listGamePossibleResponseLocal.add(queryGamePossibleResponseLocal.getResultList());
//        
//        return listGamePossibleResponseLocal;
//    }    
//    
//    public GameQuestion getGameQuestion(String keyword)
//        {
//        Query q = em.createNamedQuery("GameQuestion.findByKeyword");
//        q.setParameter("keyword", keyword);
//        return (GameQuestion) q.getSingleResult();
//        }
}
