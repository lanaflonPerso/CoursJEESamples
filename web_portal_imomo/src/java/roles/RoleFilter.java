/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roles;

import credential.CredentialBean;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raphaël
 */
public abstract class RoleFilter
    {
    /*-------------------------------------------------------------------------------------
     Attributs
     --------------------------------------------------------------------------------------*/
    /*-----------------------------------
     static
     ------------------------------------*/
    public static final String roleAdmin = "admin";
    public static final String roleGameUsers = "game_users";
    public static final String rolePbwb = "pbwb";
    public static final String roleResearch = "research";
    public static final String roleImomoTeam = "imomo_team";
    
    /*-------------------------------------------------------------------------------------
     Methods protected
     --------------------------------------------------------------------------------------*/
    protected void forRole(ServletRequest request, ServletResponse response, FilterChain chain, String requiredRole) throws IOException, ServletException
        {
        CredentialBean credentialBean;
        credentialBean = (CredentialBean) ((HttpServletRequest) request).getSession().getAttribute("credentialBean");

        if (credentialBean != null && credentialBean.isLoggedIn())
            {
            if (!credentialBean.hasRequiredRole(requiredRole))
                {
                String contextPath = ((HttpServletRequest) request).getContextPath();
                System.out.println(contextPath);
                ((HttpServletResponse) response).sendRedirect(contextPath + "/faces/index.xhtml?faces-redirect=true");
                }
            }

        chain.doFilter(request, response);
        }
    }
