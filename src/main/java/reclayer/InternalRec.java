package reclayer;

import bo.data.Movie;
import bo.service.GenreRecInput;
import dblayer.model.MovieFetching;

import java.util.List;

public class InternalRec extends RecAbs<GenreRecInput, List<Movie>> {

    public List<Movie> recommend(GenreRecInput input) {
        if (input == null) return null;

        MovieFetching movieFetching = new MovieFetching();
        List<Movie> movies = null;
        if (input.getGenres() != null) {
            movies = movieFetching.getMovieByGenre(input.getGenres());
        }
        return movies;
    }
}