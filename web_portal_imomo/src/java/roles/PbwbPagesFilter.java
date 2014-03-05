/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roles;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Raphaël
 */
public class PbwbPagesFilter extends RoleFilter implements Filter
    {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
        {
        //rien
        }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
        {
        forRole(request, response, chain, rolePbwb);
        }
    @Override
    public void destroy()
        {
        //rien
        }
    }
