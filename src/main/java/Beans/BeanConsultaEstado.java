package Beans;

import java.io.Serializable;
import java.util.List;

import dto.ServicioDTO;
import ejb.EjbGestionServicio;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Session Bean implementation class BeanConsultaEstado
 */
@Named
@SessionScoped
public class BeanConsultaEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idEquipo;
	private ServicioDTO resultados;
	
	@Inject
	private EjbGestionServicio ejb;
	
    public BeanConsultaEstado() {
        // TODO Auto-generated constructor stub
    }
    
    public void buscarEquipoServicio() {
    	System.out.println(idEquipo);
    	
    	try {
			setResultados(ejb.obtenerInformacionServicioPorId(idEquipo));
		} catch (Exception e) {
			System.out.println("No se encontró información para el ID: ");		
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al consultar", "No se encontró información para el ID proporcionado.");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			}
    	
    	
        if (resultados != null) {
        	System.out.println("Datos encontrados: " + resultados);
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("informacion_equipo.xhtml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            
            System.out.println("No se encontró información para el ID: " + idEquipo);
        }
    }
    
	public String irPaginaConsulta() {
		System.out.println("se llamo a cambio de pagina");
		this.idEquipo = 0;
        this.resultados = null;
		return "consultar_estado";
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
    

}
