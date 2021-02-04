<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
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
    <title>Tela de Login</title>
</head>

<body>
<div class="container">
    <div class="row mt-5">
        <div class="col-6">
            <h1>Faça Login</h1>
            <form method="POST" action="autenticar">
                <div class="form-group">
                    <label class="form-check-label" for="loginLogin">Login</label>
                    <input class="form-control" id="loginLogin" type="text" placeholder="Nome de usuário" name="login">
                </div>

                <div class="form-group">
                    <label class="form-check-label" for="loginSenha">Senha</label>
                    <input class="form-control" id="loginSenha" type="password" placeholder="Senha" name="senha">
                </div>

                <input type="submit" class="btn btn-primary" name="acao" value="Logar">
            </form>
        </div>

        <div class="col-6">
            <h1>Cadastre um usuário</h1>
            <form method="POST" action="cadastrar">
                <div class="form-group">
                    <label class="form-check-label" for="cadastroLogin">Login</label>
                    <input class="form-control" id="cadastroLogin" type="text" placeholder="Nome de usuário" name="login">
                </div>

                <div class="form-group">
                    <label class="form-check-label" for="cadastroSenha">Senha</label>
                    <input class="form-control" id="cadastroSenha" type="password" placeholder="Senha" name="senha">
                </div>

                <input type="submit" class="btn btn-primary" name="acao" value="Cadastrar">
            </form>
        </div>
    </div>
</div>
</body>
</html>