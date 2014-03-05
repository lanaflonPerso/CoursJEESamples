/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entities.User;
import entities.UserRole;
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
public class UserRoleFacade extends AbstractFacade<UserRole>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public UserRoleFacade()
        {
        super(UserRole.class);
        }
    public int deleteRoles(User user)
        {
        Query q = em.createQuery("DELETE FROM UserRole u  WHERE u.userID = :user");
        q.setParameter("user", user);
        return q.executeUpdate();
        }
    public List<UserRole> getUserRoleList(User user)
        {
        Query q = em.createQuery("select u FROM UserRole u WHERE u.userID = :userid");
        q.setParameter("userid", user);
        return q.getResultList();
        }
    }
