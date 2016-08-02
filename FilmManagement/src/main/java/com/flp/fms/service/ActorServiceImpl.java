package com.flp.fms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.flp.ems.domain.Actor;
import com.flp.fms.dao.ActorDaoImpl;
import com.flp.fms.dao.IActorDao;


public class ActorServiceImpl implements IActorService
{
	IActorDao actorDao=new ActorDaoImpl();

	public void addActor(HashMap<Integer, Object> actorSet)
	{
		Actor actor=new Actor();
		actor.setFirstName((String) actorSet.get(1));
		actor.setLastName((String) actorSet.get(2));
		actorDao.addActor(actor);
	}
	
	
	public Actor modifyActor(int actorId,String firstName,String lastName) {
		Actor actor=new Actor();
		actor.setActorId(actorId);
		actor.setFirstName( firstName);
		actor.setLastName(lastName);
		return actorDao.modifyActor(actor);
	
	}
	
	public boolean removeActor(int actorId) {
		return actorDao.removeActor(actorId);
	}

	
	public Actor searchActor(int actorId) {
		return actorDao.searchActor(actorId);
	}

	
	public List<Actor> getAllActor() {
		return actorDao.getAllActor();
	}
}
