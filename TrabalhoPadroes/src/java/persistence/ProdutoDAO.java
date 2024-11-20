/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;

/**
 *
 * @author Ludmila
 */
public class ProdutoDAO {

    private static ProdutoDAO instance = new ProdutoDAO();

    public static ProdutoDAO getInstance() {
        return instance;
    }

    private ProdutoDAO() {
    }
    
    public List<Produto> getAll() throws SQLException, ClassNotFoundException{
        List<Produto> produtos = new ArrayList<>();
        Connection conn = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
       try {
           conn = DatabaseLocator.getInstance().getConnection();
           String sql = "Select * from produto";
           ps = conn.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Produto produto = new Produto();
               produto.setID(rs.getString(1));
               produto.setNome(rs.getString(2));
               produto.setValor(rs.getString(3));
               produto.setTipo(rs.getString(4));
               
               produtos.add(produto);
           }
           
       } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, ps);
        }
        return produtos;
    }
    
    public void formSave(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into produto (id_produto, nome, valor, tipo)"
                    + " values ('" + produto.getID() + "','" + produto.getNome() + "', '" + produto.getValor() + "','" + produto.getTipo() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }
    
    public void formDelete(Produto produto)throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete into produto (nome, valor, id_produto, tipo)"
                    + " values ('" + produto.getNome() + "', '" + produto.getValor() + "', '" + produto.getID() + "', '" + produto.getID() + "', '" + produto.getTipo() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }
    
    public void formLer()throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("SELECT * FROM produto");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }

    public void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
        }
    }
}