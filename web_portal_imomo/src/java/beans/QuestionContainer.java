/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.GameQuestion;
import entities.GameQuestionLocal;
import java.util.List;

/**
 *
 * @author andreea.mihet
 */
public class QuestionContainer {
    private GameQuestion gameQuestion; 
    private List <GameQuestionLocal> list;

    public GameQuestion getGameQuestion() {
        return gameQuestion;
    }

    public List<GameQuestionLocal> getList() {
        return list;
    }
    
    public QuestionContainer(GameQuestion gameQuestion, List <GameQuestionLocal> list) {
        this.gameQuestion = gameQuestion;
        this.list = list;
        
    }
    
}
