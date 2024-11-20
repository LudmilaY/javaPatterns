/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.*;

/**
 *
 * @author Ludmila
 */
public class PedidoDAO {

    private static PedidoDAO instance = new PedidoDAO();

    public static PedidoDAO getInstance() {
        return instance;
    }

    private PedidoDAO() {
    }

    public void formSave(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into pedido (estado, id_pedido)"
                    + " values ('" + pedido.getEstado() + "','" + pedido.getID() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }
    
    public void formSave2(Pedido pedido, Produto produto, Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into pedido (estado, id_pedido, id_cliente, id_produto)"
                    + " values ('" + pedido.getEstado() + "','" + pedido.getID() + "')");
            st.execute("select * from cliente (id_cliente)"
                    + " values ('" + cliente.getID() + "')");
            st.execute("select * from produto (id_produto, nome, valor, tipo)"
                    + " values ('" + produto.getID() + "','" + produto.getNome() + "','" + produto.getValor() + "','" + produto.getTipo() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }
    
    public void formDelete(Pedido pedido)throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete into pedido (estado, id_pedido)"
                    + " values ('" + pedido.getEstado() + "','" + pedido.getID() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
    }
    
    public void formLer(Pedido pedido)throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("SELECT cliente.ID_Cliente, cliente.Nome, produto.Nome FROM cliente, pedido, produto INNER JOIN produto ON (pedido.ID_Pedido = produto.ID_Produto) INNER JOIN cliente ON (cliente.ID_Cliente = pedido.ID_Pedido)");
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
