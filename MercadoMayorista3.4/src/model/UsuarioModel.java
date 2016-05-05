package model;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import entidades.Usuario;

public class UsuarioModel {

	public static EntityManagerFactory emf =	
			Persistence.createEntityManagerFactory("DAW2-Semana03-Generacion");

	
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> obtenerPermisos(Map<String, Object> map)throws Exception {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT p.id, p.rol, p.url, p.opcion FROM Permiso p, Rol r	where p.rol = r.id	and r.id = :rol", Map.class);
		q.setParameter("rol", map.get("rol"));
		List<Map<String, Object>> salida = q.getResultList();		
		em.close();
		return salida;
	}

	@SuppressWarnings("unchecked")
	
	public List<Usuario> validarUsuario(Map<String, Object> map)	throws Exception {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT u FROM Usuario u	where u.usuario = :usuario	and u.clave = :clave");
		q.setParameter("usuario", map.get("usuario"));
		q.setParameter("clave", map.get("clave"));    
		List<Usuario> lista = q.getResultList();
		em.close();
		return lista;
	}

	
	public void inserUsuario(Usuario p){
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(p);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally{
			manager.close();
		}
	}
	
	
	public void eliminaUsuario(Usuario p){
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			//manager.find --> es como select por ID
			Usuario aux = manager.find(Usuario.class, p.getUsuario());
			manager.getTransaction().begin();
			manager.remove(aux);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally{
			manager.close();
		}
	}
	
	
	public void actualiza(Usuario p){
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(p);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally{
			manager.close();
		}
	}
	
 
	public List<Usuario> listaUsuario(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<Usuario> q = manager.createQuery("select c from Usuario c",
				Usuario.class);
		return q.getResultList();
	}	
	
}
