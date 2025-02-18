package com.movie.service.handler;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


public class MovieRequest {
	private String description;
	private String director;
	private String genre;
	private String title;
	private LocalDate date;
	private String language;
	private int totalSeats;
	private int availableSeats;
	private int price;

    public MovieRequest(int id, String title, String director, String description, String genre, LocalDate date,
                 String language, int totalSeats, int availableSeats, int price) {
            this.title = title;
            this.director = director;
            this.description = description;
            this.genre = genre;
            this.date = date;
            this.totalSeats = totalSeats;
            this.availableSeats = availableSeats;
            this.price = price;
            this.language = language;
        }

    public MovieRequest() {}


    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDirector() {return director;}

    public void setDirector(String director) {this.director = director;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getGenre() {return genre;}

    public void setGenre(String genre) {this.genre = genre;}

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public LocalDate getDate() {return date;}

    public void setDate(LocalDate date) {this.date = date;}


    public int getTotalSeats() {return totalSeats;}

    public void setTotalSeats(int totalSeats) {this.totalSeats = totalSeats;}

    public int getAvailableSeats() {return availableSeats;}

    public void setAvailableSeats(int availableSeats) {this.availableSeats = availableSeats;}

    public int getPrice() {return price;}

    public void setPrice(int price) {this.price = price;}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
