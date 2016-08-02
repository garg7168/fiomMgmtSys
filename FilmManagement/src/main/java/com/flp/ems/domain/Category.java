package com.flp.ems.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Category
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private int categoryId;
	
	@Column(nullable=false)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL},mappedBy="category")
	private Set<Film> films=new HashSet<Film>();
	
	@Column(insertable = false, updatable = false,nullable=false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
	@OneToMany(mappedBy="category")
	private Set<Film> film;



	
	

	public Category(String name) {
		this.name=name;
	}

	public Category() {
		// TODO Auto-generated constructor stub
	}




	public int getCategory_id() {
		return categoryId;
	}
	
	public void setCategory_id(int category_id) {
		this.categoryId = category_id;
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
		return "Category [category_id=" + categoryId + ", name=" + name + ", last_update="
				+ lastUpdate + "]";
	}
}
