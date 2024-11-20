/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model;

import java.util.Observable;
import strategy.Brinde;
/**
*
* @author Ludmila
*/
public class Produto extends Observable{
   
   private String valor;
   private String nome;
   private String id;
   private String tipo;
   protected Brinde brinde;
   private Categoria categoria;

   public Produto(String id, String nome, String valor, String tipo){
       super();
       this.nome = nome;
       this.valor = valor;
       this.id = id;
       this.categoria = null;
       String nomeClasse = "model.Categoria"+tipo;
       Object objeto = null;
       try {
           Class classe = Class.forName(nomeClasse);
           objeto = classe.newInstance();
       } catch (Exception ex){
       }
       categoria = (Categoria) objeto;
       this.tipo = categoria.getCategoria();
       
   }
   
   public Produto() {
       super();
   }

   public Produto(String tipo) {
       this.tipo = tipo;
   }

   public String getValor() {
       return valor;
   }

   public void setValor(String valor) {
       this.valor = valor;
   }

   public String getNome() {
       return nome;
   }

   public String getTipo() {
       return tipo;
   }

   public void setTipo(String tipo) {
       Categoria categoria = null;
       String nomeClasse = "model.Categoria"+tipo;
       Object objeto = null;
       try {
           Class classe = Class.forName(nomeClasse);
           objeto = classe.newInstance();
       } catch (Exception ex){
           
       }
       categoria = (Categoria) objeto;
       this.tipo = categoria.getCategoria();
       this.tipo = tipo;
   }

   public void setNome(String nome) {
       this.nome = nome;
   }

   public String getID() {
       return id;
   }

   public void setID(String id) {
       this.id = id;
   }
   
   private String lanca;
   
   public void setLanca(String novoLanca){
       this.lanca = novoLanca;
       setChanged();
       notifyObservers();
   }
   
   public String getLanca(){
       return this.lanca;
   }
   
   public String getBrinde() {
       return this.categoria.obterBrinde();
   }

   public void setBrinde(Brinde brinde) {
       this.brinde = brinde;
   }
   
   public Categoria getCategoria(){
       return this.categoria;
   }
   
}