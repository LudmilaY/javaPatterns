<%-- 
    Document   : indexProduto
    Created on : 14/04/2016, 17:41:53
    Author     : Ludmila
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Loja Calçados - Produto</title>
    </head>
    <body>

    <h1>Cadastro de Produtos</h1>
    <form action="FrontController?action=GravarProduto" method="post">
      Entre com nome do produto:
      <input type="text" name="textNome"/><br/>
      Entre com o valor do produto:
      <input type="text" name="textValor"/><br/>
      Entre com o identificado (id):
      <input type="text" name="textID"/><br/>
      Entre com o tipo:
      <input type="text" name="textTipo"/><br/>
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
