<%-- 
    Document   : indexListaClientes
    Created on : 07/06/2016, 16:07:02
    Author     : Ludmila
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<h1>Listagem de Produtos:</h1>
    <%
            List<Cliente> clientes = new ArrayList<Cliente>();
            clientes = (ArrayList<Cliente>) request.getAttribute("clientes");
        %>
    
    <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
            </tr>
            <%
                if (clientes.size() > 0) {
                    for (Cliente cliente : clientes) {
            %>
            <tr>
                <td><%= cliente.getID()%></td>
                <td><%= cliente.getNome()%></td>
                <td><%= cliente.getEmail()%></td>
                
            </tr>
            <%
                    }
                }
            %>
      Verifique qual(is) é(são) o(s) cliente(s):
      <a href="index.jsp">Voltar</a><br/>       </body>
</html>
