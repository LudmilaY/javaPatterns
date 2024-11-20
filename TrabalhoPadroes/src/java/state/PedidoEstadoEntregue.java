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
public class PedidoEstadoEntregue implements PedidoEstado{
    
    public String getEstado(){
        return "Entregue";
    }
    public String cancelar(Pedido pedido){
        return "Pedido não pode ser cancelado";
    }
    
    public String entregar(Pedido pedido){
        return "Pedido entregue";
    }
    
    public String enviar(Pedido pedido){
        return "Pedido já foi enviado";
    }
    
    public String extraviar(Pedido pedido){
        return "Pedido não pode extraviar";
    }
    
    public String transitar(Pedido pedido){
        return "Pedido não pode estar em trânsito";
    }
}
