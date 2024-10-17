package ejb;

import java.util.List;

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
    
    public List<Object[]> obtenerInformacionServicio() {
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

        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        return query.getResultList();
        
        }

}
