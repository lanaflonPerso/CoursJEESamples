/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author nabil.ouerhani
 */
public class MaNote implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    private String sampleProperty;
    private PropertyChangeSupport propertySupport;
    private String myCours;
    private float note1;
    private float note2;
    private float note3;
    
    public MaNote() {
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

    public String getMyCours() {
        return myCours;
    }

    public void setMyCours(String myCours) {
        this.myCours = myCours;
    }

    public float getNote1() {
        return note1;
    }

    public float getNote2() {
        return note2;
    }

    public float getNote3() {
        return note3;
    }

    public void setNote1(float note1) {
        this.note1 = note1;
    }

    public void setNote2(float note2) {
        this.note2 = note2;
    }

    public void setNote3(float note3) {
        this.note3 = note3;
    }
    
    public float getMoyenne() {
        
        float tmp =  (float) ((note1 + note2 + note3)/3.0);
                return  tmp;
    }
 
}
