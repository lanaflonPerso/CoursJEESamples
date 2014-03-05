package myPackage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author nabil.ouerhani
 */
public class User implements Serializable {
    
    private String first_name;
    private String las_name;
    private Integer age;
    
    public String getFirst_name() {
        return first_name;
    }
    public String getLas_name() {
        return las_name;
    }
    public Integer getAge() {
        return age;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public void setLas_name(String las_name) {
        this.las_name = las_name;
    }
    public void setAge(Integer age) {
        this.age = age;
    } 
}
