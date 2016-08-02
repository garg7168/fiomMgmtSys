package com.flp.ems.domain;

import java.math.BigDecimal;
//import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Film
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private int filmId;
	
    @Column(nullable=false)
	private String title;
    
    @Column(nullable=false)
	private String description;
    
    @Column(nullable=false)
	@Temporal(TemporalType.DATE)
    private Date releaseYear;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinColumn(name="language_id")
	private Language language;
	
	@Column(nullable=false)
	private int rentalDuration;
	
	@Column(nullable=false)
	private int rentalRate;
	
	@Column(nullable=false)
	private int length;
	
	@Column(nullable=false)
	private double replacementCost;
	
	@Column(nullable=false)
	private int rating;
	                                                                 
	@Column(nullable=false)
	private String specialFeatures;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinTable(name = "filmActor", joinColumns = @JoinColumn(name = "filmId", referencedColumnName = "filmId") , inverseJoinColumns = @JoinColumn(name = "actorId", referencedColumnName = "actorId"))
	private Set<Actor> actors = new HashSet<Actor>();
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinTable(name = "filmCategory", joinColumns = @JoinColumn(name = "filmId", referencedColumnName = "filmId") , inverseJoinColumns = @JoinColumn(name = "categoryId", referencedColumnName = "categoryId"))
	private Category category;
	
	@Column(insertable = false, updatable = false,nullable=false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
	/*public Film()
	{
		
	}
*/
	public int getFilm_id() {
		return filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRelease_year() {
		return releaseYear;
	}

	public void setRelease_year(Date release_year) {
		this.releaseYear = release_year;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public int getRental_duration() {
		return rentalDuration;
	}

	public void setRental_duration(int rental_duration) {
		this.rentalDuration = rental_duration;
	}

	public int getRental_rate() {
		return rentalRate;
	}

	public void setRental_rate(int rental_rate) {
		this.rentalRate = rental_rate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacement_cost() {
		return replacementCost;
	}

	public void setReplacement_cost(double replacement_cost) {
		this.replacementCost = replacement_cost;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getSpecial_features() {
		return specialFeatures;
	}

	public void setSpecial_features(String special_features) {
		this.specialFeatures = special_features;
	}

	public Date getLast_update() {
		return lastUpdate;
	}

	public void setLast_update(Date last_update) {
		this.lastUpdate = last_update;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Film [film_id=" + filmId + ", title=" + title + ", description=" + description + ", release_year="
				+ releaseYear + ", language=" + language + ", rental_duration=" + rentalDuration + ", rental_rate="
				+ rentalRate + ", length=" + length + ", replacement_cost=" + replacementCost + ", rating=" + rating
				+ ", special_features=" + specialFeatures + ", actors=" + actors + ", category=" + category
				+ ", last_update=" + lastUpdate + "]";
	}
}
