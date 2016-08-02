package com.flp.fms.service;

import java.util.HashMap;
import java.util.List;

import com.flp.ems.domain.Actor;

public interface IActorService {

	void addActor(HashMap<Integer, Object> actorSet);

	Actor modifyActor(int actorId,String firstName,String lastName);

	boolean removeActor(int actorId);

	Actor searchActor(int actorId);

	List<Actor> getAllActor();

	

}