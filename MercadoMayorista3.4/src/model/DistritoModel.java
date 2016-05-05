package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entidades.Distrito;

public class DistritoModel {

	public static EntityManagerFactory emf =	
			Persistence.createEntityManagerFactory("DAW2-Semana03-Generacion");
			

	public void inserta(Distrito p){
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
	
	public List<Distrito> listaDistrito(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<Distrito> q = manager.createQuery("select c from Distrito c ",	Distrito.class);
														
		return q.getResultList();
	}
	
	
}









