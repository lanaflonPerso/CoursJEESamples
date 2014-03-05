/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Culture;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Raphaël
 */
@Stateless
public class CultureFacade extends AbstractFacade<Culture>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public CultureFacade()
        {
        super(Culture.class);
        }
    
    public List<String> getAllCultureCodes() {
        //all cultures from Culture
        Query q = em.createQuery("SELECT u.code FROM Culture u");
        List<String> listCultureCodes = q.getResultList();

        return listCultureCodes;
    }
    }
