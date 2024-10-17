package ejb;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import web_grupo3jpa.Usuario;


@Stateless
@LocalBean
public class EjbGestionUsuario {

	@PersistenceContext(unitName = "web_grupo3jpa")
	private EntityManager em;
	
    public EjbGestionUsuario() {
        // TODO Auto-generated constructor stub
    }
	public void registrarUsuario(Usuario nuevo) {
		System.out.println("registrarEstudiante");
		em.persist(nuevo);
	}
	

    public List<Usuario> listarUsuarios() {
    	TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAll", Usuario.class);
        return query.getResultList(); 
        
        }
	public void eliminarEstudiante(int id) {
		Usuario e = em.find(Usuario.class, id);
		em.remove(e);
	}
	public Usuario consultarPorId(int id) {
		Usuario e = em.find(Usuario.class, id);
		return e;
	}
	public void actualizarUsuario(Usuario nuevo) {
		System.out.println("registrarEstudiante");
		em.merge(nuevo);
	}
	public Usuario obtenerUsuarioPorId(int parameter) {
		// TODO Auto-generated method stub
        return em.find(Usuario.class, parameter);  
	}
}
