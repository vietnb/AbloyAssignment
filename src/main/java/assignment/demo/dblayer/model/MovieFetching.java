package assignment.demo.dblayer.model;

import assignment.demo.appexception.DbAccessException;
import assignment.demo.bo.data.Genre;
import assignment.demo.bo.data.Movie;
import assignment.demo.dblayer.connection.TextFileDbAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieFetching {

    /**
     * get movie by genre list
     *
     * @param genre
     * @return movie list
     */
    public List<Movie> getMovieByGenre(String genre) {
        if (genre == null) return null;

        List<Movie> movies = null;
        TextFileDbAccess textFileDbAccess = new TextFileDbAccess("./db/movie_db");
        try {
            movies = new ArrayList<Movie>();

            Scanner scanner = textFileDbAccess.connect();
            while (scanner.hasNextLine()) {
                String m = scanner.nextLine();
                String[] mArr = m.split("\t");

                // movie id
                int mId = 0;
                if (mArr[0] != null) {
                    mId = Integer.parseInt(mArr[0]);
                }

                // movie name
                String mName = mArr[1];

                // movie rating
                float mRating = 0f;
                if (mArr[2] != null) {
                    mRating = Float.parseFloat(mArr[2]);
                }
                List<Genre> genres = null;
                boolean isRightMovie = false;
                if (mArr[3] != null) {
                    genres = new ArrayList<Genre>();
                    String[] gArr = mArr[3].split(",");
                    for (String gId : gArr) {
                        // movie has the input genre pr not
                        if (gId != null && genre.contains(gId)) {
                            int id = Integer.parseInt(gId);
                            Genre g = new Genre(id);
                            genres.add(g);
                            isRightMovie = true;
                        }
                    }
                }
                if (isRightMovie) {
                    Movie movie = new Movie();
                    movie.setId(mId);
                    movie.setName(mName);
                    movie.setRating(mRating);
                    movie.setGenres(genres);
                    movies.add(movie);
                }
            }
        } catch (DbAccessException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
