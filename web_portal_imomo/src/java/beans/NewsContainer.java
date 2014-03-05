/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.GameNews;
import entities.GameNewsLocal;
import java.util.List;

/**
 *
 * @author Andreea Mihet
 */
public class NewsContainer {
    private GameNews gameNews; 
    private List <GameNewsLocal> list;

    public GameNews getGameNews() {
        return gameNews;
    }

    public List<GameNewsLocal> getList() {
        return list;
    }
    
    public NewsContainer(GameNews gameNews, List <GameNewsLocal> list) {
        this.gameNews = gameNews;
        this.list = list;        
    }
    
}
