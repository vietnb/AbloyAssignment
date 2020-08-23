package abloy.assignment.persistence.dao;

import abloy.assignment.appexception.DbAccessException;
import abloy.assignment.persistence.entities.Genre;
import abloy.assignment.persistence.connection.TextFileDbAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenreDAO {

    /**
     * get genre by id
     *
     * @param gIds
     * @return genre list
     */
    public List<Genre> getGenreById(String gIds) {
        if (gIds == null) return null;

        List<Genre> genres = null;
        TextFileDbAccess textFileDbAccess = new TextFileDbAccess("./db/genre_db");
        try {
            genres = new ArrayList<Genre>();

            Scanner scanner = textFileDbAccess.connect();
            while (scanner.hasNextLine()) {
                String g = scanner.nextLine();
                String[] gArr = g.split("\t");

                // movie id
                int gId = 0;
                if (gArr[0] != null) {
                    gId = Integer.parseInt(gArr[0]);
                }

                // movie name
                String gName = gArr[1];

                Genre genre = new Genre(gId);
                genre.setName(gName);

                genres.add(genre);
            }
        } catch (DbAccessException e) {
            e.printStackTrace();
        }
        return genres;
    }
}
