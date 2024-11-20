/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import strategy.*;

/**
 *
 * @author user
 */
public abstract class Categoria {
    protected Brinde b;
    public abstract String obterBrinde();
    public abstract String getCategoria();
    
    public String imprimeSetor(){
        return "Setor de "+ getCategoria();
    }
    
    public String imprimeBrinde(){
        return "Na compra de "+getCategoria()+" ganhe de brinde um(a) "+ obterBrinde();
    }
}
