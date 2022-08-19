<%--
  Created by IntelliJ IDEA.
  User: aluno
  Date: 20/05/2022
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

    <title>Crazy D Store</title>
</head>
<body >

<nav class="navbar  navbar-expand-lg navbar-white bg-light" aria-label="Offcanvas navbar large">
    <div class="container-fluid">

        <div class="d-flex flex-row-reverse">
            <div class="p-2"><a class="navbar-brand" href="/crazyd/home"> Crazy &#128142; Store </a> </div>
        </div>

        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar2" aria-controls="offcanvasNavbar2">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="offcanvas offcanvas-end text-white bg-dark" tabindex="-1" id="offcanvasNavbar2" aria-labelledby="offcanvasNavbar2Label">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasNavbar2Label">Offcanvas</h5>
                <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">

                    <li class="nav-item">
                        <a class="nav-link " aria-current="page" href="/crazyd/home/">  <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6zm5-.793V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                            <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
                        </svg> </a>
                    </li>



                <c:if test="${empty usuario_logado}">
                    <li class="nav-item">
                        <a class="nav-link " aria-current="page" href="/crazyd/login/">Fazer login </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/cadastro/redirect"/>"> Cadastre-se</a>
                    </li>
                    </c:if>

                    <c:if test="${not empty usuario_logado}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/compra/compras?id_usuario=${usuario_logado.id}"/>"> Compras</a>
                    </li>
                    </c:if>

                    <c:if test="${ usuario_logado.permissao == 1}">

                    <li class="nav-item">
                        <a class="nav-link" href="/crazyd/produto/listar"> Cadastrar Produtos</a>
                    </li>
                    </c:if>
                    <c:if test="${not empty usuario_logado}">
                    <li class="nav-item">
                        <a class="nav-link active" href="<c:url value="/cadastro/editar?email=${usuario_logado.email}"/>"> Conta</a>
                    </li>
                    </c:if>

                    <c:if test="${not empty usuario_logado}">
                    <li class="nav-item">
                        <a class="nav-link"href="/crazyd/login/sair"> Sair</a>
                    </li>
                    </c:if>



            </div>
        </div>
    </div>
</nav>
<div class="mb-3">
    <div class="container-xl">

        <div class="mb-3">
            <h1 ">Dados Cadastrais </h1>
            <div class="mb-3">
                <form class="mb-3" action="/crazyd/cadastro/editar" method="post" >
                    <div class="col-12">
                        <label  for="disabledTextInput"  class="form-floating">Nome</label>
                        <input type="text" id="disabledTextInput" class="form-control" name="nome" value="${usuario.nome}" placeholder="" disabled >
                    </div>

                    <div class="mb-3">
                        <label for="inputEmail4"  class="form-label">Email  </label>
                        <input type="email" class="form-control" id="inputEmail4" name="email" value="${usuario.email}" placeholder="Digite seu email:" disabled >
                        <input type="hidden" value="${usuario.email}" name="email" >
                    </div>
                    <div class="mb-3">
                        <label for="inputPassword4" class="form-label">Senha  </label>
                        <input type="password" class="form-control" name="senha" id="inputPassword4" value="${usuario.senha}" placeholder="Digite sua senha:" disabled>
                    </div>
                    <div class="mb-3">
                        <input type="submit" class="btn btn-primary" value="Editar" name="Cadastrar" >

                        <a href="/crazyd/home" class="btn btn-secondary"  > Voltar </a>
                        <a href="/crazyd/home"> <button type="button" class="btn btn-danger" onclick="return confirm('Deseja excluir esse usuario?')" >Excluir</button>
                    </a>
                    </div>
                </form>


                <c:if test="${not empty retorno}">

                <div class="alert alert-success" role="alert">
                        ${retorno}
                </div>
                </c:if>

                <c:if test="${not empty erro}">

                <div class="alert alert-success" role="alert">
                        ${erro}
                </div>
                </c:if>
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
</body>
</html>
