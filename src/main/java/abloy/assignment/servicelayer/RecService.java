package abloy.assignment.servicelayer;

import abloy.assignment.bo.data.Movie;
import abloy.assignment.bo.service.GenreRecParams;
import abloy.assignment.bo.service.MovieSuggestion;
import abloy.assignment.reclayer.InternalRec;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecService {

    @GetMapping("/rec/{genres}")
    public String rec(@PathVariable String genres) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        GenreRecParams genreRecParams = new GenreRecParams();
        genreRecParams.setGenres(genres);

        InternalRec internalRec = new InternalRec();
        List<MovieSuggestion> movies = internalRec.recommend(genreRecParams);
        return gson.toJson(movies);
    }
}
