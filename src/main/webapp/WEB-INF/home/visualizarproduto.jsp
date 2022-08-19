<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page isELIgnored="false" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Crazy D Store</title>

</head>

<body>

<nav class="navbar  navbar-expand-lg navbar-light bg-white" aria-label="Offcanvas navbar large">
    <div class="container-fluid">

        <div class="d-flex flex-row-reverse">
            <div class="p-2"><a class="navbar-brand" href="/crazyd/home"> Crazy &#128142; Store </a> </div>
        </div>



        <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample08">
                <form action="/crazyd/pesquisa/produto" method="post" class="d-flex mt-3 mt-lg-0" role="search">
                    <input class="form-control me-2"   name="pesquisa">
                    <button class="btn btn-outline-success" type="submit">Pesquisar</button>
                </form>
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

                        <c:if test="${ empty usuario_logado}">
                        <li class="nav-item">
                            <a class="navbar-brand " aria-current="page" href="/crazyd/login/"> Bem Vindo </a>
                        </li>
                        </c:if>

                        <c:if test="${not empty usuario_logado}">
                            <li class="nav-item">
                                <a class="navbar-brand " aria-current="page" href="#"> Olá  ${usuario_logado.nome} </a>
                            </li>
                        </c:if>


                        <c:if test="${empty usuario_logado}">
                        <li class="nav-item">
                            <a class="nav-link " aria-current="page" href="/crazyd/login/">Login </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/cadastro/redirect"/>"> Cadastre-se</a>
                        </li>
                        </c:if>

                        <c:if test="${not empty usuario_logado}">
                        <c:if test="${ usuario_logado.permissao == 2}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/compra/compras?id_usuario=${usuario_logado.id}"/>"> Compras</a>
                        </li>
                        </c:if>
                        </c:if>

                        <c:if test="${ usuario_logado.permissao == 1}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/compra/vendas?id_usuario=${usuario_logado.id}"/>"> Vendas</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/crazyd/produto/listar"> Cadastrar produto</a>
                        </li>
                        </c:if>

                        <c:if test="${not empty usuario_logado}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/cadastro/visualizar?email=${usuario_logado.email}"/>"> Conta</a>
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


<main>

    <section class="py-5 text-center container">
    <div class="row py-lg-5" >
        <div class="col-lg-6 col-md-8 mx-auto">
            <h1 class="fw-light">Crazy &#128142; Store</h1>
            <p class="lead text-muted">A @crazyd.store é uma loja virtual para artigos em resina criada com muito carinho no ano de 2021. </p>
            <p>
                <a href="#" class="btn btn-primary my-2">	&#128269; Saiba Mais &#128269;</a>
                <a href="#" class="btn btn-secondary my-2">&#128242; Entre em Contato &#128242;</a>
            </p>
        </div>
    </div>
    </section>

    <div class="album py-5 bg-light">
        <div class="container">
            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

<c:forEach var = "produto" items="${produtos}">
    <div class="col">
     <div class="card shadow-sm">

         <div>

             <img  src="<c:url value="/img/logo.png"/>"  alt="" width="100" height="90">
         </div>


                        <div class="card-body">
                            <p class="card-text"> ${produto.nome} - R$${produto.preco}0 </p>
                            <p> <small class="text-muted">${produto.descricao} </small> </p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <c:if test="${not empty usuario_logado}">
                                        <a  href="<c:url value="/compra/produto?id_produto=${produto.id}&id_usuario=${usuario_logado.id}"/>"><button type="button" class="btn btn-success"  >Comprar </button></a>
                                    </c:if>

                                    <c:if test="${ empty usuario_logado}">
                                        <a  href="<c:url value="/login"/>"><button type="button" class="btn btn-info"  >Comprar </button></a>
                                    </c:if>

                                </div>
                                <small class="text-muted"> Quantidade em estoque: ${produto.quantidade}</small>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>

            </div>
        </div>
    </div>
</main>

</body>
</html>
