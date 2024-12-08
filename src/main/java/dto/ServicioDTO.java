package dto;

import java.sql.Date;
import java.time.LocalDate;

public class ServicioDTO {
    private Integer dniCliente;
    private String nomCliente;
    private Integer telefonoCliente;
    private String marca;
    private String modelo;
    private LocalDate fechaIngreso;
    private String reporCliente;
    private String estadoServicio;
    
    
    
	public ServicioDTO(Integer dniCliente, String nomCliente, Integer telefonoCliente, String marca, String modelo,
			LocalDate fechaIngreso, String reporCliente, String estadoServicio) {
		super();
		this.dniCliente = dniCliente;
		this.nomCliente = nomCliente;
		this.telefonoCliente = telefonoCliente;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaIngreso = fechaIngreso;
		this.reporCliente = reporCliente;
		this.estadoServicio = estadoServicio;
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
    
    
    
    
    
    
    
    // Constructor, Getters y Setters
}