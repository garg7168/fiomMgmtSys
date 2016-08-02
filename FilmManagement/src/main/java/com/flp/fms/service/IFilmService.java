package com.flp.fms.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.flp.ems.domain.Film;

public interface IFilmService 
{
	void addFilm(HashMap<Integer, Object> filmSet) ;
	void modifyFilm(Map<String, Object> filmDetails);
	boolean removeFilm(int filmId);
	Film searchFilm(int filmId);
	List<Film> getAllFilm();
	
}
