package ejb;

import java.util.Collections;
import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import web_grupo3jpa.Producto;

@Stateless
@LocalBean
public class EjbGestionProducto {

    @PersistenceContext(unitName = "web_grupo3jpa")
    private EntityManager em;

    public EjbGestionProducto() {
    	// TODO Auto-generated constructor stub
    }

    public void registrarProducto(Producto nuevo) {
        System.out.println("Registrando nuevo producto: " + nuevo.getTipoProduct());
        em.persist(nuevo);
    }

    public List<Producto> listarProductos() {
        try {
            return em.createNamedQuery("Producto.findAll", Producto.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    
    public void eliminarProducto(int id) {
        Producto p = em.find(Producto.class, id);
        if (p != null) {
            em.remove(p);
            System.out.println("Producto eliminado: " + id);
        } else {
            System.out.println("Producto no encontrado para eliminar: " + id);
        }
    }

    public Producto consultarPorId(int id) {
        Producto p = em.find(Producto.class, id);
        if (p != null) {
            System.out.println("Producto encontrado: " + p.getTipoProduct());
        } else {
            System.out.println("Producto no encontrado: " + id);
        }
        return p;
    }

    public void actualizarProducto(Producto producto) {
        System.out.println("Actualizando producto: " + producto.getIdProduct());
        em.merge(producto);
    }

    public Producto obtenerProductoPorId(int id) {
        return em.find(Producto.class, id);
    }
}