
<%@page import="web_grupo3jpa.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>      

<%
    if (request.getAttribute("usuarios") == null) {
        response.sendRedirect("ServletUsuarioConsultar");
    } else {
        List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
        }
%> 
      
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Soporte Tecnico - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="dashboard.jsp">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">S.T. Admin</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Interface
            </div>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="dash_usuario.jsp">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Usuarios</span></a>
            </li>


            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="dash_cliente.jsp">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Clientes</span></a>
            </li>


            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="dash_product.jsp">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Productos</span></a>
            </li>



            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Addons
            </div>


            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseService"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Servicios</span>
                </a>
                <div id="collapseService" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Servicios:</h6>
                        <a class="collapse-item" href="tables.html">Servicios</a>
                        <a class="collapse-item" href="tables.html">Equipos</a>
                    </div>
                </div>
            </li>


            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseVentas"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Ventas</span>
                </a>
                <div id="collapseVentas" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Ventas:</h6>
                        <a class="collapse-item" href="tables.html">Productos</a>
                        <a class="collapse-item" href="tables.html">Equipos</a>
                    </div>
                </div>
            </li>



            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search -->
                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>

                        
                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 ">Usuario</span>
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Settings
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">





                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3 d-sm-flex  justify-content-between">
                            <h6 class="m-0 font-weight-bold text-primary">Lista de Usuarios</h6>

                            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm " data-bs-toggle="modal" data-bs-target="#exampleModal"><i
                                class="fas fa-download fa-sm text-white-50"></i>  Nuevo Usuario</a>
                                              
                                
                                <!-- Modal -->
                                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                              <h5 class="modal-title" id="exampleModalLabel"></h5>
                                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                              <div id="message"></div>
                                              <form id="user-form"   action="ServletUsuarioRegistro"  method="POST">
                                                <div class="mb-2">
                                                  <label for="recipient-name" class="col-form-label">Nombre Completo:</label>
                                                  <input type="text" class="form-control" id="nom_user" name="nom_user">
                                                </div>
                                                <div class="mb-2">
                                                  <label for="recipient-name" class="col-form-label">Username:</label>
                                                  <input type="text" class="form-control" id="username" name="username">
                                                </div>
                                                <div class="mb-2">
                                                  <label for="recipient-name" class="col-form-label">Contraseña:</label>
                                                  <input type="password" class="form-control" id="password" name="password">
                                                </div>
                                                <div class="mb-2" id="roles">
                                                  <label class="col-form-label">Rol</label>
                                                  <select class="form-select" name="role_user" id="role_user">
                                                    <option value="" selected="">Seleccionar Rol</option>
                                                    
                                                    <option value="Administrador">Administrador</option>
                                                    <option value="Tecnico">Tecnico</option>
                                                    
                                                  </select>
                                                </div>

                                                <input type="hidden" id="user_id" name="user_id">
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                                    <button type="submit" class="btn btn-primary">Guardar</button>
                                                  </div>
                                              </form>
                                            </div>

                                          </div>
                                    </div>
                                </div>
                                
                                
                                                                
                                <!-- Modal -->
                                <div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                              <h5 class="modal-title" id="exampleModalLabel"></h5>
                                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                              <div id="message"></div>
                                              <form id="user-form"   action="ServletUsuarioActualizar"  method="POST">
                                                <div class="mb-2">
                                                  <label for="recipient-name" class="col-form-label">Nombre Completo:</label>
                                                  <input type="text" class="form-control" id="nom_user1" name="nom_user1">
                                                </div>
                                                <div class="mb-2">
                                                  <label for="recipient-name" class="col-form-label">Username:</label>
                                                  <input type="text" class="form-control" id="username1" name="username1">
                                                </div>
                                                <div class="mb-2">
                                                  <label for="recipient-name" class="col-form-label">Contraseña:</label>
                                                  <input type="password" class="form-control" id="password1" name="password1">
                                                </div>
                                                <div class="mb-2" id="roles">
                                                  <label class="col-form-label">Rol</label>
                                                  <select class="form-select" name="role_user1" id="role_user1">
                                                    <option value="" selected="">Seleccionar Rol</option>
                                                    
                                                    <option value="Administrador">Administrador</option>
                                                    <option value="Tecnico">Tecnico</option>
                                                    
                                                  </select>
                                                </div>

                                                <input type="hidden" id="user_id1" name="user_id1" value="">
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                                    <button type="submit" class="btn btn-primary">Actualizar</button>
                                                  </div>
                                              </form>
                                            </div>

                                          </div>
                                    </div>
                                </div>
                                
                        </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

                                    <thead>
                                        <tr>
                                            <th>Nombre</th>
                                            <th>Username</th>
                                            <th>Rol</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                    <c:if test="${empty usuarios}">
    <p>No hay usuarios disponibles para mostrar.</p>
</c:if>
                                    
<c:forEach items="${usuarios}" var="u">
                                        <tr>

<td><c:out value="${u.nomUser}"/></td>
<td><c:out value="${u.username}"/></td>
<td><c:out value="${u.rolUser}"/></td>

                                            <td>
                                            
<button type="button" class="btn btn-info btn-icon-split" onclick="fetchUserData(${u.idUser})">
    <span class="icon text-white">
        <i class="fas fa-info-circle"></i>
    </span>
    <span class="text">Editar</span>
</button>


                                                
<form action="ServletUsuarioEliminar" method="post" style="display:inline;">
                    <input type="hidden" name="idToDelete" value="${u.idUser}"/>
                    <button type="submit" class="btn btn-danger btn-icon-split">
                        <span class="icon text-white">
                            <i class="fas fa-trash"></i>
                        </span>
                        <span class="text">Eliminar</span>
                    </button>
                    </form>

                                            </td>
                                        </tr>
</c:forEach>


                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>


                    
                </div>

                
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    
    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.jsp">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>



    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>
    
    
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <script>
  function fetchUserData(userId) {
	    console.log("Función llamada con el ID de usuario: " + userId);
    // Usamos AJAX para hacer una solicitud GET al servidor
    $.ajax({
      url: 'ServletUsuarioConsultarId',  // Aquí va el Servlet o JSP que manejará la consulta
      type: 'GET',
      data: { id: userId },  // Pasamos la ID del usuario al servidor
      success: function(data) {
    	  var userData = data.split(",");
    	  $('#user_id1').val(userData[0]);
    	  $('#nom_user1').val(userData[1]);
          $('#username1').val(userData[2]);
          $('#password1').val(userData[3]);
          $('#role_user1').val(userData[4]); 
		console.log(data);
        // Mostramos el modal
        console.log("Función llamada con el ID de usuario: " + userData[3]);
        var myModal = new bootstrap.Modal(document.getElementById('exampleModal1'), {});
        myModal.show();
      },
      error: function(err) {
       console.log("Error al obtener los datos del usuario", err);
     }
    });
  }
</script>
    
    

</body>

</html>