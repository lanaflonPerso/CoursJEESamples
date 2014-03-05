/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author nabil.ouerhani
 */
public class CityConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        Integer id = new Integer(string);
        CityController controller = (CityController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "city");
        return controller.getJpaController().find(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof City) {
            City o = (City) object;
            return o.getId() == null ? "" : o.getId().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: sample.City");
        }
    }
    
}
