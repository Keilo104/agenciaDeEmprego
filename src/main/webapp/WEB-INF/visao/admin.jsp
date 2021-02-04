<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="author" content="Lucas Ceoni, Emanoela Simão, Vitor Pastore, João Araújo e Souza" />
    <meta name="description" content="Aula PW3 - Trabalho final" />
    <meta name="keywords" content="aula, web, java, mvc, servlet, ifsp, ads" />
    <meta name="date" content="27/01/2021"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Administração</title>
</head>

<body>
<div class="container">
    <h1>Página de Administração</h1>
    <p>Seja bem vindo, ${sessionScope.login} | <a href="controle?acao=Deslogar">Sair</a></p>

    <h2>Cadastre uma nova empresa</h2>
    <form method="POST" action="controle">
        <div class="form-group">
            <label class="form-check-label" for="codigo">Código</label>
            <input class="form-control" id="codigo" type="text" placeholder="Código" name="codigo">
        </div>

        <div class="form-group">
            <label class="form-check-label" for="nome">Nome</label>
            <input class="form-control" id="nome" type="text" placeholder="Nome" name="nome">
        </div>

        <input type="submit" class="btn btn-primary" value="Cadastrar">
        <input type="hidden" name="acao" value="GravarEmpresa">
    </form>
</div>

<div class="container">
    <h2>Empresas cadastradas</h2>
    <c:if test="${not empty empresas}">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Código</th>
                <th scope="col">Empresa</th>
                <th scope="col">Editar</th>
                <th scope="col">Excluir</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="empresa" items="${requestScope.empresas}">
                <tr>
                    <td> ${produto.codigo} </td>
                    <td> ${produto.empresa} </td>
                    <td>
                        <a href="controle?acao=EditarEmpresa&codigo=${empresa.codigo}">
                            <button type="button" class="btn btn-primary">Editar</button> </a>
                    </td>
                    <td>
                        <a href="controle?acao=ExcluirEmpresa&codigo=${empresa.codigo}">
                            <button type="button" class="btn btn-danger">Excluir</button> </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>