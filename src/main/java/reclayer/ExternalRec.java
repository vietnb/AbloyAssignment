package reclayer;

import bo.data.Movie;
import bo.service.GenreExternalRecInput;
import bo.service.GenreRecInput;
import dblayer.model.MovieFetching;

import java.util.List;

public class ExternalRec extends RecAbs<GenreExternalRecInput, List<Movie>> {

    public List<Movie> recommend(GenreExternalRecInput input) {
        // TODO: call api from Netflix or IMDC ...
        return null;
    }
}
