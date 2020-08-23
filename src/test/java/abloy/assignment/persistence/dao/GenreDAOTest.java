package abloy.assignment.persistence.dao;

import abloy.assignment.persistence.entities.Genre;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GenreDAOTest {

    @Test
    public void getGenreById() {
        GenreDAO genreDAO = new GenreDAO();
        List<Genre> genres =  genreDAO.getGenreById("1, 2");

//        assert
    }
}