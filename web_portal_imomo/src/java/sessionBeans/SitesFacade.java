/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entities.Sites;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Raphaël
 */
@Stateless
public class SitesFacade extends AbstractFacade<Sites>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public SitesFacade()
        {
        super(Sites.class);
        }
    public Sites getSite(String siteName)
        {
        try
            {
            Query querySite = em.createNamedQuery("Sites.findBySiteName");
            querySite.setParameter("siteName", siteName);
            return (Sites) querySite.getSingleResult();
            }
        catch (Exception e)
            {
            return null;
            }
        }
    }
