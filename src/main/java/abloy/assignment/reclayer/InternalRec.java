package abloy.assignment.reclayer;

import abloy.assignment.bo.data.Genre;
import abloy.assignment.bo.data.Movie;
import abloy.assignment.bo.service.GenreRecParams;
import abloy.assignment.bo.service.MovieSuggestion;
import abloy.assignment.dblayer.model.GenreFetching;
import abloy.assignment.dblayer.model.MovieFetching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class InternalRec extends RecAbs<GenreRecParams, List<MovieSuggestion>> {

    public List<MovieSuggestion> recommend(GenreRecParams input) {
        if (input == null) return null;

        GenreFetching genreFetching = new GenreFetching();
        List<Genre> genres = genreFetching.getGenreById(input.getGenres());
        Map<Integer, String> genreKeyValue = genres.stream().
                collect(Collectors.toMap(Genre::getId, Genre::getName));


        MovieFetching movieFetching = new MovieFetching();
        List<Movie> movies = null;
        if (input.getGenres() != null) {
            movies = movieFetching.getMovieByGenre(input.getGenres());
        }

        List<MovieSuggestion> results = new ArrayList<>();
        if (movies != null) {
            results = movies.stream().map(x -> {
                int id = x.getId();
                String name = x.getName();
                float rating = x.getRating();
                String gStr = x.getGenres().stream()
                        .map(y -> genreKeyValue.get(y.getId()))
                        .collect(Collectors.joining(","));
                return new MovieSuggestion(
                        id,
                        name,
                        rating,
                        gStr
                );
            }).collect(Collectors.toList());
        }
        return results;
    }
}
