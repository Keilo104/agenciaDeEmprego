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
    <h1>Bem vindo, ${sessionScope.login} </h1>

    <p>Abaixo encontram-se as empresas e cargos </p>
    <c:if test="${not empty empregos}">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">C?digo</th>
                <th scope="col">Empresa</th>
                <th scope="col">Cargo</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="produto" items="${requestScope.empregos}">
                <tr>
                    <td> ${produto.codigo} </td>
                    <td> ${produto.empresa} </td>
                    <td> ${produto.cargo} </td>
                    <td>
                        <a href="controle?acao=DesvincularCurriculo&codigo=${empresa.codigo}">
                            <button type="button" class="btn btn-danger">Desvincular Curriculo</button> </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>