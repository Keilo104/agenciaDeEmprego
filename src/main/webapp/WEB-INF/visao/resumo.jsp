<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Resumo</title>
</head>
<body>
    <h1>Compra código número: ${compra.codigo}</h1>
    <h2>Produtos</h2>
    <table border=1>
        <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>Preço</th>
        </tr>

        <c:forEach var="item" items="${compra.itens}">
            <tr>
                <td>${item.codigo}</td>
                <td>${item.produto.nome}</td>
                <td>${item.produto.preco}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>