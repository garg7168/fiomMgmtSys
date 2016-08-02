package com.flp.fms.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.flp.ems.domain.Actor;
import com.flp.ems.domain.Category;
import com.flp.ems.domain.Film;
import com.flp.ems.domain.Language;
import com.flp.fms.dao.FilmDaoImpl;
import com.flp.fms.dao.IFilmDao;
import com.flp.fms.service.ActorServiceImpl;
import com.flp.fms.service.FilmServiceImpl;
import com.flp.fms.service.IActorService;
import com.flp.fms.service.IFilmService;



public class UserInteraction
{
	Scanner sc=new Scanner(System.in);
	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	IFilmService filmService=new FilmServiceImpl();
	IActorService actorService=new ActorServiceImpl();
	IFilmDao filmDao=new FilmDaoImpl();

	public void addFilm() throws ParseException
	{

		HashMap<Integer, Object> filmSet=new HashMap<Integer, Object>();
		System.out.println("Enter the details of the film");
		System.out.println("-------------------------------");
		System.out.println("Enter title");
		filmSet.put(1, sc.next());
		System.out.println("Enter description");
		filmSet.put(2, sc.next());
		System.out.println("Enter release date");
		String dateString=sc.next();
		Date releaseDate;
		try {
			releaseDate = formatter.parse(dateString);
			filmSet.put(3, releaseDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Enter rental duration");
		filmSet.put(4, sc.nextShort());
		System.out.println("Enter rental rate");
		filmSet.put(5,sc.nextInt());
		System.out.println("Enter length of the movie");
		filmSet.put(6,sc.nextInt());
		System.out.println("Enter replacement cost");
		filmSet.put(7,sc.nextDouble());
		System.out.println("Enter rating");
		filmSet.put(8,sc.nextInt());
		System.out.println("Enter special features");
		filmSet.put(9,sc.next());


		System.out.println("Enter the language Name");
		filmSet.put(10,sc.next());

		System.out.println("Enter the category Name");
		filmSet.put(11,sc.next());

		System.out.println("Enter the Number of actors");
		int numberOfActors=sc.nextInt();

		List actor=new ArrayList();
		for(int i=1;i <= numberOfActors;i++)
		{
			HashMap<String, Object> actorDetails=new HashMap<String, Object>();
			System.out.println("Enter the actor first name");
			actorDetails.put("first_name",sc.next());
			System.out.println("Enter the actor last name");
			actorDetails.put("last_name",sc.next());
			actor.add( actorDetails);
		}
		filmSet.put(12, actor);

		filmService.addFilm(filmSet);
	}

	public void modifyFilm() throws ParseException
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		List actors=new ArrayList();
		Map<String,Object> filmDetails=new HashMap<String,Object>();
		System.out.println("Enter the film_id to modify");
		filmDetails.put("film_id", sc.nextInt());
		Film film=filmService.searchFilm((Integer) filmDetails.get("film_id"));
		if(film!=null)
		{
			System.out.println("film found");
			System.out.println("Enter title");
			filmDetails.put("title", sc.next());
			System.out.println("Enter description");
			filmDetails.put("description", sc.next());
			System.out.println("Enter release date");
			filmDetails.put("releaseDate", dateFormat.parse(sc.next()));
			System.out.println("Enter rental duration");
			filmDetails.put("rentalDuration", sc.nextInt());
			System.out.println("Enter rental rate");
			filmDetails.put("rentalRate", sc.nextInt());
			System.out.println("Enter length of the movie");
			filmDetails.put("length", sc.nextInt());
			System.out.println("Enter replacement cost");
			filmDetails.put("replacementCost", sc.nextInt());
			System.out.println("Enter rating");
			filmDetails.put("rating", sc.nextInt());
			System.out.println("Enter special features");
			filmDetails.put("specialFeatures", sc.next());
			System.out.println("Enter the languageName");
			filmDetails.put("languageName", sc.next());
			System.out.println("Enter the categoryName");
			filmDetails.put("categoryName", sc.next());


			System.out.println("Enter numberOfActors");
			int numberOfActors=sc.nextInt();
			for(int i=1;i<=numberOfActors;i++)
			{
				Map<String, String> actorDetails=new HashMap<String, String>();
				System.out.println("Enter the actor first name");
				actorDetails.put("firstName", sc.next());
				System.out.println("Enter the actor last name");
				actorDetails.put("lastName", sc.next());
				actors.add(actorDetails);
			}
			filmDetails.put("actors", actors);
			System.out.println("Film details modified successfully");
			filmService.modifyFilm(filmDetails);
		}
		else
		{
			System.out.println("Film not found");
		}


	}

	public void removeFilm()
	{
		System.out.println("Enter the film id to delete film ");
		int filmId=sc.nextInt();
		if(filmService.removeFilm(filmId))
		{
			System.out.println("Film deleted successfully");
		}
		else
		{
			System.out.println("Film details not found");
		}
	}

	public void searchFilm()
	{
		System.out.println("Enter the film id to get details about the film");
		int filmId=sc.nextInt();

		Film film=filmService.searchFilm(filmId);
		if(film!=null)
		{

			System.out.println(film);
		}
		else
		{
			System.out.println("Film not found");
		}
	}

	public void getAllFilm()
	{
		List<Film> films=filmService.getAllFilm();
		System.out.println("All films details are \n"+films);
	}

	public void addActor()
	{
		HashMap<Integer, Object> actorSet=new HashMap<Integer, Object>();

		System.out.println("Enter the actor first name");
		actorSet.put(1, sc.next());
		System.out.println("Enter the actor last name");
		actorSet.put(2, sc.next());
		System.out.println("Actor added successfully");
		actorService.addActor(actorSet);
	}

	public void modifyActor()
	{
		System.out.println("Enter the actor id to modify");
		int actorId=sc.nextInt();
		Actor actor=actorService.searchActor(actorId);
		if(actor!=null)
		{
			System.out.println("Actor present");
			System.out.println("Enter the actor first name");
			String firstName=sc.next();
			System.out.println("Enter the actor last name");
			String lastName=sc.next();
			System.out.println("Actor modified successfully ,details are"+actorService.modifyActor(actorId,firstName,lastName));	
		}
		else
		{
			System.out.println("Actor not present");
		}
	}

	public void removeActor()
	{
		System.out.println("Enter the actor id to remove actor");
		int actorId=sc.nextInt();
		if(actorService.removeActor(actorId))
		{
			System.out.println("Actor Successfully removed");
		}
		else
		{
			System.out.println("Actor Not Found");
		}
	}

	public void searchActor()
	{
		System.out.println("Enter the actor id to search");
		int actorId=sc.nextInt();
		Actor actor=actorService.searchActor(actorId);
		if(actor !=null)
		{
			System.out.println(actor);
		}

		else
		{
			System.out.println("Not Found");
		}
	}

	public void getAllActor()
	{
		List<Actor> actor= actorService.getAllActor();
		System.out.println("All actors details are\n "+actor);
	}
}
