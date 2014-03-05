/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import beans.PossibleResponseContainer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.GamePossibleResponse;
import entities.GamePossibleResponseLocal;
import entities.GameQuestion;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Raphaël
 */
@Stateless
public class GamePossibleResponseFacade extends AbstractFacade<GamePossibleResponse> {

    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GamePossibleResponseFacade() {
        super(GamePossibleResponse.class);
    }

    public List<PossibleResponseContainer> getAllPossibleResponse() {
        List<PossibleResponseContainer> listPossibleResponseContainer = new LinkedList<PossibleResponseContainer>();

        //all questions from GameQuestion
        Query q = em.createNamedQuery("GamePossibleResponse.findAll");
        List<GamePossibleResponse> list = q.getResultList();

        //for each GameQuestion, get all GameQuestionLocal
        for (GamePossibleResponse gamePossibleResponse : list) {
            Query queryGamePossibleResponseLocal = em.createNamedQuery("GamePossibleResponseLocal.findByPossibleResponseID"); // call en existing query (from entity)
            queryGamePossibleResponseLocal.setParameter("possibleResponseID", gamePossibleResponse.getPossibleResponseID()); // query key -> find key in query defined in entity 
            List<GamePossibleResponseLocal> listGamePossibleResponseLocal = queryGamePossibleResponseLocal.getResultList();
            /*
             for(GameQuestionLocal gameQuestionLocal:listGameQuestionLocal){
             System.out.println(gameQuestionLocal.getText() + ", ");
             }
             */
            listPossibleResponseContainer.add(new PossibleResponseContainer(null,gamePossibleResponse, listGamePossibleResponseLocal));
        }

        return listPossibleResponseContainer;
    }

    public List<List<GamePossibleResponseLocal>> getGamePossibleResponseLocal(Integer gameQuestion) {
        Query queryGamePossibleResponse = em.createQuery("SELECT q FROM GamePossibleResponse q WHERE q.questionID.questionID = :questionID");
        queryGamePossibleResponse.setParameter("questionID", gameQuestion);
        List<GamePossibleResponse> listGamePossibleResponse = queryGamePossibleResponse.getResultList();
        List<List<GamePossibleResponseLocal>> listGamePossibleResponseLocal = new ArrayList<List<GamePossibleResponseLocal>>();
        for (GamePossibleResponse gamePossibleResponse : listGamePossibleResponse) {
            Query queryGamePossibleResponseLocal = em.createNamedQuery("GamePossibleResponseLocal.findByPossibleResponseID");
            queryGamePossibleResponseLocal.setParameter("possibleResponseID", gamePossibleResponse.getPossibleResponseID());
            listGamePossibleResponseLocal.add(queryGamePossibleResponseLocal.getResultList());
        }

        return listGamePossibleResponseLocal;
    }
    
    public Integer getNumberOfUserAnswers(Integer possibleResponseID) {
        Query q = em.createQuery("SELECT q FROM GameResponse q WHERE q.possibleResponseID.possibleResponseID = :possibleResponseID");
        q.setParameter("possibleResponseID", possibleResponseID);                
        return q.getResultList().size();
    }
}
