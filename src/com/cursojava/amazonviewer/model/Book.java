package com.cursojava.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Publication implements IVisualizable {
	
	private int id;
	private String isbn;
	private boolean readed;
	private int timeReaded;
	
	public Book(String title, Date editionDate, String editorial, String[] authors) {
		super(title, editionDate, editorial);
		setAuthors(authors);
	}

	public int getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String isReaded() {
		
		String readed = "";
		
		if (this.readed == true) {
			readed = "Sim";
		} else {
			readed = "Não";
		}
		
		return readed;
	}

	public void setReaded(boolean readed) {
		this.readed = readed;
	}

	public int getTimeReaded() {
		return timeReaded;
	}

	public void setTimeReaded(int timeReaded) {
		this.timeReaded = timeReaded;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String detailBook = "\n :: BOOK ::" + 
							"\n Title: " + getTitle() +
							"\n Editorial: " + getEditorial() + 
							"\n Edition Date: " + getEditionDate() +
							"\n Authors: ";
		
		for (int i = 0; i < getAuthors().length; i++) {
			detailBook += "\n    " + getAuthors()[i]; 
		}
		
		return detailBook;
	}

	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		
		if (dateF.getTime() > dateI.getTime()) {
			setTimeReaded((int)(dateF.getTime() - dateI.getTime()));
		} else {
			setTimeReaded(0);
		}
		
	}
	
	public static ArrayList<Book> makeBooksList() {
		
		ArrayList<Book> books = new ArrayList();
		
		for (int i = 1; i <= 6; i++) {
			books.add(new Book("Title of the book " + i, new Date(), "Editorial " + i, new String[]{"Author 1", "Author 2", "Author 3"}));
		}
		
		return books;
	}
	
}
