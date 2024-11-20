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
public class CategoriaSandalia extends Categoria{
     
    public String obterBrinde() {
        this.b = new BrindePulseira();
        return b.obterBrinde();
    }

    public String getCategoria() {
        return "Sandália";
    }
    
}
