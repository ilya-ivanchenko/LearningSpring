package by.epam.ivanchenko.model;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {


    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private Director producer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "year_of_production")
    private int year;

    public Movie(String name, int year, Director producer) {
        this.name = name;
        this.year = year;
        this.producer = producer;
    }

    public Movie() {

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Director getProducer() {
        return producer;
    }

    public void setProducer(Director producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "\nMovie:" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                '.' ;
    }
}
