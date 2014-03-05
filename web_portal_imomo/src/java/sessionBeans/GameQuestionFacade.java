/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import beans.PossibleResponseContainer;
import beans.QuestionContainer;
import entities.GamePossibleResponse;
import entities.GamePossibleResponseLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.GameQuestion;
import entities.GameQuestionLocal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;
import org.primefaces.event.CellEditEvent;

import org.primefaces.model.TreeNode;

/**
 *
 * @author Raphaël
 */
@Stateless
public class GameQuestionFacade extends AbstractFacade<GameQuestion> {

    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    private TreeNode root;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GameQuestionFacade() {
        super(GameQuestion.class);
    }

    //public Map <GameQuestion, List <GameQuestionLocal>> getAllQuestion() {
    public List<QuestionContainer> getAllQuestion() {
        /*
         Query q = em.createQuery("SELECT u.keyword FROM GameQuestion u INNER JOIN u.gamePossibleResponseList o WHERE o.questionID = :");
         q.setParameter("time", time);
         */
        //Query q = em.createNamedQuery("GameQuestion");
        //Map <GameQuestion, List <GameQuestionLocal>> mapQuestions = new HashMap<GameQuestion, List <GameQuestionLocal>>();

        List<QuestionContainer> listQuestionContainer = new LinkedList<QuestionContainer>();

        //all questions from GameQuestion
        Query q = em.createNamedQuery("GameQuestion.findAll");
        List<GameQuestion> list = q.getResultList();

        //for each GameQuestion, get all GameQuestionLocal
        for (GameQuestion gameQuestion : list) {
            Query queryGameQuestionLocal = em.createNamedQuery("GameQuestionLocal.findByQuestionID"); // call en existing query (from entity)
            queryGameQuestionLocal.setParameter("questionID", gameQuestion.getQuestionID()); // query key -> find key in query defined in entity 
            List<GameQuestionLocal> listGameQuestionLocal = queryGameQuestionLocal.getResultList();
            /*
             for(GameQuestionLocal gameQuestionLocal:listGameQuestionLocal){
             System.out.println(gameQuestionLocal.getText() + ", ");
             }
             */
            //mapQuestions.put(gameQuestion, listGameQuestionLocal);
            listQuestionContainer.add(new QuestionContainer(gameQuestion, listGameQuestionLocal));
        }

        //return mapQuestions;
        return listQuestionContainer;
    }

    public List<GamePossibleResponse> getallPossibleResponse() {
        Query q = em.createNamedQuery("GamePossibleResponse.");
        List<GamePossibleResponse> listGamePossibleResponse = q.getResultList();
        return listGamePossibleResponse;
    }

    /*test for modifying cells in datatable*/
//    public void onCellEdit(CellEditEvent event) {
//        Object oldValue = event.getOldValue();
//        Object newValue = event.getNewValue();
//
//        if (newValue != null && !newValue.equals(oldValue)) {
//            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//        }
//    }

    public List<GameQuestion> getQuestions() {
        Query q = em.createNamedQuery("GameQuestion.findAll");
        List<GameQuestion> list = q.getResultList();
        return list;
    }

    public List<GameQuestionLocal> getGameQuestionLocal(GameQuestion gameQuestion) {
        Query q = em.createQuery("select g from GameQuestionLocal g where g.gameQuestionLocalPK.questionID = :gameQuestionID");
        q.setParameter("gameQuestionID", gameQuestion.getQuestionID());
        return q.getResultList();
    }

    public List<GamePossibleResponse> getGamePossibleResponse(Integer idQuestion) {
        Query q = em.createQuery("select g from GamePossibleResponse g where g.questionID.questionID = :questionID");
        q.setParameter("questionID", idQuestion);
        return q.getResultList();
    }
    
    //Andreea, moved from GamePossibleResponseFacade.java
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
    
    //Andreea, not useful? (get all translations for a given question and a given answer
    public List<List<GamePossibleResponseLocal>> getGamePossibleResponseL(Integer gameQuestion, Integer gamePossibleResponseID) {
        Query queryGamePossibleResponse = em.createQuery("SELECT q FROM GamePossibleResponse q WHERE q.questionID.questionID = :questionID AND q.possibleResponseID = :responseID");
        queryGamePossibleResponse.setParameter("questionID", gameQuestion);
        queryGamePossibleResponse.setParameter("responseID", gamePossibleResponseID);        
        GamePossibleResponse gamePossibleResponse = (GamePossibleResponse) queryGamePossibleResponse.getSingleResult();
        
        List<List<GamePossibleResponseLocal>> listGamePossibleResponseLocal = new ArrayList<List<GamePossibleResponseLocal>>();
        Query queryGamePossibleResponseLocal = em.createNamedQuery("GamePossibleResponseLocal.findByPossibleResponseID");
        queryGamePossibleResponseLocal.setParameter("possibleResponseID", gamePossibleResponseID);
        listGamePossibleResponseLocal.add(queryGamePossibleResponseLocal.getResultList());
        
        return listGamePossibleResponseLocal;
    }    
    
    public GameQuestion getGameQuestion(String keyword)
        {
        Query q = em.createNamedQuery("GameQuestion.findByKeyword");
        q.setParameter("keyword", keyword);
        return (GameQuestion) q.getSingleResult();
        }
}
