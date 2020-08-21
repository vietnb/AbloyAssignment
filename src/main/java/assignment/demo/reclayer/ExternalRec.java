package assignment.demo.reclayer;

import assignment.demo.bo.data.Movie;
import assignment.demo.bo.service.GenreExternalRecInput;

import java.util.List;

public class ExternalRec extends RecAbs<GenreExternalRecInput, List<Movie>> {

    public List<Movie> recommend(GenreExternalRecInput input) {
        // TODO: call api from Netflix or IMDC ...
        return null;
    }
}
