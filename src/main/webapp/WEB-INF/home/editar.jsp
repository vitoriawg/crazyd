<%--
  Created by IntelliJ IDEA.
  User: Dimas
  Date: 18/06/2022
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crazy D Store</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<body>

<nav class="navbar  navbar-expand-lg navbar-light bg-white" aria-label="Offcanvas navbar large">
    <div class="container-fluid">

        <div class="d-flex flex-row-reverse">
            <div class="p-2"><a class="navbar-brand" href="/crazyd/home"> Crazy &#128142; Store </a> </div>
        </div>

        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar2" aria-controls="offcanvasNavbar2">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="offcanvas offcanvas-end text-white bg-dark" tabindex="-1" id="offcanvasNavbar2" aria-labelledby="offcanvasNavbar2Label">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasNavbar2Label">Menu</h5>
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
                        <a class="nav-link active " href="/crazyd/produto/listar"> Cadastrar Produtos</a>
                    </li>
                    </c:if>
                    <c:if test="${not empty usuario_logado}">
                    <li class="nav-item">
                        <a class="nav-link " href="<c:url value="/cadastro/editar?email=${usuario_logado.email}"/>"> Conta</a>
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


<div class="album py-5 bg-light">
    <div class="container-xl">


            <h1 >Edição de Produto </h1>
            <div class="mb-3">


                <form:form method="post" action="/crazyd/produto/editar" modelAttribute="produto">
                    <div class="mb-3">
                        <form:input path="id"  type="hidden" value=" ${produto.id}" ></form:input>
                        <form:label path="nome" for="inputAddress" class="form-label" >Nome</form:label>
                        <form:input path="nome" required="required" type="text" class="form-control" ></form:input>
                    </div>
                    <div class="mb-3">
                        <form:label path="preco" for="inputAddress" class="form-label">Preço</form:label>
                        <form:input path="preco" required="required" type="number" class="form-control" step="0.01" min="1"  ></form:input>
                    </div>
                    <div class="mb-3">
                        <form:label path="quantidade" for="inputAddress" class="form-label">Quantidade</form:label>
                        <form:input path="quantidade" required="required" type="number" class="form-control" min="0" ></form:input>
                    </div>
                    <div class="mb-3">
                        <form:label path="descricao" for="inputAddress" class="form-label">Descrição</form:label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"
                        <form:textarea path="descricao" required="required"  type="text" class="form-control"  ></form:textarea>
                        </textarea>
                    </div>

                    <input type="submit" value="Cadastrar" name="Cadastrar" class="btn btn-primary" >
                    <a href="/crazyd/produto/listar" class="btn btn-secondary"  > VOLTAR </a>
                </form:form>

            </div>
        </div>
    </div>
</div>

</body>
</html>
