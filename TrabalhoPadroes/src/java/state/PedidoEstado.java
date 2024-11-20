/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package state;
import model.Pedido;

/**
 *
 * @author user
 */
public interface PedidoEstado {
    
    public String getEstado();
    
    public String cancelar(Pedido pedido);
    
    public String entregar(Pedido pedido);
    
    public String enviar(Pedido pedido);
    
    public String extraviar(Pedido pedido);
    
    public String transitar(Pedido pedido);
    
}
