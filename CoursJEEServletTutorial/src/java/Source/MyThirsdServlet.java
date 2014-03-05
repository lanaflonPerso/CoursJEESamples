/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nabil.ouerhani
 */
public class MyThirsdServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        try {
            out.println("This is my own Servlet (hand made modifed)");

            /*
             * request Headers
             */

            Enumeration ee = request.getHeaderNames();
            while (ee.hasMoreElements()) {
                String name = (String) ee.nextElement();
                out.println("<p> Header: " + name + " = " + request.getHeader(name) + "<p>");
            }

            /* 
             * request Parameters
             */
            ee = request.getParameterNames();
            while (ee.hasMoreElements()) {
                String name = (String) ee.nextElement();
                out.println("<p> Parameter: " + name + " = " + request.getParameter(name) + "<p>");
            }

            /*
             * Session handling
             */
            out.println("This section deals with Session handling <br>");
            HttpSession session = (HttpSession) request.getSession();

            String first = "John E", last = "Sampleman", tmp;

            session.setAttribute("Firstname", first);
            session.setAttribute("Lastname", last);

            out.println("<p> The entered session attributes are:<p>");

            ee = (Enumeration) session.getAttributeNames();
            while (ee.hasMoreElements()) {

                String att = (String) ee.nextElement();
                tmp = (String) session.getAttribute(att);
                out.println(att + "= " + tmp + "<br>");
            }

            /*
             * Utilisation de Cookies
             */

            Cookie cook = new Cookie("myTestCookies", "test cookie from netbean");

            cook.setMaxAge(10000); //Max Age in Sec
            response.addCookie(cook);
            out.println("<p>Cookie written <p>");

            /*
             * Dispactcher
             */
      //      RequestDispatcher dispatcher;
  //          dispatcher = request.getRequestDispatcher("/index.html");
    //        dispatcher.forward(request, response);
            
        } finally {
            out.close();
        }
    }

    public void doSet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
