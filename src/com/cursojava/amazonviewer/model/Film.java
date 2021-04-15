package com.cursojava.amazonviewer.model;

/**
 * <h1>Film</h1>
 * Film es una clase padre abastracta.
 * <p>
 * Esta clase es la clase base de la fam�lia Films, como es abstracta
 * no pueden crearse instancias. Contiene el m�todo abstracto
 * {@code view()} que es obligat�rio implementar para todo aqu�l que pertenezca a la fam�lia.
 * 
 * @author moises.aguilar
 * @version 1.0
 * @since 2018
 * */
public abstract class Film {
	private String title;
	private String genre;
	private String creator;
	private int duration;
	private short year;
	private boolean viewed;
	
	public Film(String title, String genre, String creator, int duration) {
		super();
		this.title = title;
		this.genre = genre;
		this.creator = creator;
		this.duration = duration;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public short getYear() {
		return year;
	}
	public void setYear(short year) {
		this.year = year;
	}
	public Boolean getIsViewed() {
		
		return this.viewed;
	}
	public String isViewed() {
		
		String visto = "";
		if (viewed == true) {
			visto = "S�";
		} else {
			visto = "No";
		}
		return visto;
	}
	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}

	/**
	 * {@code view()} es un m�todo abastracto obligatorio de implementar.
	 * */
	public abstract void view();
}
