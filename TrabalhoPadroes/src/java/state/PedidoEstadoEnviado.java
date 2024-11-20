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
public class PedidoEstadoEnviado implements PedidoEstado{
    
    public String getEstado(){
        return "Enviado";
    }
    
    public String cancelar(Pedido produto){
        return "Pedido não pode ser cancelado";
    }
    
    public String entregar(Pedido produto){
        return "Pedido não entregue";
    }
    
    public String enviar(Pedido produto){
        return "Pedido foi enviado";
    }
    
    public String extraviar(Pedido produto){
        return "Pedido não pode extraviar";
    }
    
    public String transitar(Pedido produto){
        produto.setEstado(new PedidoEstadoTransito());
        return "Pedido em trânsito";
    }
}
