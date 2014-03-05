/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author nabil.ouerhani
 */
public class Produit implements Serializable {

    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    private String sampleProperty;
    private PropertyChangeSupport propertySupport;
    
    private String prod1 = "Ordinateur";
    private String prod2 = "iPad";
    private String prod3 = "iPhone";
    
    private int count1 = 0;
    private int count2 = 0;
    private int count3 = 0;

    public Produit() {
        propertySupport = new PropertyChangeSupport(this);
    }

    public String getSampleProperty() {
        return sampleProperty;
    }

    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    public String getProd1() {
        return prod1;
    }

    public String getProd2() {
        return prod2;
    }

    public String getProd3() {
        return prod3;
    }

    public int getCount1() {
        return count1;
    }

    public int getCount2() {
        return count2;
    }

    public int getCount3() {
        return count3;
    }

    public void setProd1(String prod1) {
        this.prod1 = prod1;
    }

    public void setProd2(String prod2) {
        this.prod2 = prod2;
    }

    public void setProd3(String prod3) {
        this.prod3 = prod3;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public void setCount2(int count2) {
        this.count2 = count2;
    }

    public void setCount3(int count3) {
        this.count3 = count3;
    }
    
    
}
