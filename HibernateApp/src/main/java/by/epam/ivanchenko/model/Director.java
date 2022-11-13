package by.epam.ivanchenko.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "director")
public class Director {

    @OneToMany(mappedBy = "producer")
    private List<Movie> movies;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "director_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    public Director(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Director() {

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }


    @Override
    public String toString() {
        return "Director: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '.';
    }
}
