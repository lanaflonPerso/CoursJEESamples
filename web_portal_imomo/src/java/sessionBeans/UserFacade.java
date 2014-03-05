/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entities.User;
import entities.GameUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Raphaël
 */
@Stateless
public class UserFacade extends AbstractFacade<User>
    {
    @PersistenceContext(unitName = "web_portal_imomoPU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager()
        {
        return em;
        }
    public UserFacade()
        {
        super(User.class);
        }
    /**
     *
     * This function lets you know if a username is already in the BDD.
     *
     *
     *
     * @param username
     *
     * @return
     *
     */
    public boolean exists(String username)
        {
        Query query = em.createNamedQuery("User.findByNickname");
        query.setParameter("nickname", username);
        return this.existsOneResult(query);
        }
    public boolean exists(String username, String password)
        {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.password = :password AND u.nickname = :nickname");
        query.setParameter("nickname", username);
        query.setParameter("password", password);
        return this.existsOneResult(query);
        }
    public boolean isActived(String username)
        {
        Query q = em.createQuery("select u FROM User u WHERE u.nickname = :username");
        q.setParameter("username", username);
        User user = (User) q.getSingleResult();
//        System.out.println("activated : " + user.getActivated());
        return user.getActivated();
        }
    public boolean hasRequiredRole(String requiredRole, String username)
        {
        em.flush();
        Query query = em.createQuery("SELECT r.role FROM UserRole r INNER JOIN r.userID u WHERE u.nickname = :nickname AND r.role = :role");
        query.setParameter("nickname", username);
        query.setParameter("role", requiredRole);
        try
            {
            query.getSingleResult();
            return true;
            }
        catch (Exception e)
            {
            return false;
            }
        }
    public User getUser(String username)
        {
        Query q = em.createNamedQuery("User.findByNickname");
        q.setParameter("nickname", username);
        return (User) q.getSingleResult();
        }
    
    public Short getGameUserProfLevel(Integer userID){
        Query query = em.createQuery("SELECT q.profLevel FROM GameUser q WHERE q.userID = :userID");
        query.setParameter("userID", userID);
        Short x=0;
        try{
            GameUser game_user = (GameUser) query.getSingleResult();
            x=game_user.getProfLevel();
        }
        catch (Exception e){
            x=0;
        }
        return x;
    }
    }
