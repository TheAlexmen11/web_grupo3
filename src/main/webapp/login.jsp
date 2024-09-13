<%@page import="web_grupo3.DaoLogin"%>
<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
  	<title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

    <!-- FontAwesome CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/styles-form.css">

    
  </head>
  <body>
    <section class="ftco-section">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-md-7 col-lg-5">
            <div class="login-wrap p-4 p-md-5">
              <div class="icon d-flex align-items-center justify-content-center">
                <span class="fa fa-user-o"></span>
              </div>
              <h3 class="text-center mb-4 my-4">Iniciar Sesión</h3>

              <%
                // Proceso de autenticación
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                boolean showForm = true;
                
                if (username != null && password != null) {
                    String passwordHash = password;

                    DaoLogin dao = new DaoLogin();
                    boolean isValid = dao.validarUsuario(username, passwordHash);
                    
                    if (isValid) {
                        session.setAttribute("username", username);
                        response.sendRedirect("dashboard.jsp");
                        showForm = false; 
                    } else {
              %>
                      <div class="alert alert-danger">
                        <h3>Error</h3>
                        <p>Nombre de usuario o contraseña incorrectos.</p>
                      </div>
                      
						<div class="mx-auto my-2" style="width: 150px;">
							<a href="login.jsp" class="btn btn-secondary">Intentar de nuevo</a>
						</div>

              <%
                    }
                }
                if (showForm) {
              %>

              <form action="login.jsp" method="POST" class="login-form">
                <div class="form-group">
                  <input type="text" name="username" class="form-control rounded-left" placeholder="Usuario" required>
                </div>
                <div class="form-group d-flex">
                  <input type="password" name="password" class="form-control rounded-left" placeholder="Contraseña" required>
                </div>
                <div class="form-group">
                  <button type="submit" class="form-control btn btn-primary rounded submit px-3">Iniciar Sesión</button>
                </div>
                <div class="form-group d-md-flex">
                  <div class="w-50">
                    <label class="checkbox-wrap checkbox-primary">Recuérdame
                      <input type="checkbox" checked>
                      <span class="checkmark"></span>
                    </label>
                  </div>
                  <div class="w-50 text-md-right">
                    <a href="#">Olvidé mi contraseña</a>
                  </div>
                </div>
              </form>
              <%
                }
              %>

            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- jQuery, Popper.js, Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

  </body>
</html>
