package com.example.demo.services;

import com.example.demo.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class MovieAnalysisService {

    private File movieFile;
    private String fileName;
    private Scanner sc;

    public MovieAnalysisService(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Movie> getMovieList() throws FileNotFoundException {

        ArrayList<Movie> theListWithTheMovie = new ArrayList();

        try {
            this.movieFile = new File(this.fileName);
            this.sc = new Scanner(movieFile);
        } catch (FileNotFoundException fejl) {
            System.out.println("Fejl");
        }

        sc.nextLine();
        sc.nextLine();

        while (sc.hasNextLine()) {

            String[] lineFromFile = sc.nextLine().split(";");
            String[] informationOnMovies = new String[6];


            informationOnMovies[0] = lineFromFile[0]; //year
            informationOnMovies[1] = lineFromFile[1]; //length
            informationOnMovies[2] = lineFromFile[2]; //Title
            informationOnMovies[3] = lineFromFile[3]; //genre
            informationOnMovies[4] = lineFromFile[4]; //popularity
            informationOnMovies[5] = lineFromFile[5]; //awards

            Movie movieList = new Movie(informationOnMovies);
            theListWithTheMovie.add(movieList);
        }
        return theListWithTheMovie;
    }


    public Movie getFirstMovieOfList() throws FileNotFoundException {
        //Instantiated a file from film-new.csv
        File movieList = new File(fileName);
        //Scanner
        Scanner sc = new Scanner(movieList);
        //Skip 2 lines
        sc.nextLine();
        sc.nextLine();
        //Split
        String[] firstMovieAsArray = sc.nextLine().split(";");
        //Created a model from data
        Movie firstMovie = new Movie(Integer.parseInt(firstMovieAsArray[0]),
                Integer.parseInt(firstMovieAsArray[1]), firstMovieAsArray[2],
                firstMovieAsArray[3], Integer.parseInt(firstMovieAsArray[4]), firstMovieAsArray[5]);
        return firstMovie;
    }


    public String getRandomMovie() throws FileNotFoundException {

        Random random = new Random();
        int randomIndex = random.nextInt(getMovieList().size());

        String titleOnRandomMovie = getMovieList().get(randomIndex).getTitle();

        return titleOnRandomMovie;
    }


    public String getTop10SortedByPopularity() throws FileNotFoundException {
        ArrayList<Movie> movieArrayListForTop10 = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int randIndex = rand.nextInt(getMovieList().size());
            Movie randomTop10Movie = getMovieList().get(randIndex);
            movieArrayListForTop10.add(randomTop10Movie);
            for (int j = 0; j < 10; j++) {
                Collections.sort(movieArrayListForTop10,Movie::compareTo);
            }
        }
        return movieArrayListForTop10.toString();
    }


    public int getHowManyWonAnAward() throws FileNotFoundException {
        int counter = 0;
        for (int i = 0; i < getMovieList().size(); i++) {
            if(getMovieList().get(i).getAwards().equalsIgnoreCase("yes")){
                counter++;
            }
        }
        return counter;
    }
}
