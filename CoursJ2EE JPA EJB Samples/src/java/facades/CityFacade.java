/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.City;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author nabil.ouerhani
 */
@Stateless
public class CityFacade extends AbstractFacade<City> {

    @PersistenceContext(unitName = "CoursJ2EE_JPA_EJB_SamplesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CityFacade() {
        super(City.class);
    }

    // add a new method
    /**
     *
     * @param s
     * @return
     */
    public List<City> findCityAlpha(String s) {
Query queryAllValues = em.createNamedQuery("City.findByStartName");

  queryAllValues.setParameter("str", s);
  return queryAllValues.getResultList();
    }
}
