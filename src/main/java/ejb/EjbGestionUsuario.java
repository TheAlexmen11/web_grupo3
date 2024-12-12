package ejb;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import web_grupo3jpa.EquipoServicio;
import web_grupo3jpa.Usuario;

@Path("gestionUsuario")
@Stateless
@LocalBean
public class EjbGestionUsuario {

	@PersistenceContext(unitName = "web_grupo3jpa")
	private EntityManager em;

	
    public EjbGestionUsuario() {
        // TODO Auto-generated constructor stub
    }
    
    @POST
    @Path("registrarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public void registrarUsuario(Usuario nuevo) {
		System.out.println("registrarEstudiante");
		em.persist(nuevo);
	}
	
	@POST
	@Path("listarUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listarUsuarios() {
    	TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAll", Usuario.class);
        return query.getResultList(); 
        
        }
    
    
    
	public void eliminarEstudiante(int id) {
		Usuario e = em.find(Usuario.class, id);
		em.remove(e);
	}
	
	
	@GET
    @Path("consultarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
	public Usuario consultarPorId(@QueryParam(value = "idUser") int id) {
		Usuario e = em.find(Usuario.class, id);
		return e;
	}
	
	
	public void actualizarUsuario(Usuario nuevo) {
		em.merge(nuevo);
	}
	
	
	public Usuario obtenerUsuarioPorId(int parameter) {
        return em.find(Usuario.class, parameter);  
	}
}
