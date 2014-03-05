/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nabil.ouerhani
 */
@Stateless
public class CityFacade extends AbstractFacade<City> {
    @PersistenceContext(unitName = "WebApplication1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CityFacade() {
        super(City.class);
    }
    
}
