package com.example.demo.models;

public class Movie {
    private int year;
    private int length;
    private String title;
    private String subject;
    private int popularity;
    private String awards;


    public Movie(int year, int length, String title, String subject, int popularity, String awards) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.awards = awards;
    }

    public Movie(String[] informationOnMovies) {
        this.year = Integer.parseInt(informationOnMovies[0]);
        this.length = Integer.parseInt(informationOnMovies[1]);
        this.title = informationOnMovies[2];
        this.subject = informationOnMovies[3];
        this.popularity = Integer.parseInt(informationOnMovies[4]);
        this.awards = informationOnMovies[5];
    }

    public int getYear() {
        return year;
    }

    public int getLength() {
        return length;
    }

    public String getTitle(){
        return this.title;
    }

    public String getSubject() {
        return subject;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getAwards() {
        return awards;
    }

    public int compareTo(Movie m) {
        if (this.popularity==m.popularity) {
            return 0;
        } else if (this.popularity>m.popularity) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "<br>" + "Movie: " +
                "year: " + year +
                ", length: " + length +
                ", title: '" + title + '\'' +
                ", subject: '" + subject + '\'' +
                ", popularity: " + popularity +
                ", awards: '" + awards + '\'';
    }
}
