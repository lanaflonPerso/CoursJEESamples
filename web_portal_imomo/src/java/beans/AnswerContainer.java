/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.GamePossibleResponse;
import entities.GamePossibleResponseLocal;
import java.util.List;

/**
 *
 * @author andreea.mihet
 */
public class AnswerContainer {
    private GamePossibleResponse gamePossibleResponse; 
    private List <GamePossibleResponseLocal> listPossibleResponseLocals;

    public GamePossibleResponse getGamePossibleResponse() {
        return gamePossibleResponse;
    }

    public List<GamePossibleResponseLocal> getListPossibleResponseLocals() {
        return listPossibleResponseLocals;
    }
    
    public AnswerContainer(GamePossibleResponse gamePossibleResponse, List <GamePossibleResponseLocal> listPossibleResponseLocals) {
        this.gamePossibleResponse = gamePossibleResponse;
        this.listPossibleResponseLocals = listPossibleResponseLocals;
        
    }
    
}
