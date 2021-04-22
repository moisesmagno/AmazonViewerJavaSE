package com.cursojava.amazonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.cursojava.amazonviewer.db.IDBConnection;
import com.cursojava.amazonviewer.model.Movie;
import static com.cursojava.amazonviewer.db.DataBase.*;
import com.cursojava.amazonviewer.util.AmazonUtil;


public interface MovieDAO extends IDBConnection {

	default Movie setMovieViewed(Movie movie) {
		
		try (Connection connection = connecToDB()) {
			Statement statement = connection.createStatement();
			DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
			
			String query = "INSERT INTO " + TVIEWED + 
							"(" + TVIEWED_IDMATERIAL +", " + TVIEWED_IDELEMENT +", " + TVIEWED_IDUSUARIO + "," + TVIEWED_DATETIME + ")" +
							" VALUES(" + ID_TMATERIALS[0] + "," + movie.getId() + ", " + TUSER_IDUSUARIO + ",'" + AmazonUtil.getCurrentDate() + "')";
			
			if (statement.executeUpdate(query) > 0) {
				System.out.println("Sé marcó en visto!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return movie;
	}
	
	default ArrayList<Movie> read() {
		ArrayList<Movie> movies = new ArrayList();
		try (Connection connection = connecToDB()) {
			
			String query = "SELECT * FROM " + TMOVIE;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Movie movie = new Movie(
						rs.getString(TMOVIE_TITLE), 
						rs.getString(TMOVIE_GENRE), 
						rs.getString(TMOVIE_CREATOR),
						Integer.valueOf(rs.getString(TMOVIE_DURATION)), 
						Short.valueOf(rs.getString(TMOVIE_YEAR)));
				
				movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
				movie.setViewed(getMovieViewed(preparedStatement, connection, Integer.valueOf(rs.getString(TMOVIE_ID))));
				movies.add(movie);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return movies;
	}
	
	private boolean getMovieViewed(PreparedStatement preparedStatement, Connection connection, int id_movie) {
		boolean viewed = false;
		
		String query = "SELECT * FROM " + TVIEWED +
						" WHERE " + TVIEWED_IDMATERIAL + " = ? " +
						" AND " + TVIEWED_IDELEMENT + " = ? " +
						" AND " + TVIEWED_IDUSUARIO + "= ? ";
		
		ResultSet rs = null;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ID_TMATERIALS[0]);
			preparedStatement.setInt(2, id_movie);
			preparedStatement.setInt(3, TUSER_IDUSUARIO);
			
			rs = preparedStatement.executeQuery();
			
			// Retorna true si hay un dato, pero retorno false si no lo hay.
			viewed = rs.next();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return viewed;
	}
	
}
