package Beans;

import java.io.Serializable;
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
import jakarta.faces.model.SelectItem;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import web_grupo3jpa.Cliente;
import web_grupo3jpa.Usuario;

/**
 * Session Bean implementation class BeanServicio
 */
@Named
@RequestScoped
public class BeanServicio implements Serializable {
	private static final long serialVersionUID = 1L;
	private int usuarios;
	private int cliente;
	
	@Inject
	private EjbGestionServicio ejb;
	@Inject
	private EjbGestionUsuario ejbU;
	@Inject
	private EjbGestionCliente ejbC;

    private List<ServicioDTO> resultados;
    private List<SelectItem> itemUsuario;
    private List<SelectItem> itemCliente;

    
 // Variables para fecha
    private Date fechaIngreso;

    // Variables para equipos recepcionados
    private String marca;
    private String modelo;
    private String serie;
    private String procesador;
    private String memoria;
    private String disco;
    private String mainboard;
    private String tarjetaVideo;

    // Variables para detalles de servicio
    private String reporteCliente;
    private String informeInicial;
    private String foto;

    
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
    
    
	public void registrar() {
		System.out.println("registrar");
		System.out.println("cliente seleccionada: "+cliente);
		System.out.println("fecha : "+fechaIngreso);
		System.out.println("usuario seleccionado: "+usuarios);
		System.out.println("marca : "+marca);
		System.out.println("modelo : "+modelo);
		System.out.println("serie : "+serie);
		System.out.println("procesador : "+procesador);
		System.out.println("memoria : "+memoria);
		System.out.println("disco : "+disco);
		System.out.println("mainboard : "+mainboard);
		System.out.println("t.video : "+tarjetaVideo);
		System.out.println("reporte cliente : "+reporteCliente);
		System.out.println("informe inicial : "+reporteCliente);
		System.out.println("fotos : "+foto);
	}
    

	public int getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(int usuarios) {
		this.usuarios = usuarios;
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

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
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


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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
    
    
    
}
