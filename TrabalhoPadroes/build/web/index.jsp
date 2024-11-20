<%-- 
    Document   : index
    Created on : 14/04/2016, 17:42:21
    Author     : Ludmila
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Trabalho AAES - Loja Calçados</title>
    </head>
    <body>
        <h1>Bem vindos! Selecione as páginas de cadastro:</h1>
        <a href="indexCliente.jsp">Cliente</a><br/>
        <a href="indexProduto.jsp">Produto</a><br/>
        <h1>Para verificar o estado e gravar o pedido:</h1>
        <a href="indexPedido.jsp">Pedido</a><br/>
        <form action="FrontController?action=LerProduto" method="post">
            <h1>Para verificar nossos produtos:</h1>        
            <input type="submit" value="Lista de Produtos"/><br/><br/>
        </form>
        <form action="FrontController?action=LerCliente" method="post">
            <h1>Para verificar nossos clientes</h1>        
            <input type="submit" value="Lista de Clientes"/><br/><br/>
        </form>
    </body>
</html>
