/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algo;

/**
 *
 * @author nabil.ouerhani
 */
public class Algo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
              
       int tab[] = {1,2,3,4,5,6,7,8,9,10} ;
       
       System.out.print("Affichage croissant:\n");
       AfficherCr(tab, 0, 9);
       
       System.out.print("Affichage decroissant:\n");
       AfficherDec(tab, 0, 9);
    }

    public static void AfficherCr(int tab[], int index, int max) {

        if (index > max) {
            return;
        }

        System.out.print(tab[index] + " ");
        AfficherCr(tab, index + 1, max);
    }

    public static void AfficherDec(int tab[], int index, int max) {

        if (index > max) {
            return;
        }

        AfficherDec(tab, index + 1, max);
        System.out.print(tab[index] + " ");

    }
}
