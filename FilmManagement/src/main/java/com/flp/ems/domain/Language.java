package com.flp.ems.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;



@Entity
public class Language 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private int languageId;
	
	@Column(nullable=false)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL},mappedBy = "language")
	private Set<Film> films;
	
	@Column(insertable = false, updatable = false,nullable=false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
	public Language()
	{
		
	}
/*
	public Language(String language_name) {
		this.name=languageName;
	}*/

	public Language(String name) {
		this.name=name;
	}

	public int getLanguage_id() {
		return languageId;
	}

	public void setLanguage_id(int language_id) {
		this.languageId = languageId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLast_update() {
		return lastUpdate;
	}

	public void setLast_update(Date last_update) {
		this.lastUpdate = last_update;
	}

	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Language [language_id=" + languageId + ", name=" + name + ", last_update="
				+ lastUpdate + "]";
	}
}
