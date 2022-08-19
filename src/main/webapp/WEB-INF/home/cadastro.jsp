<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<nav class="navbar navbar-expand-lg navbar-light bg-white" aria-label="Offcanvas navbar large">
    <div class="container-fluid">

        <div>

            <h1> Crazy D Store </h1>
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

                    <a class="nav-link " aria-current="page" href="/crazyd/home/">  <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6zm5-.793V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                        <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
                    </svg> </a>

                    <li class="nav-item">
                        <a class="nav-link " aria-current="page" href="/crazyd/login/">Fazer login </a>
                    </li>


                </ul>

            </div>
        </div>
    </div>
</nav>

<div >
    <div class="container-xl">


            <h1 >Realizar cadastro </h1>




<form class="row g-3" action="/crazyd/cadastro/cadastrar" method="post" >
    <div>

        <img  src="<c:url value="/img/logo.png"/>" class="mb-4"  alt="" width="150" height="150">
    </div>
    <div class="mb-3">
        <label for="inputAddress" class="form-label">Nome</label>
        <input type="text" class="form-control" id="inputAddress" name="nome" placeholder="Digite seu nome:" required>
    </div>

    <div class="mb-3">
        <label for="inputEmail4" class="form-label">Email  </label>
        <input type="email" class="form-control" id="inputEmail4" name="email" placeholder="Digite seu email:" required>
    </div>
    <br>
    <div class="mb-3">
        <label for="inputPassword4" class="form-label">Senha  </label>
        <input type="password" class="form-control" name="senha" id="inputPassword4" placeholder="Digite sua senha:" required>
    </div>


    <div class="col-12">
        <input type="submit" class="btn btn-primary" value="Cadastrar" name="Cadastrar" ></input>
    </div>
</form>

<c:if test="${not empty retorno}">
<div class="alert alert-success" role="alert">
        ${retorno}
</div>
</c:if>

<c:if test="${not empty erro}">
<div class="alert alert-danger" role="alert">
        ${erro}
</div>
</c:if>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
</body>
</html>
