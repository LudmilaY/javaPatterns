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
import model.Cliente;
import model.Produto;

/**
 *
 * @author Ludmila
 */
public class ClienteDAO {

    private static ClienteDAO instance = new ClienteDAO();

    public static ClienteDAO getInstance() {
        return instance;
    }

    private ClienteDAO() {
    }

    public void formSave(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into cliente (nome, email, id_cliente)"
                    + " values ('" + cliente.getNome() + "', '" + cliente.getEmail() + "','" + cliente.getID() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }
    
    public List<Cliente> getAll() throws SQLException, ClassNotFoundException{
        List<Cliente> clientes = new ArrayList<>();
        Connection conn = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
       try {
           conn = DatabaseLocator.getInstance().getConnection();
           String sql = "Select * from cliente";
           ps = conn.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Cliente cliente = new Cliente();
               cliente.setID(rs.getString(1));
               cliente.setNome(rs.getString(2));
               cliente.setEmail(rs.getString(3));
               
               clientes.add(cliente);
           }
           
       } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, ps);
        }
        return clientes;
    }
    
    public void formDelete(Cliente cliente)throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete into cliente (nome, email, id_cliente)"
                    + " values ('" + cliente.getNome() + "', '" + cliente.getEmail() + "','" + cliente.getID() + "')" );
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }
    
    public void formLer(Cliente cliente)throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("select into cliente *");
            
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
