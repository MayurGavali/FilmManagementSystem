package com.flp.fms.domain;



import java.util.Date;
import java.util.List;
import java.util.Set;

public class Film {
	
	//Private Fields
	private int film_id;
	private String title;
	private String description;
	private Date releaseYear;
	private List<Language> languages;
	private Language originalLanguage;
	private Date rentalDuration;
	private int length;
	private double replacement;
	private int ratings;
	private String specialFeatures;
	private List<Actor> actors;
	private Category category;
	
	//No Argument Constructor
	public Film(){}
	
	//Argument Constructor
	public Film(int film_id, String title, String description, Date releaseYear, List<Language> languages,
			Language originalLanguage, Date rentalDuration, int length, double replacement, int ratings,
			String specialFeatures, List<Actor> actors, Category category) {
		super();
		this.film_id = film_id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languages = languages;
		this.originalLanguage = originalLanguage;
		this.rentalDuration = rentalDuration;
		this.length = length;
		this.replacement = replacement;
		this.ratings = ratings;
		this.specialFeatures = specialFeatures;
		this.actors = (List<Actor>) actors;
		this.category = category;
	}

	

	

	public int getFilm_id() {
		return film_id;
	}

	public void setFilm_id(int film_id) {
		this.film_id = film_id;
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

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public Language getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(Language originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public Date getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(Date rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacement() {
		return replacement;
	}

	public void setReplacement(double replacement) {
		this.replacement = replacement;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}


	public List<Actor> getActors() {
		return actors;
	}


	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + film_id;
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + length;
		result = prime * result + ((originalLanguage == null) ? 0 : originalLanguage.hashCode());
		result = prime * result + ratings;
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		result = prime * result + ((rentalDuration == null) ? 0 : rentalDuration.hashCode());
		long temp;
		temp = Double.doubleToLongBits(replacement);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (film_id != other.film_id)
			return false;
		if (languages == null) {
			if (other.languages != null)
				return false;
		} else if (!languages.equals(other.languages))
			return false;
		if (length != other.length)
			return false;
		if (originalLanguage == null) {
			if (other.originalLanguage != null)
				return false;
		} else if (!originalLanguage.equals(other.originalLanguage))
			return false;
		if (ratings != other.ratings)
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		if (rentalDuration == null) {
			if (other.rentalDuration != null)
				return false;
		} else if (!rentalDuration.equals(other.rentalDuration))
			return false;
		if (Double.doubleToLongBits(replacement) != Double.doubleToLongBits(other.replacement))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Film [film_id=" + film_id + ", title=" + title + ", description=" + description + ", releaseYear="
				+ releaseYear + ", languages=" + languages + ", originalLanguage=" + originalLanguage
				+ ", rentalDuration=" + rentalDuration + ", length=" + length + ", replacement=" + replacement
				+ ", ratings=" + ratings + ", specialFeatures=" + specialFeatures + ", actors=" + actors + ", category="
				+ category + "]";
	}
	

	
	
}
