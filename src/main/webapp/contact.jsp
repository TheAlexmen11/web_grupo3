<%@ page import="validaciones.validacioncontact" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    boolean isValid = true;
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        isValid = validacioncontact.processForm(request);
    }
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Grupo 3</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        
    </head>
    <body class="d-flex flex-column">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container px-5">
                    <a class="navbar-brand" href="index.html">CyHrepalex</a>
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
            <!-- Page content-->
            <section class="py-5">
            <div class="container px-5">
                <!-- Contact form-->
                <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
                    <div class="text-center mb-5">
                        <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-envelope"></i></div>
                        <h1 class="fw-bolder">¡Contáctanos!</h1>
                        <p class="lead fw-normal text-muted mb-0">Nos encantaría saber de ti.</p>
                    </div>
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-8 col-xl-6">
                            <form id="contactForm" method="post">
						        <!-- Nombre -->
						        <div class="form-floating mb-3">
						            <input class="form-control" id="name" name="name" type="text" placeholder="Ingrese su nombre" />
						            <label for="name">Nombre Completo</label>
						            <% if (request.getAttribute("nameError") != null) { %>
						                <div class="error"><%= request.getAttribute("nameError") %></div> <!-- Mensaje de error en rojo -->
						            <% } %>
						        </div>
						
						        <!-- Correo Electrónico -->
						        <div class="form-floating mb-3">
						            <input class="form-control" id="email" name="email" type="email" placeholder="nombre@ejemplo.com" />
						            <label for="email">Correo Electrónico</label>
						            <% if (request.getAttribute("emailError") != null) { %>
						                <div class="error"><%= request.getAttribute("emailError") %></div> <!-- Mensaje de error en rojo -->
						            <% } %>
						        </div>
						
						        <!-- Número de Teléfono -->
						        <div class="form-floating mb-3">
						            <input class="form-control" id="phone" name="phone" type="tel" placeholder="Ingrese su teléfono" />
						            <label for="phone">Número de Teléfono</label>
						            <% if (request.getAttribute("phoneError") != null) { %>
						                <div class="error"><%= request.getAttribute("phoneError") %></div> <!-- Mensaje de error en rojo -->
						            <% } %>
						        </div>
						
						        <!-- Mensaje -->
						        <div class="form-floating mb-3">
						            <textarea class="form-control" id="message" name="message" placeholder="Escriba su mensaje" style="height: 10rem"></textarea>
						            <label for="message">Mensaje</label>
						            <% if (request.getAttribute("messageError") != null) { %>
						                <div class="error"><%= request.getAttribute("messageError") %></div> <!-- Mensaje de error en rojo -->
						            <% } %>
						        </div>
						
						        <!-- Botón Enviar -->
						        <div class="d-grid">
						            <button class="btn btn-primary btn-lg" id="submitButton" type="submit">Enviar</button>
						        </div>
						
						        <!-- Mensaje de éxito o advertencias generales -->
						        <% if (!isValid) { %>
						            <div class="error">Por favor corrija los errores antes de enviar.</div> <!-- Mensaje en rojo -->
						        <% } else if ("POST".equalsIgnoreCase(request.getMethod()) && isValid) { %>
						            <div class="text-center mb-3">
						                <div class="fw-bolder">¡Envío del formulario exitoso!</div>
						            </div>
						        <% } %>
						    </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
            
            <section class="py-5">
                <div class="container px-5 my-5">
                    <div class="text-center mb-5">
                        <h1 class="fw-bolder">Preguntas frecuentes</h1>
                        <p class="lead fw-normal text-muted mb-0">¿Cómo podemos ayudarle?</p>
                    </div>
                    <div class="row gx-5">
                        <div class="col-xl-8">
                            <!-- FAQ Accordion 1-->
                            <h2 class="fw-bolder mb-3">Cuenta &amp; Facturación </h2>
                            <div class="accordion mb-5" id="accordionExample">
                                <div class="accordion-item">
                                    <h3 class="accordion-header" id="headingOne"><button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">Información de contacto</button></h3>
                                    <div class="accordion-collapse collapse show" id="collapseOne" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            <strong>¿Cómo puedo actualizar mi información de contacto?</strong> Para actualizar tu información de contacto, inicia sesión en tu cuenta y dirígete a la sección "Perfil". Aquí encontrarás opciones para editar tu dirección de correo electrónico, número de teléfono y dirección postal. Guarda los cambios para que se actualicen en nuestro sistema.
                                        </div>
                                    </div>
                                </div>
                                <div class="accordion-item">
                                    <h3 class="accordion-header" id="headingTwo"><button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">Último pago</button></h3>
                                    <div class="accordion-collapse collapse" id="collapseTwo" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            <strong>¿Cómo puedo solicitar una factura detallada de mi último pago?</strong>
											Puedes solicitar una factura detallada desde tu panel de login. Ve a la sección "Historial de pagos" y selecciona el pago para el cual necesitas la factura. Haz clic en "Solicitar factura detallada" y recibirás un correo electrónico con el documento en formato PDF.
                                        </div>
                                    </div>
                                </div>
                                <div class="accordion-item">
                                    <h3 class="accordion-header" id="headingThree"><button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">Cargo en mi cuenta</button></h3>
                                    <div class="accordion-collapse collapse" id="collapseThree" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            <strong>¿Qué debo hacer si tengo problemas con un cargo en mi cuenta?</strong>
											Si encuentras un cargo incorrecto o inesperado, por favor contacta a nuestro equipo de soporte. Proporciona detalles sobre el cargo y cualquier información relevante. Nuestro equipo investigará el problema y se pondrá en contacto contigo para resolverlo lo antes posible.
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- FAQ Accordion 2-->
                            <h2 class="fw-bolder mb-3">Problemas con el sitio web</h2>
                            <div class="accordion mb-5 mb-xl-0" id="accordionExample2">
                                <div class="accordion-item">
                                    <h3 class="accordion-header" id="headingOne"><button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne2" aria-expanded="true" aria-controls="collapseOne2">Acceso a mi cuenta</button></h3>
                                    <div class="accordion-collapse collapse show" id="collapseOne2" aria-labelledby="headingOne" data-bs-parent="#accordionExample2">
                                        <div class="accordion-body">
                                            <strong>¿Por qué no puedo acceder a mi cuenta?</strong>
                                            Si tienes problemas para acceder a tu cuenta, verifica que estás utilizando el nombre de usuario y la contraseña correctos. Si has olvidado tu contraseña, utiliza la opción "¿Olvidaste tu contraseña?" en la página de inicio de sesión para restablecerla. Si el problema persiste, contacta a nuestro soporte técnico para asistencia adicional.
                                        </div>
                                    </div>
                                </div>
                                <div class="accordion-item">
                                    <h3 class="accordion-header" id="headingTwo"><button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo2" aria-expanded="false" aria-controls="collapseTwo2">Páginas no se cargan</button></h3>
                                    <div class="accordion-collapse collapse" id="collapseTwo2" aria-labelledby="headingTwo" data-bs-parent="#accordionExample2">
                                        <div class="accordion-body">
                                            <strong>¿Por qué algunas páginas no se cargan correctamente?</strong>
                                            Si ciertas páginas no se cargan correctamente, primero intenta refrescar la página o borrar la caché de tu navegador. Asegúrate de que tu conexión a Internet esté funcionando correctamente. Si el problema persiste, puede deberse a un error en nuestro sitio web. Por favor, reporta el problema a nuestro equipo de soporte proporcionando detalles sobre la página afectada.

                                        </div>
                                    </div>
                                </div>
                                <div class="accordion-item">
                                    <h3 class="accordion-header" id="headingThree"><button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree2" aria-expanded="false" aria-controls="collapseThree2">Errores o fallos</button></h3>
                                    <div class="accordion-collapse collapse" id="collapseThree2" aria-labelledby="headingThree" data-bs-parent="#accordionExample2">
                                        <div class="accordion-body">
                                            <strong>¿Qué debo hacer si encuentro errores o fallos en el sitio web?</strong>
                                            Si encuentras errores o fallos en el sitio web, por favor reporta el problema a nuestro equipo de soporte técnico. Incluye una descripción detallada del error, los pasos que seguiste antes de encontrar el problema y cualquier mensaje de error que hayas recibido. Esto nos ayudará a investigar y resolver el problema lo más rápido posible.
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-4">
                            <div class="card border-0 bg-light mt-xl-5">
                                <div class="card-body p-4 py-lg-5">
                                    <div class="d-flex align-items-center justify-content-center">
                                        <div class="text-center">
                                            <div class="h6 fw-bolder">¿Tiene más preguntas?</div>
                                            <p class="text-muted mb-4">
                                                Contáctenos en
                                                <br />
                                                <a href="#!">Grupo03@utp.edu.pe</a>
                                            </p>
                                            <div class="h6 fw-bolder">Siguenos!</div>
                                            <a class="fs-5 px-2 link-dark" href="#!"><i class="bi-twitter"></i></a>
                                            <a class="fs-5 px-2 link-dark" href="#!"><i class="bi-facebook"></i></a>
                                            <a class="fs-5 px-2 link-dark" href="#!"><i class="bi-linkedin"></i></a>
                                            <a class="fs-5 px-2 link-dark" href="#!"><i class="bi-youtube"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            
        </main>
        <!-- Footer-->
        <!-- Footer-->
        <footer class="bg-dark py-4 mt-auto">
            <div class="container px-5">
                <div class="row align-items-center justify-content-between flex-column flex-sm-row">
                    <div class="col-auto"><div class="small m-0 text-white">Copyright &copy; Your Website 2023</div></div>
                    <div class="col-auto">
                        <a class="link-light small" href="#!">Privacy</a>
                        <span class="text-white mx-1">&middot;</span>
                        <a class="link-light small" href="#!">Terms</a>
                        <span class="text-white mx-1">&middot;</span>
                        <a class="link-light small" href="#!">Contact</a>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>    
</html>
