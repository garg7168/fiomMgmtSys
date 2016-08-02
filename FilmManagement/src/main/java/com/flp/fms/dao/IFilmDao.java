package com.flp.fms.dao;

import java.util.List;

import com.flp.ems.domain.Category;
//import com.flp.ems.domain.Actor;
import com.flp.ems.domain.Film;
import com.flp.ems.domain.Language;


public interface IFilmDao {
	void addFilm(Film film);
	void modifyFilm(Film film);
	boolean removeFilm(int filmId);
	Film searchFilm(int filmId);
	List<Film> getAllFilm();
	Language findLanguageByName(String string);
	Category findCategoryByName(String string);
	
	

}

