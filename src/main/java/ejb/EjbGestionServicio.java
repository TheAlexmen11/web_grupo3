package ejb;

import java.util.List;

import dto.ServicioDTO;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


@Stateless
@LocalBean
public class EjbGestionServicio {

	@PersistenceContext(unitName = "web_grupo3jpa")
	private EntityManager em;
	
    public EjbGestionServicio() {
        // TODO Auto-generated constructor stub
    }
    
    public List<ServicioDTO> obtenerInformacionServicio() {
        String jpql = "SELECT "
                + "c.dniCliente, "
                + "c.nomCliente, "
                + "c.telefonoCliente, "
                + "e.marca, "
                + "e.modelo, "
                + "d.fechaIngreso, "
                + "d.reporCliente, "
                + "d.estadoServicio "
                + "FROM Cliente c "
                + "JOIN c.equipoServicios  e "
                + "JOIN e.detalleServicios d";

        TypedQuery<ServicioDTO> query = em.createQuery(jpql, ServicioDTO.class);
        return query.getResultList();
        
        }

}
