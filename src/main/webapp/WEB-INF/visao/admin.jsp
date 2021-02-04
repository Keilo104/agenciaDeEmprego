<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="author" content="Lucas Ceoni, Emanoela Simão, Vitor Pastore, João Araújo e Souza"/>
    <meta name="description" content="Aula PW3 - Trabalho final"/>
    <meta name="keywords" content="aula, web, java, mvc, servlet, ifsp, ads"/>
    <meta name="date" content="27/01/2021"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Administração</title>
</head>

<body>
<div class="container">
    <h1>Página de Administração</h1>
    <p>Seja bem vindo, ${sessionScope.usuario.login} | <a href="logout">Sair</a></p>
    
    <h2>Cadastre uma nova empresa</h2>
    <form method="POST" action="cadastrar-empresa">
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label class="form-check-label" for="codigo">Código</label>
                    <input class="form-control" id="codigo" type="text" placeholder="Código" name="codigo">
                </div>
    
                <div class="form-group">
                    <label class="form-check-label" for="nome">Nome</label>
                    <input class="form-control" id="nome" type="text" placeholder="Nome" name="nome">
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label class="form-check-label" for="login">Login</label>
                    <input class="form-control" id="login" type="text" placeholder="Nome de usuário" name="login">
                </div>
    
                <div class="form-group">
                    <label class="form-check-label" for="senha">Senha</label>
                    <input class="form-control" id="senha" type="password" placeholder="Senha" name="senha">
                </div>
            </div>
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
                <th scope="col">Nome</th>
                <th scope="col">Login</th>
                <th scope="col">Editar</th>
                <th scope="col">Excluir</th>
            </tr>
            </thead>

            <hr>

            <tbody>
            <c:forEach var="empresa" items="${requestScope.empresas}">
                <tr>
                    <td> ${empresa.codigo} </td>
                    <td> ${empresa.nome} </td>
                    <td> ${empresa.login} </td>
                    <td>
                        <a href="editar-empresa?codigo=${empresa.login}">
                            <button type="button" class="btn btn-primary">Editar</button>
                        </a>
                    </td>
                    <td>
                        <a href="excluir-empresa?codigo=${empresa.codigo}">
                            <button type="button" class="btn btn-danger">Excluir</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>