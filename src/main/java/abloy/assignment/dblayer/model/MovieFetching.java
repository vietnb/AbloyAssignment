package abloy.assignment.dblayer.model;

import abloy.assignment.appexception.DbAccessException;
import abloy.assignment.bo.data.Genre;
import abloy.assignment.bo.data.Movie;
import abloy.assignment.dblayer.connection.TextFileDbAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieFetching {

    /**
     * get movie by genre list
     *
     * @param gIds
     * @return movie list
     */
    public List<Movie> getMovieByGenre(String gIds) {
        if (gIds == null) return null;

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
                        if (gIds.contains(gId)) {
                            isRightMovie = true;
                        }
                        if (gId != null) {
                            int id = Integer.parseInt(gId);
                            Genre g = new Genre(id);
                            genres.add(g);
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
