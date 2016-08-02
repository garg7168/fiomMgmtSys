package com.flp.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.flp.ems.domain.Actor;
import com.flp.ems.domain.Film;


public class ActorDaoImpl implements IActorDao{

	public void addActor(Actor actor) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");  
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction().begin();
		entitymanager.persist(actor);
		entitymanager.getTransaction( ).commit( );
		
	}

	public Actor modifyActor(Actor actor) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");  
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction().begin();
		entitymanager.merge(actor);
		entitymanager.getTransaction( ).commit( );
		return actor;
	}

	public boolean removeActor(int actorId) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		Actor actor = entitymanager.find( Actor.class, actorId );
		if(actor!=null)
		{
			entitymanager.remove( actor );
			entitymanager.getTransaction( ).commit( );
			
			return true;
		}
		else
		{
			return false;
		}	
	}

	public Actor searchActor(int actorId) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");
	      EntityManager entitymanager = emfactory.createEntityManager();
		Actor actor = entitymanager.find( Actor.class, actorId );
		return actor;
	}

	public List<Actor> getAllActor() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FMS");
	      EntityManager entitymanager = emfactory.createEntityManager();
		TypedQuery<Actor> query = entitymanager.createQuery("Select f from Actor f",Actor.class);
		return query.getResultList();
	}
	

}
	
	
