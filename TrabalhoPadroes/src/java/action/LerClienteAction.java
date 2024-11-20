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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Produto;
import persistence.ProdutoDAO;



public class LerClienteAction implements Action{
    
    
        
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        
        try {
            List<Cliente> clientes = ClienteDAO.getInstance().getAll();
            request.setAttribute("clientes", clientes);
            
            request.getRequestDispatcher("indexListaClientes.jsp").forward(request, response);
        }catch (SQLException ex) {
            response.sendRedirect("clienteErro.jsp");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(LerProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    }
//        String nome = request.getParameter("textNome");
//        String email = request.getParameter("textEmail");
//        String id = request.getParameter("textID");
//        
//        if (nome.equals("") || email.equals("") || id.equals("")) {
//            response.sendRedirect("clienteErro.jsp"); //FALTOU O CODIGO.EQUALS ???
//        } else {
//            try {
//                Cliente cliente = new Cliente(id, nome, email);
//                ClienteDAO.getInstance().formLer(cliente);
//                response.sendRedirect("clienteSucesso.jsp");
//            } catch (ClassNotFoundException ex) {
//                ex.printStackTrace();
//            } catch (SQLException ex) {
//                response.sendRedirect("clienteErro.jsp");
//                ex.printStackTrace();
//            }
//        }
//        
//    }
