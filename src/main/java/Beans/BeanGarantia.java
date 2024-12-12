package Beans;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import dto.ServicioDTO;
import ejb.EjbGestionServicio;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@Named
@SessionScoped
public class BeanGarantia implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idEquipo;
	private ServicioDTO resultados;
	private String mensajeGarantia;  
    private long diasRestantes;
	
	@Inject
	private EjbGestionServicio ejb;
	
    public BeanGarantia() {
        
    }
    
    
    @PostConstruct
    public void init() {
    	resultados = null;
    	idEquipo = 0;
    	
    }
    
    
    public void buscarEquipoServicio() throws IOException {
    	System.out.println(idEquipo);
    	
    	try {
    		resultados = ejb.obtenerInformacionServicioPorId(idEquipo);
		} catch (Exception e) {
			System.out.println("No se encontró información para el ID: ");		
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al consultar", "No se encontró información para el ID proporcionado.");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			}
    	
    	
        if (resultados != null) {
        	System.out.println("Datos encontrados: " + resultados);
        	System.out.println(resultados.getEstadoServicio().equals("finalizado"));
        	if(resultados.getEstadoServicio().equals("finalizado")) {
        		System.out.println(resultados.getEstadoServicio() +"ingreso");
        		calcularGarantia(resultados.getFechaTermino());
                FacesContext.getCurrentInstance().getExternalContext().redirect("informacion_garantia.xhtml");
        	}else {
        		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El equipo no ha sido finalizado", "No se encontró información para el ID proporcionado.");
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        	}
        } else {
            System.out.println("No se encontró información para el ID: " + idEquipo);
        }
    }
    
    
    private void calcularGarantia(LocalDate fechaTermino) {
        LocalDate fechaActual = LocalDate.now();
        
        if (fechaTermino != null) {
        	setDiasRestantes(ChronoUnit.DAYS.between(fechaTermino, fechaActual));
            
            System.out.println(fechaTermino); 
            System.out.println(fechaActual); 
            System.out.println(getDiasRestantes()); 
            
            if (getDiasRestantes() > 30) {
                setMensajeGarantia("Garantia expirada");
            } else {
                setMensajeGarantia("En garantia"); 
            }
        } else {
            setMensajeGarantia("Fecha de término no válida"); 
        }
    }

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public ServicioDTO getResultados() {
		return resultados;
	}

	public void setResultados(ServicioDTO resultados) {
		this.resultados = resultados;
	}

	public String getMensajeGarantia() {
		return mensajeGarantia;
	}

	public void setMensajeGarantia(String mensajeGarantia) {
		this.mensajeGarantia = mensajeGarantia;
	}

	public long getDiasRestantes() {
		return diasRestantes;
	}

	public void setDiasRestantes(long diasRestantes) {
		this.diasRestantes = diasRestantes;
	}


}
