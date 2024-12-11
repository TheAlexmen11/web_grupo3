package Beans;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.ServicioDTO;
import ejb.EjbGestionCliente;
import ejb.EjbGestionServicio;
import ejb.EjbGestionUsuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import web_grupo3jpa.Cliente;
import web_grupo3jpa.DetalleServicio;
import web_grupo3jpa.EquipoServicio;
import web_grupo3jpa.ImagenesServicio;
import web_grupo3jpa.Usuario;

/**
 * Session Bean implementation class BeanServicio
 */
@Named
@RequestScoped
public class BeanServicio implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id_usuario;
	private int id_cliente;
	
	@Inject
	private EjbGestionServicio ejb;
	@Inject
	private EjbGestionUsuario ejbU;
	@Inject
	private EjbGestionCliente ejbC;

	@PersistenceContext(unitName = "web_grupo3jpa")
	private EntityManager em;
	
    private List<ServicioDTO> resultados;
    private List<SelectItem> itemUsuario;
    private List<SelectItem> itemCliente;

    
    
 // Variables para fecha
    private Integer idDetalle;
    private String fechaIngreso;
    private String marca;
    private String modelo;
    private String serie;
    private String procesador;
    private String memoria;
    private String disco;
    private String mainboard;
    private String tarjetaVideo;
    private String reporteCliente;
    private String informeInicial;
    private String informeFinal;
    private String foto;
    private String fuente;
    private String bateria;
    private String otros;
    private String cargador;
    private BigDecimal precio;
    private Integer idEquipo;
   
	@PostConstruct
    public void init() {
    	itemUsuario = new ArrayList();
    	itemCliente = new ArrayList();
    	SelectItem u = null;
    	SelectItem c = null;
        System.out.println("PostConstruct ejecutado");
        resultados = ejb.obtenerInformacionServicio();
        List<Usuario> usr = ejbU.listarUsuarios();
        for( Usuario user : usr) {
        	u = new SelectItem(user.getIdUser(),user.getNomUser());
        	itemUsuario.add(u);
        }
        List<Cliente> clientes = ejbC.listarClientes();
        for( Cliente client : clientes) {
        	c = new SelectItem(client.getIdCliente(),client.getNomCliente());
        	itemCliente.add(c);
        }        
    }
    
    
	@Override
	public String toString() {
		return "BeanServicio [usuarios=" + id_usuario + ", cliente=" + id_cliente 
				+ ", fechaIngreso=" + fechaIngreso
				+ ", marca=" + marca + ", modelo=" + modelo + ", serie=" + serie + ", procesador=" + procesador
				+ ", memoria=" + memoria + ", disco=" + disco + ", mainboard=" + mainboard + ", tarjetaVideo="
				+ tarjetaVideo + ", reporteCliente=" + reporteCliente + ", informeInicial=" + informeInicial + ", foto="
				+ foto + ", fuente=" + fuente + ", bateria=" + bateria + ", otros=" + otros + ", cargador=" + cargador
				+ ", precio=" + precio + "]";
	}


	public void registrar() {
		Usuario usuario = em.find(Usuario.class, id_usuario);
		Cliente cliente = em.find(Cliente.class, id_cliente);
		LocalDate fechaIngresoF = LocalDate.parse(fechaIngreso, DateTimeFormatter.ISO_DATE);
        EquipoServicio equipo = new EquipoServicio();
        equipo.setMarca(marca);
        equipo.setModelo(modelo);
        equipo.setSerie(serie);
        equipo.setProcesador(procesador);
        equipo.setMemoria(memoria);
        equipo.setDisco(disco);
        equipo.setMainboard(mainboard);
        equipo.setTVideo(tarjetaVideo);
        equipo.setFuente(fuente);
        equipo.setCargador(cargador);
        equipo.setBateria(bateria);
        equipo.setOtros(otros);
        equipo.setUsuario(usuario);
        equipo.setCliente(cliente);

        DetalleServicio detalle = new DetalleServicio();
        detalle.setFechaIngreso(fechaIngresoF);
        detalle.setReporCliente(reporteCliente);
        detalle.setInfInicial(informeInicial);
        detalle.setPrecio(precio);
        detalle.setEstadoServicio("pendiente");

        List<ImagenesServicio> imagenes = new ArrayList<>();
        ImagenesServicio imagen = new ImagenesServicio();
        imagen.setRutaImagen(foto);
        imagenes.add(imagen);
        ejb.crearServicio(detalle, equipo, imagenes);
		System.out.println(toString());
		recargarPagina("/dash_servicio.xhtml");
	}
    
	public void actualizarEstado() {
		System.out.println(idDetalle);
		System.out.println(informeFinal);
		System.out.println(precio);
		
		ejb.actualizarEstado(idDetalle, informeFinal, precio);
		recargarPagina("/dash_terminar_servicio.xhtml");
	}
	public void recargarPagina(String url) {
	    try {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        ExternalContext externalContext = facesContext.getExternalContext();
	        externalContext.redirect(externalContext.getRequestContextPath() + url);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	public void finalizarReparacion() {
		System.out.println(idDetalle);
		ejb.finalizarEstadoReparacion(idDetalle);
		recargarPagina("/dash_terminar_servicio.xhtml");
	}
	
	public void eliminarServicio() {
		System.out.println(idEquipo);
		ejb.eliminarServicioTecnico(idEquipo);
		recargarPagina("/dash_servicio.xhtml");
	}
    
    public String getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public String getFuente() {
		return fuente;
	}


	public void setFuente(String fuente) {
		this.fuente = fuente;
	}


	public String getBateria() {
		return bateria;
	}


	public void setBateria(String bateria) {
		this.bateria = bateria;
	}


	public String getOtros() {
		return otros;
	}


	public void setOtros(String otros) {
		this.otros = otros;
	}


	public String getCargador() {
		return cargador;
	}


	public void setCargador(String cargador) {
		this.cargador = cargador;
	}


    public int getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(int id_usuarios) {
		this.id_usuario = id_usuarios;
	}


	public int getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}


	public List<ServicioDTO> getResultados() {
        return resultados;
    }

    public List<SelectItem> getItemUsuario() {
        return itemUsuario;
    }

	public List<SelectItem> getItemCliente() {
		return itemCliente;
	}

	public void setItemCliente(List<SelectItem> itemCliente) {
		this.itemCliente = itemCliente;
	}



	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getSerie() {
		return serie;
	}


	public void setSerie(String serie) {
		this.serie = serie;
	}


	public String getProcesador() {
		return procesador;
	}


	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}


	public String getReporteCliente() {
		return reporteCliente;
	}


	public void setReporteCliente(String reporteCliente) {
		this.reporteCliente = reporteCliente;
	}


	public void setResultados(List<ServicioDTO> resultados) {
		this.resultados = resultados;
	}




	public String getInformeInicial() {
		return informeInicial;
	}


	public void setInformeInicial(String informeInicial) {
		this.informeInicial = informeInicial;
	}




	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public String getMemoria() {
		return memoria;
	}


	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}


	public String getDisco() {
		return disco;
	}


	public void setDisco(String disco) {
		this.disco = disco;
	}


	public String getMainboard() {
		return mainboard;
	}


	public void setMainboard(String mainboard) {
		this.mainboard = mainboard;
	}


	public String getTarjetaVideo() {
		return tarjetaVideo;
	}


	public void setTarjetaVideo(String tarjetaVideo) {
		this.tarjetaVideo = tarjetaVideo;
	}


	public BigDecimal getPrecio() {
		return precio;
	}


	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


	public String getInformeFinal() {
		return informeFinal;
	}


	public void setInformeFinal(String informeFinal) {
		this.informeFinal = informeFinal;
	}


	public Integer getIdDetalle() {
		return idDetalle;
	}


	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}


	public Integer getIdEquipo() {
		return idEquipo;
	}


	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}



    
    
    
}
