<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="web_grupo3.DaoProducto" %>
<%@ page import="java.util.List" %>
<%@ page import="web_grupo3.Producto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Productos</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
</head>
<body class="d-flex flex-column h-100">
    <main class="flex-shrink-0">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container px-5">
                <a class="navbar-brand" href="index.jsp">CyHrepalex</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                         <li class="nav-item"><a class="nav-link" href="index.jsp">Inicio</a></li>
                            <li class="nav-item"><a class="nav-link" href="about.jsp">Nosotros</a></li>
                            <li class="nav-item"><a class="nav-link" href="contact.jsp">Contacto</a></li>
                            <li class="nav-item"><a class="nav-link" href="product.jsp">Productos</a></li>
                            <li class="nav-item"><a class="nav-link btn btn-outline-success mx-2" href="login.jsp">Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-5">
                <div class="row gx-5 align-items-center justify-content-center">
                    <div class="col-lg-8 col-xl-7 col-xxl-6">
                        <div class="my-5 text-center text-xl-start">
                            <h1 class="display-5 fw-bolder text-white mb-2">Nuestros Productos</h1>
                            <p class="lead fw-normal text-white-50 mb-4">Explora nuestros productos y accede a información detallada.</p>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- Products section -->
        <section class="py-5">
            <div class="container px-5 my-5">
                <h2 class="fw-bolder text-center mb-4">Lista de Productos</h2>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Imagen</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            try {
                                DaoProducto dao = new DaoProducto();
                                List<Producto> productos = dao.consultarTodos();
                                if (productos != null) {
                                    for (Producto p : productos) { 
                            %>
                                        <tr>
                                            <td><%= p.getMarca_product() %> - <%= p.getTipo_product() %></td>
                                            <td><%= p.getDescripcion_product() %></td>
                                            <td><img src="./img/<%= p.getImg_product() %>.png" alt="Imagen del Producto" style="width: 100px; height: auto;" /></td>
                                            <td><button class="btn btn-primary">Pedir</button></td>
                                        </tr>
                            <%
                                    }
                                } else {
                                    out.println("No se encontraron productos.");
                                }
                            } catch (Exception e) {
                                out.println("Error: " + e.getMessage());
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </section>
    </main>
    <!-- Footer-->
    <footer class="bg-dark py-4 mt-auto">
        <div class="container px-5">
            <div class="row align-items-center justify-content-between flex-column flex-sm-row">
                <div class="col-auto"><div class="small m-0 text-white">Copyright &copy; Repalex </div></div>
                <div class="col-auto">
                    <a class="link-light small" href="#!">Privacidad</a>
                    <span class="text-white mx-1">&middot;</span>
                    <a class="link-light small" href="#!">Términos</a>
                    <span class="text-white mx-1">&middot;</span>
                    <a class="link-light small" href="#!">Contacto</a>
                </div>
            </div>
        </div>
    </footer>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
</body>
</html>