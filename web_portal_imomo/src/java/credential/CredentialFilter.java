/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package credential;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raphaël
 */
public class CredentialFilter implements Filter
    {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
        {
        //rien
        }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
        {
        CredentialBean credentialBean = (CredentialBean) ((HttpServletRequest) request).getSession().getAttribute("credentialBean");

        if (credentialBean == null || !credentialBean.isLoggedIn())
            {
            String contextPath = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse) response).sendRedirect(contextPath + "/faces/index.xhtml?faces-redirect=true");
            }
        chain.doFilter(request, response);
        }
    @Override
    public void destroy()
        {
        //rien
        }
    }
