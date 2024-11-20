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
import model.Pedido;

public class ApagarPedidoAction implements Action{
    
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        String id = request.getParameter("textID");
        String estado = request.getParameter("textEstado");

        if (estado.equals("") || id.equals("")) {
            response.sendRedirect("pedidoErro.jsp");
        } else {
            try {
                Pedido pedido = new Pedido(id, estado);
                PedidoDAO.getInstance().formDelete(pedido);
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
