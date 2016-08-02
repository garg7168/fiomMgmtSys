package com.flp.fms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

/**
 * Servlet implementation class SpecificFilm
 */
public class SpecificFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  


		PrintWriter out=response.getWriter();
		response.setContentType("application/json");


		String filmID=request.getParameter("flmId");  
		int filmId=Integer.valueOf(filmID);

		IFilmService filmService=new FilmServiceImpl();
		Film films=filmService.searchFilm(filmId);
		//out.println(films);
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(Film.class, new FilmAdapter1()).create();
		String myJsonFilmObj= gson.toJson(films);

		out.println(myJsonFilmObj);

		//System.out.println(emps);

	}
}

class FilmAdapter1 implements JsonSerializer<Film> {

	@Override
	public JsonElement serialize(Film film, Type type, JsonSerializationContext jsc) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("filmId", film.getFilm_id());
		jsonObject.addProperty("title", film.getTitle());
		jsonObject.addProperty("description", film.getDescription());
		jsonObject.addProperty("releaseYear", film.getRelease_year().toString());
		jsonObject.addProperty("description", film.getDescription());
		jsonObject.addProperty("rentalDuration", film.getRental_duration());
		jsonObject.addProperty("rentalRate", film.getRental_rate());
		jsonObject.addProperty("length", film.getLength());
		jsonObject.addProperty("replacementCost", film.getReplacement_cost());
		jsonObject.addProperty("rating", film.getRating());
		jsonObject.addProperty("specialFeatures", film.getSpecial_features());
		return jsonObject;      
	}


}


	