/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author nabil.ouerhani
 */
public class Panier {

    private String product;
    private int quantities;

    public Panier(String prod, int q) {
        
        this.product = prod;
        this.quantities = q;

    }

    public String getProduct() {
        return product;
    }

    public int getQuantities() {
        return quantities;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantities(int quantitties) {
        this.quantities = quantitties;
    }
}
