<%@page import="web_grupo3.DaoProducto"%>
<%@page import="web_grupo3.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    DaoProducto dao = new DaoProducto();
    List<Producto> lst = dao.consultarTodos();    
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Nombre de la empresa</title>
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
                    <a class="navbar-brand" href="index.jsp">CyHrepalex	 

                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                            <li class="nav-item"><a class="nav-link" href="index.jsp">Inicio</a></li>
                            <li class="nav-item"><a class="nav-link" href="about.jsp">Nosotros</a></li>
                            <li class="nav-item"><a class="nav-link" href="contact.jsp">Contacto</a></li>
                            <li class="nav-item"><a class="nav-link" href="product.jsp">Productos</a></li>
                            <li class="nav-item"><a class="nav-link btn btn-outline-success mx-2" href="login.jsp">Login</a></li>                     
                            <li class="nav-item"><a class="nav-link btn btn-outline-success mx-2" href="consultar_estado.xhtml">Consultar Estado Reparacion</a></li> 
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
                                <h1 class="display-5 fw-bolder text-white mb-2">Servicio Tecnico Especializado</h1>
                                <p class="lead fw-normal text-white-50 mb-4">Reparaciones y mantenimiento de laptop y computadoras, venta de repuestos</p>
                                <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start">
                                    <a class="btn btn-primary btn-lg px-4 me-sm-3" href="#features">Info.</a>
                                    <a class="btn btn-outline-light btn-lg px-4" href="#mensajes">Mensaje</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-5 col-xxl-6 d-none d-xl-block text-center"><img class="img-fluid rounded-3 my-5" src="./img/img-nav.png" alt="..." /></div>
                    </div>
                </div>
            </header>
            <!-- Features section-->
            <section class="py-5" id="features">
                <div class="container px-5 my-5">
                    <div class="row gx-5">
                        <div class="col-lg-4 mb-5 mb-lg-0"><h2 class="fw-bolder mb-0">Información y Opciones de Pago.</h2></div>
                        <div class="col-lg-8">
                            <div class="row gx-5 row-cols-1 row-cols-md-2">
                                <div class="col mb-5 h-100">
                                    <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-check-lg"></i></div>
                                    <h2 class="h5">Garantia</h2>
                                    <p class="mb-0">1 año en Laptops y Computadoras y 3 meses en reparacion y accesorios.</p>
                                </div>
                                <div class="col mb-5 h-100">
                                    <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="i bi-telegram"></i></div>
                                    <h2 class="h5">Transferencia</h2>
                                    <p class="mb-0">Todos los bancos sin costo.</p>
                                </div>
                                <div class="col mb-5 mb-md-0 h-100">
                                    <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-credit-card"></i></div>
                                    <h2 class="h5">Tarjetas +5%</h2>
                                    <p class="mb-0">Aceptamos visa Mastercard se adicionael 5% del monto ingresado.</p>
                                </div>
                                <div class="col h-100">
                                    <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-truck"></i></div>
                                    <h2 class="h5">Envios Provincias</h2>
                                    <p class="mb-0">Los envios de los productos son a Nivel Nacional.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Testimonial section-->
            <div class="py-5 bg-light" id="mensajes">
                <div class="container px-5 my-5">
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-10 col-xl-7">
                            <div class="text-center">
                                <div class="fs-4 mb-4 fst-italic">"Estamos comprometidos en brindarte más que un simple servicio. Para nosotros, cada reparación es un compromiso con la excelencia y con mantenerte conectado."</div>
                                <div class="d-flex align-items-center justify-content-center">
                                    <img class="rounded-circle me-3" src="./img/Alex40x40.png" alt="..." />
                                    <div class="fw-bold">
                                        Alex Cancho
                                        <span class="fw-bold text-primary mx-1">/</span>
                                        CyHrepalex
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Blog preview section-->
            <section class="py-5">
                <div class="container px-5 my-5">
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-8 col-xl-6">
                            <div class="text-center">
                                <h2 class="fw-bolder">Productos</h2>
                                <p class="lead fw-normal text-muted mb-5">Tenemos accesorios como cargadores, baterias, teclados y pantallas asi como tambien laptops con garantia.</p>
                            </div>
                        </div>
                    </div>
                    
                    
                    <div class="row gx-5">
                    <% for(int i=0;i<lst.size();i++){ %>
                        <div class="col-lg-4 mb-5">
                            <div class="card h-100 shadow border-0">
                                <img class="card-img-top" src="./img/<%=lst.get(i).getImg_product()%>.png" alt="..." />
                                <div class="card-body p-4">
                                    <div class="badge bg-primary bg-gradient rounded-pill mb-2">Nuevo</div>
                                    <a class="text-decoration-none link-dark stretched-link fs-4 fw-bold" href="#!">
                                    <%=lst.get(i).getDescripcion_product()%> 
                                    </a>
                                </div>
                                <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                                    <div class="d-flex align-items-end justify-content-between">
                                        <div class="d-flex align-items-center">
                                            <div class="rounded-circle me-3"> <i class="bi bi-truck"></i> </div>
                                            <div class="small">
                                                <div class="fw-bold">PRECIO: <%=lst.get(i).getPrecio_product()%></div>
                                                <div class="text-muted">con garantia limitada</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <%  } %>
                        
                       
                      
                    </div>
                    <!-- Call to action-->
                    <aside class="bg-primary bg-gradient rounded-3 p-4 p-sm-5 mt-5">
                        <div class="d-flex align-items-center justify-content-between flex-column flex-xl-row text-center text-xl-start">
                            <div class="mb-4 mb-xl-0">
                                <div class="fs-3 fw-bold text-white">Contactanos via Whatsapp.</div>
                                <div class="text-white-50">envianos un mensaje a whatsapp sus dudas.</div>
                            </div>
                            <div class="ms-xl-4">
                                <div class="input-group mb-2">
                                    <input class="form-control" type="text" placeholder="Hola Buenas..." aria-label="Hola Buenas...." aria-describedby="button-newsletter" />
                                        <a href="https://wa.link/pz4wh4" >
                                            <button class="btn btn-outline-light" id="button-newsletter"  type="button">Enviar</button>
                                        </a>
                                </div>
                                <div class="small text-white-50">escribir sus dudas puntuales.</div>
                            </div>
                        </div>
                    </aside>
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
                        <a class="link-light small" href="#!">Terminos</a>
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
