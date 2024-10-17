package ejb;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import web_grupo3jpa.Cliente;
import web_grupo3jpa.Usuario;

/**
 * Session Bean implementation class EjbGestionCliente
 */
@Stateless
@LocalBean
public class EjbGestionCliente {

	@PersistenceContext(unitName = "web_grupo3jpa")
	private EntityManager em;
	
    public EjbGestionCliente() {
        // TODO Auto-generated constructor stub
    }
	public void registrarCliente(Cliente nuevo) {
		System.out.println("registrarEstudiante");
		em.persist(nuevo);
	}
	 public List<Cliente> listarClientes() {
	    	TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findAll",Cliente.class);
	        return query.getResultList(); 
	        
	        }


}
