/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strategy;
import model.Produto;
/**
 *
 * @author user
 */
public class PadraoStrategy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Produto produto1 = new Produto("Tênis");
        Produto produto2 = new Produto("Sandália");
        Produto produto3 = new Produto("Bota");
        Produto produto4 = new Produto("Chinelo");
        
        System.out.println(produto1.getNome()+ " recebe o brinde "
                +produto1.getBrinde());
        
        System.out.println(produto2.getNome()+ " recebe o brinde "
                +produto2.getBrinde());
        
        System.out.println(produto3.getNome()+ " recebe o brinde "
                +produto3.getBrinde());
        
        System.out.println(produto4.getNome()+ " não recebe brinde.");
        
        
    }
    
}
