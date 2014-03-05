/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beansHoucem;

import java.util.List;

/**
 *
 * @author Houcem
 */
public class Selected {

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
    String val;
    String culture;
    String x;
    int ID;
    String type;
    String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAllow() {
        return allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }
    String key;
    String allow;
    String variable;
    List<String> text;

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public Selected(String x, int i, String y, String allow, String key, String time, String culture, String val, String variable,List<String> text) {
        this.x = x;
        this.ID = i;
        this.type = y;
        this.allow = allow;
        this.key = key;
        this.time = time;
        this.val = val;
        this.culture = culture;
        this.variable = variable;
        this.text=text;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }
}
