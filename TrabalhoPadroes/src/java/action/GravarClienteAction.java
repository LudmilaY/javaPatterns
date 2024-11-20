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

import persistence.ClienteDAO;
import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

public class GravarClienteAction implements Action{
    
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");
        String id = request.getParameter("textID");

        if (nome.equals("") || email.equals("") || id.equals("")) {
            response.sendRedirect("clienteErro.jsp");
        } else {
            try {
                Cliente cliente = new Cliente(id, nome, email);
                ClienteDAO.getInstance().formSave(cliente);
                response.sendRedirect("clienteSucesso.jsp");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                response.sendRedirect("clienteErro.jsp");
                ex.printStackTrace();
            }
        }
        
    }
    
}
