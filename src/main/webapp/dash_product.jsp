<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="web_grupo3jpa.Producto" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<% if (request.getAttribute("productos") == null) { 
    response.sendRedirect("ServletProductoConsultar"); 
} else { 
    List<Producto> productos = (List<Producto>) request.getAttribute("productos"); 
} %>

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
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
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
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="dashboard.html">
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
            <div class="sidebar-heading"> Interface </div>

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
            <div class="sidebar-heading"> Addons </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseService" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Servicios</span>
                </a>
                <div id="collapseService" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Servicios:</h6>
                        <a class="collapse-item" href="dash_servicio.jsp">Servicios</a>
                        <a class="collapse-item" href="tables.html">Equipos</a>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseVentas" aria-expanded="true" aria-controls="collapsePages">
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

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 ">Usuario</span>
                                <img class="img-profile rounded-circle" src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> Settings
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i> Logout
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
                        <div class="card-header py-3 d-sm-flex justify-content-between">
                            <h6 class="m-0 font-weight-bold text-primary">Lista de Productos</h6>

                            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
							    <i class="fas fa-download fa-sm text-white-50"></i> Nuevo Producto
							</a>

                            <!-- Modal para agregar nuevo producto -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Nuevo Producto</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <div id="message"></div>
                                            <form id="producto-form">
                                                <div class="mb-2">
                                                    <label for="tipo_product" class="col-form-label">Tipo de Producto:</label>
                                                    <input type="text" class="form-control" id="tipo_product" name="tipo_product" required>
                                                </div>
                                                <div class="mb-2">
                                                    <label for="marca_product" class="col-form-label">Marca:</label>
                                                    <input type="text" class="form-control" id="marca_product" name="marca_product" required>
                                                </div>
                                                <div class="mb-2">
                                                    <label for="descripcion_product" class="col-form-label">Descripción:</label>
                                                    <textarea class="form-control" id="descripcion_product" name="descripcion_product" required></textarea>
                                                </div>
                                                <div class="mb-2">
                                                    <label for="img_product" class="col-form-label">Imagen:</label>
                                                    <input type="text" class="form-control" id="img_product" name="img_product" required>
                                                </div>
                                                <div class="mb-2">
                                                    <label for="precio_product" class="col-form-label">Precio:</label>
                                                    <input type="number" class="form-control" id="precio_product" name="precio_product" required>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                    <button type="submit" class="btn btn-primary">Agregar</button>
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
                                            <th>ID</th>
                                            <th>Tipo</th>
                                            <th>Marca</th>
                                            <th>Descripción</th>
                                            <th>Imagen</th>
                                            <th>Precio</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
									    <c:forEach var="producto" items="${productos}">
										    <tr>
										        <td>${producto.idProduct}</td>
										        <td>${producto.tipoProduct}</td>
										        <td>${producto.marcaProduct}</td>
										        <td>${producto.descripcion}</td>
										        <td><img src="${producto.imgProduct}" alt="Imagen de producto" width="50"></td>
										        <td>${producto.precio}</td>
										        <td>
										            <button class="btn btn-warning" onclick="editarProducto(${producto.idProduct}, '${producto.tipoProduct}', '${producto.marcaProduct}', '${producto.descripcion}', '${producto.imgProduct}', ${producto.precio})">Editar</button>
										            <button class="btn btn-danger" onclick="confirmarEliminacion(${producto.idProduct})">Eliminar</button>
										        </td>
										    </tr>
										</c:forEach>
									</tbody>

                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- End of Main Content -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="logoutModalLabel">¿Está seguro que desea salir?</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">Seleccione "Cerrar sesión" a continuación si está listo para finalizar su sesión actual.</div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <a class="btn btn-primary" href="logout">Cerrar sesión</a>
                    </div>
                </div>
            </div>
        </div>


		<!-- Modal Editar Producto -->
		<div class="modal fade" id="modalEditarProducto" tabindex="-1" aria-labelledby="modalEditarProductoLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <h5 class="modal-title" id="modalEditarProductoLabel">Editar Producto</h5>
		                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		            </div>
		            <div class="modal-body">
		                <form action="ServletProductoActualizar" method="POST">
		                    <div class="mb-2">
		                        <label for="tipo_product_edit" class="col-form-label">Tipo:</label>
		                        <input type="text" class="form-control" id="tipo_product_edit" name="tipo_product" required>
		                    </div>
		                    <div class="mb-2">
		                        <label for="marca_product_edit" class="col-form-label">Marca:</label>
		                        <input type="text" class="form-control" id="marca_product_edit" name="marca_product" required>
		                    </div>
		                    <div class="mb-2">
		                        <label for="descripcion_product_edit" class="col-form-label">Descripción:</label>
		                        <textarea class="form-control" id="descripcion_product_edit" name="descripcion_product" required></textarea>
		                    </div>
		                    <div class="mb-2">
		                        <label for="precio_product_edit" class="col-form-label">Precio:</label>
		                        <input type="text" class="form-control" id="precio_product_edit" name="precio_product" required>
		                    </div>
		                    <input type="hidden" id="id_product_edit" name="id_product">
		                    <div class="modal-footer">
		                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
		                        <button type="submit" class="btn btn-primary">Actualizar</button>
		                    </div>
		                </form>
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
		
		<script>
			$(document).ready(function() {
			    // Función para agregar un producto
			    $('#save-product').on('click', function() {
			        $.ajax({
			            type: 'POST',
			            url: 'ServletProductoAgregar',
			            data: $('#producto-form').serialize(),
			            success: function(response) {
			                location.reload();
			            },
			            error: function(xhr, status, error) {
			                $('#message').html('<div class="alert alert-danger">Error al agregar producto.</div>');
			            }
			        });
			    });
			
			    // Función para editar un producto
			    $(document).on('click', '.btn-warning', function() {
			        const row = $(this).closest('tr');
			        $('#tipo_product_edit').val(row.find('td:nth-child(2)').text());
			        $('#marca_product_edit').val(row.find('td:nth-child(3)').text());
			        $('#descripcion_product_edit').val(row.find('td:nth-child(4)').text());
			        $('#img_product_edit').val(row.find('td:nth-child(5) img').attr('src'));
			        $('#precio_product_edit').val(row.find('td:nth-child(6)').text());
			        $('#id_product_edit').val(row.find('td:nth-child(1)').text());
			        $('#modalEditarProducto').modal('show');
			    });
			
			    // Función para actualizar un producto
			    $('#modalEditarProducto form').on('submit', function(e) {
			        e.preventDefault(); // Evita el envío del formulario de forma tradicional
			        $.ajax({
			            type: 'POST',
			            url: 'ServletProductoActualizar',
			            data: $(this).serialize(),
			            success: function(response) {
			                location.reload();
			            },
			            error: function(xhr, status, error) {
			                alert('Error al actualizar el producto.');
			            }
			        });
			    });
			
			    // Función para eliminar un producto
			    $(document).on('click', '.btn-danger', function() {
			        if (confirm('¿Estás seguro de que quieres eliminar este producto?')) {
			            const id = $(this).closest('tr').find('td:nth-child(1)').text();
			            $.ajax({
			                type: 'POST',
			                url: 'ServletProductoEliminar',
			                data: { id_product: id },
			                success: function(response) {
			                    location.reload();
			                },
			                error: function(xhr, status, error) {
			                    alert('Error al eliminar el producto.');
			                }
			            });
			        }
			    });
			});
			</script>

    </div>
    <!-- End of Wrapper -->

</body>

</html>
