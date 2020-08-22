package abloy.assignment.reclayer;

import abloy.assignment.bo.data.Movie;
import abloy.assignment.bo.service.GenreExternalRecParams;

import java.util.List;

public class ExternalRec extends RecAbs<GenreExternalRecParams, List<Movie>> {

    public List<Movie> recommend(GenreExternalRecParams input) {
        // TODO: call api from Netflix or IMDC ...
        return null;
    }
}
