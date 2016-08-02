package com.flp.fms.dao;

import java.util.List;

import com.flp.ems.domain.Actor;

public interface IActorDao {
	void addActor(Actor actor);
	Actor modifyActor(Actor actor);
	boolean removeActor(int actorId);
	Actor searchActor(int actorId);
	List<Actor> getAllActor();

}
