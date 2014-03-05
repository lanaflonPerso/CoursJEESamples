/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Countrylanguage;
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
public class CountrylanguageFacade extends AbstractFacade<Countrylanguage> {
    @PersistenceContext(unitName = "CoursJEEsamplesJSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CountrylanguageFacade() {
        super(Countrylanguage.class);
    }
    
    //construire une requête Custom!
    public List<Countrylanguage> getLanguages(String code)
        {
        Query queryAllValues = em.createNamedQuery("Countrylanguage.findByCountryCode");
        queryAllValues.setParameter("countryCode", code);
        return queryAllValues.getResultList();
        }
    
    
}
