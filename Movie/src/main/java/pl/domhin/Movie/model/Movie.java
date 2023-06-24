package pl.domhin.Movie.model;

import jakarta.persistence.*;


@Entity(name = "MOVIES")
@Table(name = "MOVIES")
public class Movie {
    @Column(name = "NAZWA")
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "KATEGORIA")
    private String category;

    @Column(name = "isAvailable")
    private boolean isAvailable;

    public Movie(){

    }
    public Movie(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void update(Movie movie){
        setCategory(movie.category);
        setName(movie.name);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", category='" + category + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
