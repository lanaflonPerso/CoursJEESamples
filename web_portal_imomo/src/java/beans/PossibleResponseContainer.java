/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.GamePossibleResponse;
import entities.GamePossibleResponseLocal;
import entities.GameQuestion;
import entities.GameQuestionLocal;
import java.util.List;

/**
 * @author andreea.mihet
 */
public class PossibleResponseContainer {

    private GamePossibleResponse gamePossibleResponse;
    private List<GamePossibleResponseLocal> listGamePossibleResponseLocal;
    private List<GamePossibleResponse> listGamePossibleResponses;
    private List<GameQuestionLocal> listGameQuestionLocal;
    private GameQuestion gameQuestion;

    public PossibleResponseContainer(List<GamePossibleResponse> listGamePossibleResponses, List<GamePossibleResponseLocal> listGamePossibleResponseLocals) {
        this.listGamePossibleResponses = listGamePossibleResponses;
        this.listGamePossibleResponseLocal = listGamePossibleResponseLocals;
    }

    public PossibleResponseContainer(GameQuestion gameQuestion) {
        this.gameQuestion = gameQuestion;        
    }
    
    public PossibleResponseContainer(GameQuestion gameQuestion, List<GameQuestionLocal> listGameQuestionLocal) {
        this.gameQuestion = gameQuestion;
        this.listGameQuestionLocal = listGameQuestionLocal;
    }

    public PossibleResponseContainer(List<GameQuestionLocal> listGameQuestionLocal, GamePossibleResponse gamePossibleResponse, List<GamePossibleResponseLocal> listGamePossibleResponseLocal) {
        this.gamePossibleResponse = gamePossibleResponse;
        this.listGamePossibleResponseLocal = listGamePossibleResponseLocal;
        this.listGameQuestionLocal = listGameQuestionLocal;
    }

    public List<GamePossibleResponseLocal> getListGamePossibleResponseLocal() {
        return listGamePossibleResponseLocal;
    }

    public List<GamePossibleResponse> getListGamePossibleResponses() {
        return listGamePossibleResponses;
    }

    public List<GameQuestionLocal> getListGameQuestionLocal() {
        return listGameQuestionLocal;
    }

    public GameQuestion getGameQuestion() {
        return gameQuestion;
    }

    public GamePossibleResponse getGamePossibleResponse() {
        return gamePossibleResponse;
    }

    public List<GamePossibleResponseLocal> getList() {
        return listGamePossibleResponseLocal;
    }
}
