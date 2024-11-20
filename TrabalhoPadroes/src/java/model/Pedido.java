/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import state.*;

/**
 *
 * @author Ludmila
 */
public class Pedido {
    private String id;
    private PedidoEstado estado;
    
    public Pedido(String id, String estado) {
        super();
        this.id = id;
        this.estado = new PedidoEstadoEnviado();

    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }
    
    public Pedido(){
        this.estado = new PedidoEstadoEnviado();
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }
    
    public String cancelar(){
        return estado.cancelar(this);
    }
    
    public String entregar(){
        return estado.entregar(this);
    }
    
    public String enviar(){
        return estado.enviar(this);
    }
    
    public String extraviar(){
        return estado.extraviar(this);
    }
    
    public String transitar(){
        return estado.transitar(this);
    }
    
    public String getNomeEstado(){
        return estado.getEstado();
    }
    
}
