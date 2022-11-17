package by.epam.ivanchenko;

import by.epam.ivanchenko.model.Actor;
import by.epam.ivanchenko.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

// Созд. нового фильма и актеров
//            Movie movie = new Movie("Pulp Fiction", 1994);
//            Actor actor1 = new Actor("Harvey Keitel",81);
//            Actor actor2 = new Actor("Samuel L. Jackson", 72);
//
//            // Arrays.asList() можно вместо List.of()
//            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//
//            session.save(movie);
//            session.save(actor1);
//            session.save(actor2);

//            Movie movie = session.get(Movie.class,1);
//            System.out.println(movie.getActors());

// Созд. нового фильма и назначение его актеру
//            Movie movie = new Movie("Resevoir Dogs", 1992);
//            Actor actor = session.get(Actor.class, 4);
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);
//
//            session.save(movie);

// Удаляем фильм у актера
            Actor actor = session.get(Actor.class,4);
            System.out.println(actor.getMovies());
            Movie movieToRemove = actor.getMovies().get(1);

            actor.getMovies().remove(1); // или вместо 1  movieToRemove
            movieToRemove.getActors().remove(actor);  // для удаления объекта нужны hashCode() и  equals()

            session.getTransaction().commit();
        }
    }
}
