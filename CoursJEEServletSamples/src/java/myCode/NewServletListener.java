/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myCode;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author nabil.ouerhani
 */
public class NewServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
       
        System.out.println("--------Context created here ----- !!!!");
   
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("----------Context desproyed here -----!!!!");

    }
}
