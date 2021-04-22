package com.cursojava.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

import com.cursojava.amazonviewer.dao.MovieDAO;

/**
 * Hereda de {@link Film}
 * Implementa de {@link IVisualizable}
 * */
public class Movie extends Film implements IVisualizable, MovieDAO {
	
	private int id;
	private int timeViewed;
	
	public Movie() {}
	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getTimeViewed() {
		return timeViewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}
	
	@Override
	public String toString() {
		return "\n :: MOVIE :: " + 
				"\n Title: " + getTitle() +
			    "\n Genre: " + getGenre() +
			    "\n Year: " + getYear() +
			    "\n Createor: " + getCreator() +
			    "\n Duration: " + getDuration();
	}

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		if (dateF.getTime() > dateI.getTime()) {
			setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
		} else {
			setTimeViewed(0);
		}		
	}
	
	public static ArrayList<Movie> makeMoviesList() {
		Movie movies = new Movie();
		
		return movies.read();
	}

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void view() {
		setViewed(true);
		Date dateI = startToSee(new Date());
		
		Movie movie = new Movie();
		movie.setMovieViewed(this);
		
		for (int i = 0; i < 1000; i++) {
			System.out.println("Viendo ...........");
		}
		
		//Término de la película.
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Viste: ");
		System.out.println(toString());
		System.out.println(" Por: " + getTimeViewed() + " Milisegundos.");
		System.out.println(" ----------------------");
		
	}
	
}
