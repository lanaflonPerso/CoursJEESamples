/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entities.Role;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Raphaël
 */
@Stateless
public class RoleFacade extends AbstractFacade<Role>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public RoleFacade()
        {
        super(Role.class);
        }
    public List<Role> getRoles()
        {
        Query q = em.createQuery("SELECT r FROM Role r WHERE r.name <> 'admin'");
        return q.getResultList();
        }
    public Role getRole(String name)
        {
        Query q = em.createNamedQuery("Role.findByName");
        q.setParameter("name", name);
        return (Role) q.getSingleResult();
        }
    }
