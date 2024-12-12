package ejb;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import dto.ServicioDTO;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import web_grupo3jpa.DetalleServicio;
import web_grupo3jpa.EquipoServicio;
import web_grupo3jpa.ImagenesServicio;

@Path("gestionServicio")
@Stateless
@LocalBean
public class EjbGestionServicio {

	@PersistenceContext(unitName = "web_grupo3jpa")
	private EntityManager em;
	
    public EjbGestionServicio() {
        // TODO Auto-generated constructor stub
    }
    
    
	@GET
    @Path("obtenerServicio")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ServicioDTO> obtenerInformacionServicio() {
        String jpql = "SELECT "
                + "c.dniCliente, "
                + "c.nomCliente, "
                + "c.telefonoCliente, "
                + "d.idDetalle, "
                + "e.marca, "
                + "e.modelo, "
                + "d.fechaIngreso, "
                + "d.reporCliente, "
                + "d.estadoServicio, "
                + "e.idEquipo, "
                + "d.fechaIngreso "
                + "FROM Cliente c "
                + "JOIN c.equipoServicios  e "
                + "JOIN e.detalleServicios d";

        TypedQuery<ServicioDTO> query = em.createQuery(jpql, ServicioDTO.class);
        return query.getResultList();
        
        }
    
	
	
	@GET
    @Path("obtenerServicioPorId")
    @Produces(MediaType.APPLICATION_JSON)
    public ServicioDTO obtenerInformacionServicioPorId(@QueryParam(value = "idEquipo") int idEquipo) {
        String jpql = "SELECT c.dniCliente, c.nomCliente, c.telefonoCliente,d.idDetalle, e.marca, e.modelo, d.fechaIngreso, d.reporCliente, d.estadoServicio,e.idEquipo, d.fechaIngreso "
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
    
    
    public void actualizarEstado(Integer idDetalle, String informeFinal, BigDecimal precio) {

        DetalleServicio detalleServicio = em.find(DetalleServicio.class, idDetalle);
        
        if (detalleServicio != null) {
            detalleServicio.setInfFinal(informeFinal);
            detalleServicio.setPrecio(precio);
            detalleServicio.setEstadoServicio("en revision");

            em.merge(detalleServicio);
        }
    }
    
    
	@GET
    @Path("finalizarEstadoReparacion")
    @Produces(MediaType.APPLICATION_JSON) 	
    public void finalizarEstadoReparacion(@QueryParam(value = "idDetalle") Integer idDetalle) {

        DetalleServicio detalleServicio = em.find(DetalleServicio.class, idDetalle);
        
        if (detalleServicio != null) {
        	LocalDate fechaTermino = LocalDate.now(); 
            detalleServicio.setFechaTermino(fechaTermino);
            detalleServicio.setEstadoServicio("finalizado");
            em.merge(detalleServicio);
        }
    }
    
    
    
    @Transactional
    public void eliminarServicioTecnico(int idEquipo) {

        EquipoServicio equipoServicio = em.find(EquipoServicio.class, idEquipo);
        
        if (equipoServicio != null) {

            for (ImagenesServicio imagen : equipoServicio.getImagenesServicios()) {
                em.remove(imagen);
            }
            

            for (DetalleServicio detalle : equipoServicio.getDetalleServicios()) {
                em.remove(detalle);
            }
            
            em.remove(equipoServicio);
        }
    }

}
