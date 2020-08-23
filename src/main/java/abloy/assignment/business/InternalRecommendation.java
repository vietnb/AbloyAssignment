package abloy.assignment.business;

import abloy.assignment.persistence.entities.Genre;
import abloy.assignment.persistence.entities.Movie;
import abloy.assignment.service.so.MovieRecRequestParams;
import abloy.assignment.service.so.MovieSuggestion;
import abloy.assignment.persistence.dao.GenreDAO;
import abloy.assignment.persistence.dao.MovieDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InternalRecommendation implements
        IRecommendation<MovieRecRequestParams, List<MovieSuggestion>> {

    public List<MovieSuggestion> recommend(MovieRecRequestParams input) {
        if (input == null) return null;

        GenreDAO genreDAO = new GenreDAO();
        List<Genre> genres = genreDAO.getGenreById(input.getGenres());
        Map<Integer, String> genreKeyValue = genres.stream().
                collect(Collectors.toMap(Genre::getId, Genre::getName));


        MovieDAO movieDAO = new MovieDAO();
        List<Movie> movies = null;
        if (input.getGenres() != null) {
            movies = movieDAO.getMovieByGenre(input.getGenres());
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
