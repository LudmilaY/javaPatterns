/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Ludmila
 */
public class Cliente implements Observer {

    private String id;
    private String nome;
    private String email;
    private Observable produto;
    private String lancamento;

    public Cliente() {
    }
    
    public Cliente(String  nome){
        this.nome = nome;
    }

    public Cliente(String id, String nome, String email) {
        super();
        this.nome = nome;
        this.email = email;
        this.id = id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public Observable getProduto(){
        return produto;
    }
    
    public void setProduto (Observable produto){
        this.produto = produto;
    }
    
    public Cliente (Observable produto){
        this.produto = produto;
        produto.addObserver(this);
    }
    
    @Override
    public void update (Observable produtoSubject, Object arg){
        if (produtoSubject instanceof Produto){
            Produto produto = (Produto) produtoSubject;
            lancamento = produto.getLanca();
            System.out.println("Atenção " + getNome() + ", já temos mais um lançamento. " + "Este são os produtos:" + lancamento);
        }
    }

}
