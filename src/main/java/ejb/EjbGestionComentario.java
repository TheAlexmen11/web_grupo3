package ejb;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import web_grupo3jpa.Comentario;

@Stateless
@LocalBean
public class EjbGestionComentario {

	@PersistenceContext(unitName = "web_grupo3jpa")
	private EntityManager em;
	
    public EjbGestionComentario() {
        // TODO Auto-generated constructor stub
    }
    
    public void registrarComentario(Comentario nuevo) {
		System.out.println("registrarEstudiante");
		em.persist(nuevo);
	}

}
