<%-- 
    Document   : indexListaProdutos
    Created on : 14/04/2016, 17:41:53
    Author     : Ludmila
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Loja Calçados - Pedido</title>
    </head>
    <body>
    <h1>Listagem de Produtos:</h1>
    <%
            List<Produto> produtos = new ArrayList<Produto>();
            produtos = (ArrayList<Produto>) request.getAttribute("produtos");
        %>
    
    <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Valor</th>
                <th>Categoria</th>
                <%--<th>Brinde</th>--%>
            </tr>
            <%
                if (produtos.size() > 0) {
                    for (Produto produto : produtos) {
            %>
            <tr>
                <td><%= produto.getID()%></td>
                <td><%= produto.getNome()%></td>
                <td><%= produto.getValor()%></td>
                <td><%= produto.getTipo()%></td>
                <%--<td><%= produto.getCategoria().imprimeBrinde()%></td>--%>
                
            </tr>
            <%
                    }
                }
            %>
      Verifique qual(is) é(são) o(s) produto(s):
      <a href="index.jsp">Voltar</a><br/>
    <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
    <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
    --%>
    
    </body>
</html>