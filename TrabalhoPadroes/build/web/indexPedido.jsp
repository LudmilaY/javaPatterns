<%-- 
    Document   : indexPedido
    Created on : 14/04/2016, 17:41:53
    Author     : Ludmila
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Loja Calçados - Pedido</title>
    </head>
    <body>

    <h1>Visualizar Pedidos</h1>
    <form action="FrontController?action=LerPedido" method="post">
      Entre com o identificador (id):
      <input type="text" name="textID"/><br/>
      <input type="submit"/><br/><br/>
      <a href="index.jsp">Voltar</a><br/>
    </form>
    
    <h1>Gravar Pedidos</h1>
    <form action="FrontController?action=GravarPedido" method="post">
      Entre com o estado do pedido:
      <input type="text" name="textEstado"/><br/>
      Entre com o identificador do pedido(id):
      <input type="text" name="textID_Pedido"/><br/>
      Entre com o identificador do cliente(id):
      <input type="text" name="textID_Cliente"/><br/>
      Entre com o identificador do produto(id):
      <input type="text" name="textID_Produto"/><br/>
      Entre com o nome do produto(id):
      <input type="text" name="textNome_Produto"/><br/>
      Entre com o valor do produto(id):
      <input type="text" name="textValor_Produto"/><br/>
      Entre com o tipo do produto(id):
      <input type="text" name="textTipo_Produto"/><br/>
      <input type="submit"/><br/><br/>
      <a href="index.jsp">Voltar</a><br/>
    </form>
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
