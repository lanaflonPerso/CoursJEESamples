/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Panier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.New;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nabil.ouerhani
 */
@Named(value = "panier")
@SessionScoped
public class PanierController implements Serializable {

    private ArrayList<Panier> prodList;
    private HashMap products;

    private String selectedFruit;
    private int quantity;

    /**
     * Creates a new instance of Panier
     */
    public PanierController() {

        products = new HashMap();
        products.put("Banane", 0);
        products.put("Apple", 0);
        products.put("Orange", 0);

        prodList = new ArrayList();
        Panier prod = new Panier ("Laptop", 0);
        prodList.add(prod);
        
        prod = new Panier ("iPhone", 0);
        prodList.add(prod);
        
        prod = new Panier ("iPad", 0);
        prodList.add(prod);
    }

    public void AddProduct() {

        invalidateCache();

        Set s = products.entrySet();
        Iterator it = s.iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (pair.getKey().toString().equals(selectedFruit) ) {

                pair.setValue((int) pair.getValue() + quantity);

            }

        }

    }

    public List<Entry<String, Integer>> getPanierContentList() {

        invalidateCache();

        List<Entry<String, Integer>> entries = new ArrayList<Entry<String, Integer>>();

        Set s = products.entrySet();
        Iterator it = s.iterator();
        
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            entries.add(pair);

        }

        return (entries);
    }

    public List<SelectItem> getMyProdList() {

        invalidateCache();
        
        List<SelectItem> list = new ArrayList<SelectItem>();

        int i = 0;
        String tmp;

        Set s = products.entrySet();
        Iterator it = s.iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String name = pair.getKey().toString();
            int val = (int) pair.getValue();

            SelectItem e = new SelectItem(name, name);
            list.add(e);

        }


        /**
         * while (i< prodList.size()) { tmp = prodList.get(i); SelectItem e =
         * new SelectItem(tmp, tmp); list.add(e); i++; }
         *
         */
        return list;
    }
    
    public List<Panier> getProdList (){
        
        return prodList;
    }

    public String getSelectedFruit() {
        return selectedFruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setSelectedFruit(String selectedFruit) {
        this.selectedFruit = selectedFruit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void invalidateCache() {

        ExternalContext context =
                FacesContext.getCurrentInstance().getExternalContext();

        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        response.setContentType("text/html;charset=UTF-8");

        response.setHeader("Cache-Control", "no-cache, no-store, mu st-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.
    }
}
