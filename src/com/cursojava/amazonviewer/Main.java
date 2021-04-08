package com.cursojava.amazonviewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.cursojava.amazonviewer.makereport.Report;
import com.cursojava.amazonviewer.model.Book;
import com.cursojava.amazonviewer.model.Chapter;
import com.cursojava.amazonviewer.model.Movie;
import com.cursojava.amazonviewer.model.Serie;

public class Main {

	public static void main(String[] args) { 

		showMenus();	
				
	}

	public static void showMenus() {
		
		int exit = 0;
		
		do {
			System.out.println("WELCOME AMAZON VIEWER");
			System.err.println("");
			System.out.println("Select the option number:");
			System.out.println("1: Movies");
			System.out.println("2: Series");
			System.out.println("3: Books");
			System.out.println("4: Magazines");	
			System.out.println("5: Report");
			System.out.println("6: Report Today");
			System.out.println("0: Exit");	
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			switch (response) {
				case 0:
					//Exit
					exit = 0;
					break;
				case 1:
					//Movies
					showMovies();
					break;
				case 2: 
					//Series
					showSeries();
					break;
				case 3: 
					//Books
					showBooks();
					break;
				case 4: 
					//Magazines
					showMagazines();
					break;
				case 5: 
					//Report
					makeReport();
					break;
				case 6: 
					//Report Today
					makeReport(new Date());
					break;
				default: 
					System.out.println();
					System.out.println("**** Select one option! ****");
					System.out.println();
					break;
			}
			
		}while(exit != 0);
	}
	
	
	static ArrayList<Movie> movies = Movie.makeMoviesList();
	
	public static void showMovies() {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: MOVIES ::");
			
			for (int i = 0; i < movies.size(); i++) {
				System.out.println(i+1 + ". " + movies.get(i).getTitle() + " - Visto: " + movies.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al menu anterior.");
			System.out.println();
			
			// Leer respuesta del usuario.
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if (response == 0) {
				showMenus();
			}
			
			if (response > 0) {
				Movie movieSelected = movies.get(response - 1);
				movieSelected.setViewed(true);
				Date dateI = movieSelected.startToSee(new Date());
				
				for (int i = 0; i < 100000; i++) {
					System.out.println("Viendo ...........");
				}
				
				//Término de la película.
				movieSelected.stopToSee(dateI, new Date());
				System.out.println();
				System.out.println("Viste: ");
				System.out.println(movieSelected.toString());
				System.out.println(" Por: " + movieSelected.getTimeViewed() + " Milisegundos.");
				System.out.println(" ----------------------");
				
			}
			
		}while(exit != 0);
	}
	
	public static void showSeries() {
		
		ArrayList<Serie> series = Serie.makeSeriesList();
		
		int exit = 0;
		
		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			
			for (int i = 0; i < series.size(); i++) { //1. Serie 1
				System.out.println(i+1 + ". " + series.get(i).getTitle() + " Visto: " + series.get(i).isViewed());
			}
			
			System.out.println("0. Back to the main menu.");
			
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if (response == 0) {
				showMenus();
			}
			
			showChapters(series.get(response -1).getChapters());
			
		} while (exit != 0);
	}
	
	public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
		int exit = 1;
		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
			
			for (int i = 0; i < chaptersOfSerieSelected.size(); i++) {
				System.out.println((i + 1) + ". " + chaptersOfSerieSelected.get(i).getTitle() + " - Visto: " + chaptersOfSerieSelected.get(i).isViewed());
			}
			
			System.out.println("0. Back to the main menu");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if (response == 0) {
				showSeries();
			}
			
			Chapter chapterSelected = chaptersOfSerieSelected.get(response - 1);
			chapterSelected.setViewed(true);
			Date dateI = chapterSelected.startToSee(new Date());
			
			for (int i = 0; i <= 1000; i++) {
				System.out.println("Viendo .........");
			}
			
			chapterSelected.stopToSee(dateI, new Date());
			
			System.out.println();
			System.out.println("Viste: ");
			System.out.println(chapterSelected.toString());
			System.out.println("Por: " + chapterSelected.getTimeViewed() + " Milisegundos.");
			
			
		} while(exit != 0);
	}
	
	public static void showBooks() {
		
		ArrayList<Book> books = Book.makeBooksList();
		
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			for (int i = 0; i < books.size(); i++) {
				System.out.println((i + 1) + ". " + books.get(i).getTitle() + " - Read: " + books.get(i).isReaded());
			}
			
			System.out.println("0. Back to main menu.");
			
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if (response == 0) {
				showMenus();
			}
			
			Book bookSelected = books.get(response - 1);
			bookSelected.setReaded(true);
			Date dateI = bookSelected.startToSee(new Date());
			
			for (int i = 0; i <= 10000; i++) {
				System.out.println("Leendo ........");
			}
			
			bookSelected.stopToSee(dateI, new Date());
			
			System.out.println();
			System.out.println("You readed: ");
			System.out.println(bookSelected.toString());
			System.out.println("Por: " + bookSelected.getTimeReaded() + " Milesegundos.");
			System.out.println(" ----------------------");
			
		}while(exit != 0);
	}

	public static void showMagazines() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
			System.out.println();
		}while(exit != 0);
	}
	
	public static void makeReport() {
		Report report = new Report();
		
		report.setNameFile("reporte");
		report.setExtension("txt");
		report.setTitle(":: VISTOS ::");
		String contentReport = "";
				
		for (Movie movie : movies) {
			if (movie.getViewed()) {
				contentReport += movie.toString() + "\n";
			}
		}
		report.setContent(contentReport);
		report.makeReport();
		
	}
	
	public static void makeReport(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = df.format(date);
		
		Report report = new Report();
		
		report.setNameFile("reporte_" + dateString);
		report.setExtension("txt");
		report.setTitle(":: VISTOS ::");
		String contentReport = "";
				
		for (Movie movie : movies) {
			if (movie.getViewed()) {
				contentReport += movie.toString() + "\n";
			}
		}
		report.setContent(contentReport);
		report.makeReport();
	}
}
