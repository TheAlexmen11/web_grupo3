package ejb;

import java.util.List;

import dto.ServicioDTO;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import web_grupo3jpa.DetalleServicio;
import web_grupo3jpa.EquipoServicio;
import web_grupo3jpa.ImagenesServicio;


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
    
    public ServicioDTO obtenerInformacionServicioPorId(int idEquipo) {
        String jpql = "SELECT c.dniCliente, c.nomCliente, c.telefonoCliente, e.marca, e.modelo, d.fechaIngreso, d.reporCliente, d.estadoServicio "
        		+ "FROM Cliente c "
        		+ "JOIN c.equipoServicios e "
        		+ "JOIN e.detalleServicios d "
        		+ "WHERE e.idEquipo = :idEquipo";

        TypedQuery<ServicioDTO> query = em.createQuery(jpql, ServicioDTO.class);
        query.setParameter("idEquipo", idEquipo);

        return query.getSingleResult();
    }
    
    
    public void crearServicio(DetalleServicio detalleServicio, EquipoServicio equipo, List<ImagenesServicio> imagenes) {

        em.persist(equipo);

        detalleServicio.setEquipoServicio(equipo);
        em.persist(detalleServicio);

        
        for (ImagenesServicio imagen : imagenes) {
            imagen.setEquipoServicio(equipo);
            System.out.println("agregando imagen : "+ imagen.getRutaImagen());
            em.persist(imagen);
        }
    }

}
