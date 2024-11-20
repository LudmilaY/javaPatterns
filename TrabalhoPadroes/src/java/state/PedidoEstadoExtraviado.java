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
public class PedidoEstadoExtraviado implements PedidoEstado{
    
    public String getEstado(){
        return "Extraviado";
    }
    
    public String cancelar(Pedido pedido){
        return "Pedido não pode ser cancelado";
    }
    
    public String entregar(Pedido pedido){
        return "Pedido não pode ser entregue";
    }
    
    public String enviar(Pedido pedido){
        pedido.setEstado(new PedidoEstadoEntregue());
        return "Pedido não foi enviado";
    }
    
    public String extraviar(Pedido pedido){
        return "Pedido extraviado";
    }
    
    public String transitar(Pedido pedido){
        return "Pedido não está em trânsito";
    }
}
