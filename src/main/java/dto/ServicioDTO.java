package dto;

import java.sql.Date;
import java.time.LocalDate;

public class ServicioDTO {
	
    private Integer dniCliente;
    private String nomCliente;
    private Integer telefonoCliente;
    private Integer idDetalle;
    private String marca;
    private String modelo;
    private LocalDate fechaIngreso;
    private String reporCliente;
    private String estadoServicio;
    private Integer idEquipo;
    private LocalDate fechaTermino;
    

	public ServicioDTO(Integer dniCliente, String nomCliente, Integer telefonoCliente, Integer idDetalle, String marca,
			String modelo, LocalDate fechaIngreso, String reporCliente, String estadoServicio, Integer idEquipo,
			LocalDate fechaTermino) {
		super();
		this.dniCliente = dniCliente;
		this.nomCliente = nomCliente;
		this.telefonoCliente = telefonoCliente;
		this.idDetalle = idDetalle;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaIngreso = fechaIngreso;
		this.reporCliente = reporCliente;
		this.estadoServicio = estadoServicio;
		this.idEquipo = idEquipo;
		this.fechaTermino = fechaTermino;
	}
	public Integer getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(Integer dniCliente) {
		this.dniCliente = dniCliente;
	}
	public String getNomCliente() {
		return nomCliente;
	}
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}
	public Integer getTelefonoCliente() {
		return telefonoCliente;
	}
	public void setTelefonoCliente(Integer telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
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
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getReporCliente() {
		return reporCliente;
	}
	public void setReporCliente(String reporCliente) {
		this.reporCliente = reporCliente;
	}
	public String getEstadoServicio() {
		return estadoServicio;
	}
	public void setEstadoServicio(String estadoServicio) {
		this.estadoServicio = estadoServicio;
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
	public LocalDate getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(LocalDate fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
    
    
    
    
    
    
    
    // Constructor, Getters y Setters
}