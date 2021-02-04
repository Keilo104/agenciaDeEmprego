<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="author" content="Lucas Ceoni, Emanoela Sim?o, Vitor Pastore, Jo?o Ara?jo e Souza" />
    <meta name="description" content="Aula PW3 - Trabalho final" />
    <meta name="keywords" content="aula, web, java, mvc, servlet, ifsp, ads" />
    <meta name="date" content="27/01/2021"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>P?gina do Candidato</title>
</head>

<body>
<div class="container">
    <h1>Cadastre um usu?rio</h1>
    <form method="POST" action="cadastrar">
        <div class="form-group">
            <label class="form-check-label" for="login">Login</label>
            <input class="form-control" id="login" type="text" placeholder="Nome de usu?rio" name="login">
        </div>

        <div class="form-group">
            <label class="form-check-label" for="senha">Senha</label>
            <input class="form-control" id="senha" type="password" placeholder="Senha" name="senha">
        </div>

        <input type="submit" class="btn btn-primary" name="acao" value="Cadastrar">
    </form>
</div>
</body>
</html>
