package com.example.Block.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Movie_Id;
	private String Movie_Name;
	private String Movie_RatingS;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "movie")
	@JsonIgnore
	private Set<Catalogue> cat = new HashSet<>();
	public int getMovie_Id() {
		return Movie_Id;
	}
	public void setMovie_Id(int movie_Id) {
		Movie_Id = movie_Id;
	}
	public String getMovie_Name() {
		return Movie_Name;
	}
	public void setMovie_Name(String movie_Name) {
		Movie_Name = movie_Name;
	}
	public String getMovie_RatingS() {
		return Movie_RatingS;
	}
	public void setMovie_RatingS(String movie_RatingS) {
		Movie_RatingS = movie_RatingS;
	}
	public Set<Catalogue> getCat() {
		return cat;
	}
	public void setCat(Set<Catalogue> cat) {
		this.cat = cat;
	}
	@Override
	public String toString() {
		return "Movie [Movie_Id=" + Movie_Id + ", Movie_Name=" + Movie_Name + ", Movie_RatingS=" + Movie_RatingS
				+ ", cat=" + cat + "]";
	}
	

}
