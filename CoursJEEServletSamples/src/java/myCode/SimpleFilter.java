/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myCode;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author nabil.ouerhani
 */
public class SimpleFilter implements Filter {

    public SimpleFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        PrintWriter out;
        out = response.getWriter();
        out.println("This text has been added in the filter before processing");
        chain.doFilter(request, response);
        out.println("This text has been added in the filter After Processing of request");
    }

    @Override
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    @Override
    public void init(FilterConfig filterConfig) {
    }
}
