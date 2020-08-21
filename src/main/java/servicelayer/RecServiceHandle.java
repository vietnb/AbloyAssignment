package servicelayer;

import bo.data.Movie;
import bo.service.GenreRecInput;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import reclayer.InternalRec;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RecServiceHandle extends AbstractHandler {

    public String rec(String genre) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        GenreRecInput genreRecInput = new GenreRecInput();
        genreRecInput.setGenres(genre);

        InternalRec internalRec = new InternalRec();
        List<Movie> movies = internalRec.recommend(genreRecInput);
        return gson.toJson(movies);
    }

    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

    }
}
