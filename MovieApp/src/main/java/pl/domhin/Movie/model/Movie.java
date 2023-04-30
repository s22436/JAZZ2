package pl.domhin.Movie.model;

public class Movie {
    private String name;
    private String id;
    private String category;

    public Movie(String name, String id, String category) {
        this.name = name;
        this.id = id;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void update(Movie movie){
        setCategory(movie.category);
        setName(movie.name);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
