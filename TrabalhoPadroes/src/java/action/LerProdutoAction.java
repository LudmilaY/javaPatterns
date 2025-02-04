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

import persistence.ProdutoDAO;
import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

public class LerProdutoAction implements Action{
    
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        
        try {
            List<Produto> produtos = ProdutoDAO.getInstance().getAll();
            request.setAttribute("produtos", produtos);
            
            request.getRequestDispatcher("indexListaProdutos.jsp").forward(request, response);
        }catch (SQLException ex) {
            response.sendRedirect("produtoErro.jsp");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(LerProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}