package abloy.assignment.servicelayer;

import abloy.assignment.bo.data.Movie;
import abloy.assignment.bo.service.GenreRecInput;
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

        GenreRecInput genreRecInput = new GenreRecInput();
        genreRecInput.setGenres(genres);

        InternalRec internalRec = new InternalRec();
        List<Movie> movies = internalRec.recommend(genreRecInput);
        return gson.toJson(movies);
    }
}
