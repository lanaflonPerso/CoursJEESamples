/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Raphaël
 */
@ManagedBean(name = "constantBean")
@ApplicationScoped
public class Constant
    {
    /*-------------------------------------------------------------------------------------
     Attributs
     --------------------------------------------------------------------------------------*/
    private int minSizePassword;
    private int minSizeUsername;
    private int maxSizeNormalInput;
    private int maxSizePassword;
    /*-----------------------------------
     static
     ------------------------------------*/
    public static final int MIN_SIZE_PASSWORD = 6;
    public static final int MIN_SIZE_USERNAME = 4;
    public static final int MAX_SIZE_NORMAL_INPUT = 100;
    public static final int MAX_SIZE_PASSWORD = 130;
    /*-------------------------------------------------------------------------------------
     Methods public
     --------------------------------------------------------------------------------------*/
    @PostConstruct
    public void init()
        {
        minSizeUsername = MIN_SIZE_USERNAME;
        minSizePassword = MIN_SIZE_PASSWORD;
        maxSizeNormalInput = MAX_SIZE_NORMAL_INPUT;
        maxSizePassword = MAX_SIZE_PASSWORD;
        }
    public int getMaxSizePassword()
        {
        return maxSizePassword;
        }
    public int getMinSizePassword()
        {
        return minSizePassword;
        }
    public int getMinSizeUsername()
        {
        return minSizeUsername;
        }
    public int getMaxSizeNormalInput()
        {
        return maxSizeNormalInput;
        }
    }
