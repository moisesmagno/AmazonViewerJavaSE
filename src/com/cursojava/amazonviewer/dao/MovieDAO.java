package com.cursojava.amazonviewer.dao;

import java.util.ArrayList;

import com.cursojava.amazonviewer.model.Movie;

public interface MovieDAO {

	default Movie setMovieViewed(Movie movie) {
		return movie;
	}
	
	default ArrayList<Movie> read() {
		ArrayList<Movie> movies = new ArrayList();
		return movies;
	}
	
	private boolean getMovieViewed() {
		return false;
	}
	
}
