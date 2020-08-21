package abloy.assignment.reclayer;

import abloy.assignment.bo.data.Movie;
import abloy.assignment.bo.service.GenreExternalRecInput;

import java.util.List;

public class ExternalRec extends RecAbs<GenreExternalRecInput, List<Movie>> {

    public List<Movie> recommend(GenreExternalRecInput input) {
        // TODO: call api from Netflix or IMDC ...
        return null;
    }
}
