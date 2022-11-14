package by.epam.ivanchenko;

import by.epam.ivanchenko.model.Director;
import by.epam.ivanchenko.model.Item;
import by.epam.ivanchenko.model.Movie;
import by.epam.ivanchenko.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Person person = new Person("Test cascad", 30);

            person.addItem(new Item("Test  item1"));
            person.addItem(new Item("Test  item2"));
            person.addItem(new Item("Test item3"));

            session.save(person);  // при сохранении человека сохр. все товары, связ. с ним (в методе addItem)

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
