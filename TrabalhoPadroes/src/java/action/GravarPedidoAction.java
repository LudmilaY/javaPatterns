/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

/**
 *
 * @author Ludmila
 */

import persistence.PedidoDAO;
import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import state.*;

public class GravarPedidoAction implements Action{
    
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        String estado = request.getParameter("textEstado");
        String id_pedido = request.getParameter("textID_Pedido");
        String id_cliente = request.getParameter("textID_Cliente");
        String id_produto = request.getParameter("textID_Produto");
        String nome_produto = request.getParameter("textNome_Produto");
        String valor_produto = request.getParameter("textValor_Produto");
        String tipo_produto = request.getParameter("textTipo_Produto");
        //PedidoEstado estado = getEstado();

        if (id_pedido.equals("") || estado.equals("")) {
            response.sendRedirect("pedidoErro.jsp");
        } else {
            try {
                Pedido pedido = new Pedido(id_pedido, estado);
                Cliente cliente = new Cliente(id_cliente);
                Produto produto = new Produto(id_produto, nome_produto, valor_produto, tipo_produto);
                
                PedidoDAO.getInstance().formSave2(pedido, produto, cliente);
                response.sendRedirect("pedidoSucesso.jsp");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                response.sendRedirect("pedidoErro.jsp");
                ex.printStackTrace();
            }
        }
        
    }
    
}
