package abloy.assignment.service;

import abloy.assignment.business.IRecommendation;
import abloy.assignment.service.so.MovieRecRequestParams;
import abloy.assignment.service.so.MovieSuggestion;
import abloy.assignment.business.InternalRecommendation;
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

        MovieRecRequestParams movieRecRequestParams = new MovieRecRequestParams();
        movieRecRequestParams.setGenres(genres);

//        InternalIRecommendation internalRec = new InternalIRecommendation();
        IRecommendation internalRec = new InternalRecommendation();
        List<MovieSuggestion> movies = (List<MovieSuggestion>) internalRec.recommend(movieRecRequestParams);
        return gson.toJson(movies);
    }
}
