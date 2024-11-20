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
public class PedidoEstadoTransito implements PedidoEstado{
    
    public String getEstado(){
        return "Em trânsito";
    }
    
    public String cancelar(Pedido pedido){
        return "Pedido não pode ser cancelado";
    }
    
    public String entregar(Pedido pedido){
        pedido.setEstado(new PedidoEstadoEntregue());
        return "Pedido pode ser entregue";
    }
    
    public String enviar(Pedido pedido){
        return "Pedido não foi enviado";
    }
    
    public String extraviar(Pedido pedido){
        pedido.setEstado(new PedidoEstadoExtraviado());
        return "Pedido foi extraviado";
    }
    
    public String transitar(Pedido pedido){
        return "Pedido está em trânsito";
    }
}
