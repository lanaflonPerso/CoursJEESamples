/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.security.MessageDigest;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Raphaël
 */
public class Tools
    {
    /*-------------------------------------------------------------------------------------
     Methods public
     --------------------------------------------------------------------------------------*/
    /*-----------------------------------
     static
     ------------------------------------*/
    /**
     * This function return the hash SHA-512 of the password given in parameter. If the function cannot hash the password, the original password is returned.
     *
     * @return
     */
    public static String hashPassword(String password)
        {
        StringBuilder currentPassword = new StringBuilder(password);
        try
            {
            byte[] tabBytesPassword = currentPassword.toString().getBytes("UTF-8");
            MessageDigest algorithm = MessageDigest.getInstance("SHA-512");
            algorithm.update(tabBytesPassword);
            byte messageDigest[] = algorithm.digest();

            //convert the byte to hex format
            StringBuilder strPasswordHashed = new StringBuilder();
            for (int i = 0; i < messageDigest.length; i++)
                {
                strPasswordHashed.append(Integer.toString((messageDigest[i] & 0xff) + 0x100, 16).substring(1));
                }
            currentPassword.delete(0, currentPassword.length());
            currentPassword.append(strPasswordHashed.toString());
            }
        catch (Exception ex)
            {
            System.out.println(ex.toString());
            return password;
            }
        return currentPassword.toString();
        }
    public static String getCurrentPageAdress()
        {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest servletRequest = (HttpServletRequest) ctx.getExternalContext().getRequest();
        // returns something like "/myapplication/home.faces"
        return servletRequest.getRequestURI();
        }
    }
