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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

public class GravarProdutoAction implements Action{
    
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        String nome = request.getParameter("textNome");
        String id = request.getParameter("textID");
        String valor = request.getParameter("textValor");
        String tipo = request.getParameter("textTipo");

        if (nome.equals("") || id.equals("") || valor.equals("") || tipo.equals("")) {
            response.sendRedirect("produtoErro.jsp");
        } else {
            try {
                Produto produto = new Produto(id, nome, valor, tipo);
                ProdutoDAO.getInstance().formSave(produto);
                response.sendRedirect("produtoSucesso.jsp");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                response.sendRedirect("produtoErro.jsp");
                ex.printStackTrace();
            }
        }
        
    }
    
}
