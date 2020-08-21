package abloy.assignment.bo.data;

import com.google.gson.annotations.Expose;

public class Genre {

    private int id;

    @Expose
    private String name;

    public Genre(int id) {
        this.id = id;
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
}
