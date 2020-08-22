package abloy.assignment.bo.service;

import com.google.gson.annotations.Expose;

public class MovieSuggestion {
    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private float rating;
    @Expose
    private String genres;

    public MovieSuggestion(int id, String name, float rating, String genres) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
