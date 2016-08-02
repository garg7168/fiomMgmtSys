package com.flp.fms.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
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
import com.flp.fms.dao.ActorDaoImpl;
import com.flp.fms.dao.FilmDaoImpl;
import com.flp.fms.dao.IActorDao;
import com.flp.fms.dao.IFilmDao;
import com.flp.fms.view.UserInteraction;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class FilmServiceImpl implements IFilmService
{ 
	IFilmDao filmDao=new FilmDaoImpl();
	IActorDao actorDao=new ActorDaoImpl();

	public void addFilm(HashMap<Integer, Object> filmSet) 
	{
		Film film=new Film();
		film.setTitle((String) filmSet.get(1));
		film.setDescription((String) filmSet.get(2));
		film.setRelease_year((Date) filmSet.get(3));
		film.setRental_duration((Short) filmSet.get(4));
		film.setRental_rate((Integer) filmSet.get(5));
		film.setLength((Integer) filmSet.get(6));
		film.setReplacement_cost((Double) filmSet.get(7));
		film.setRating((Integer) filmSet.get(8));
		film.setSpecial_features((String) filmSet.get(9));

		Language language=new Language();
		language.setName((String) filmSet.get(10));
		film.setLanguage(language);

		Category category=new Category();
		category.setName((String) filmSet.get(11));
		film.setCategory(category);




		List<Film> actors=(List<Film>) filmSet.get(12);
		for(int i=0;i<actors.size();i++)
		{
			Actor actor=new Actor();
			actor.setFirstName((String) ( (Map<Integer, Object>) actors.get(i)).get("first_name"));
			actor.setLastName((String) ((Map<Integer, Object>) actors.get(i)).get("last_name"));
			film.getActors().add(actor);
		}


		filmDao.addFilm(film);
	}

	public void modifyFilm(Map<String, Object> filmDetails)
	{
		Film film=filmDao.searchFilm((Integer) filmDetails.get("film_id"));
		if(film!=null)
		{
			film.setTitle((String) filmDetails.get("title"));
			film.setDescription((String) filmDetails.get("description"));
			film.setRelease_year((Date) filmDetails.get("releaseDate"));
			film.setRental_duration((Integer) filmDetails.get("rentalDuration"));
			film.setRental_rate((Integer) filmDetails.get("rentalRate"));
			film.setLength((Integer) filmDetails.get("length"));
			film.setReplacement_cost((Integer) filmDetails.get("replacementCost"));
			film.setRating((Integer) filmDetails.get("rating"));
			film.setSpecial_features((String) filmDetails.get("specialFeatures"));
			/*Language language=new Language();
			language.setName((String) filmDetails.get(10));
			film.setLanguage(language);

			Category category=new Category();
			category.setName((String) filmDetails.get(11));
			film.setCategory(category);*/
			
			
			Language language=filmDao.findLanguageByName((String) filmDetails.get("languageName"));
			if(language==null)
			{
			language=new Language((String) filmDetails.get("languageName"));
			}
			film.setLanguage(language);
			Category category=filmDao.findCategoryByName((String) filmDetails.get("categoryName"));
			if(category==null)
			{
			category=new Category((String) filmDetails.get("categoryName"));
			}
			film.setCategory(category);


			List<Actor> actors=actorDao.getAllActor();
			for(int i=0;i<((List<Film>) filmDetails.get("actors")).size();i++)
			{
				Actor actor=new Actor();
				actor.setFirstName((String) ((Map<String, Object>) ((List<Film>) filmDetails.get("actors")).get(i)).get("firstName"));
				actor.setLastName((String) ((Map<String, Object>) ((List<Film>) filmDetails.get("actors")).get(i)).get("lastName"));

				if(!actors.contains(actor))
				{
					film.getActors().add(actor);
				}

			}
			filmDao.modifyFilm(film);

		}
	}



		public boolean removeFilm(int film_id)
		{
			return filmDao.removeFilm(film_id);

		}

		public Film searchFilm(int filmId) 
		{
			return filmDao.searchFilm(filmId);
		}

		public List<Film> getAllFilm() 
		{
			return filmDao.getAllFilm();
		}

		








	}
