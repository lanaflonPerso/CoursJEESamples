/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Datavalues;
import entities.Sites;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Raphaël
 */
@Stateless
public class DatavaluesFacade extends AbstractFacade<Datavalues>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public DatavaluesFacade()
        {
        super(Datavalues.class);
        }
    public List<Datavalues> getDatavalues(Sites site)
        {
        Query queryAllValues = em.createNamedQuery("Datavalues.findBySiteID");
        queryAllValues.setParameter("siteID", site);
        return queryAllValues.getResultList();
        }
    }
