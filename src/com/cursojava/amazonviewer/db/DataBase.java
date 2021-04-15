package com.cursojava.amazonviewer.db;

public class DataBase {

	public static final String URL      = "jbdc:mysql://localhost:3306/";
	public static final String DB       = "amazonviewer";
	public static final String USER     = "amazonviewer";
	public static final String PASSWORD = "amazonviewer";
		
	public static final String TMOVIE 		   = "movie";
	public static final String TMOVIE_ID       = "id";
	public static final String TMOVIE_TITLE    = "title";
	public static final String TMOVIE_GENRE    = "genre";
	public static final String TMOVIE_CREATOR  = "creator";
	public static final String TMOVIE_DURATION = "duration";
	public static final String TMOVIE_YEAR     = "year";
	
	public static final String TUSER 		= "user";
	public static final String TUSER_ID 	= "id";
	public static final String TUSER_NAME 	= "name";
}
