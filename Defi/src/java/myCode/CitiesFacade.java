/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myCode;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nabil.ouerhani
 */
@Stateless
public class CitiesFacade extends AbstractFacade<Cities> {
    @PersistenceContext(unitName = "DefiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitiesFacade() {
        super(Cities.class);
    }
    
}
