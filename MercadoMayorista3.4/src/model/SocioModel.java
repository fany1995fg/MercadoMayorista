package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entidades.Socio;

public class SocioModel {

	public static EntityManagerFactory emf =	
			Persistence.createEntityManagerFactory("DAW2-Semana03-Generacion");

	public void insertaSocio(Socio p){
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
	
	
	public void elimina(Socio p){
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			//manager.find --> es como select por ID
			Socio aux = manager.find(Socio.class, p.getIdsocio());
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
	
	
	public void actualiza(Socio p){
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
	
 
	
	
	public List<Socio> listaSocio(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<Socio> q = manager.createQuery("select c from Socio c",
																Socio.class);
		return q.getResultList();
	}	
	
}
