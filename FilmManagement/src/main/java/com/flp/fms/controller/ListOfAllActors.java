package com.flp.fms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.jboss.logging.Message;

import com.flp.ems.domain.Actor;
import com.flp.ems.domain.Film;
import com.flp.fms.service.ActorServiceImpl;
import com.flp.fms.service.FilmServiceImpl;
import com.flp.fms.service.IActorService;
import com.flp.fms.service.IFilmService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import antlr.debug.MessageAdapter;

public class ListOfAllActors extends HttpServlet{
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		response.setContentType("application/json");

		
		IActorService actorService=new ActorServiceImpl();
		List<Actor> actors=actorService.getAllActor();
		//out.println(actors);
		
		/*Gson gson=new Gson();
		String myJsonActorObj=gson.toJson(actors);*/

		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(Actor.class, new ActorAdapter()).create();
	    String myJsonActorObj= gson.toJson(actors);
	    
		out.println(myJsonActorObj);

		//System.out.println(emps);

	}
}

class ActorAdapter implements JsonSerializer<Actor> {

    @Override
    public JsonElement serialize(Actor actor, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("actorId", actor.getActorId());
        jsonObject.addProperty("firstName", actor.getFirstName());
        jsonObject.addProperty("lastName", actor.getLastName());
        jsonObject.addProperty("lastUpdate", actor.getLastUpdate().toString());
        return jsonObject;      
    }
}
	
