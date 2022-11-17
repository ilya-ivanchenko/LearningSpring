package by.epam.ivanchenko;

import by.epam.ivanchenko.model.Actor;
import by.epam.ivanchenko.model.Item;
import by.epam.ivanchenko.model.Movie;
import by.epam.ivanchenko.model.Person;
import org.hibernate.Hibernate;
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
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

// LAZY:
//            Person person = session.get(Person.class, 3);
//            System.out.println(person);
//
//            System.out.println(person.getItems());

// EAGER:
//            Item item = session.get(Item.class,4);
//            System.out.println("Получили товар");
//            System.out.println(item.getOwner());

            Person person = session.get(Person.class, 3);
            System.out.println("Получили человека");
 //            System.out.println(person.getItems());

//            Hibernate.initialize(person.getItems());        // подгружаем связанные сущности

            session.getTransaction().commit();
            System.out.println("Сессия завершилась");




            // Открываем сессию и транзакцию еще раз(в любом месте)
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Вторая транзакция");
            // объект person еще в сост. detached

            person = (Person) session.merge(person); // связ. сессию с объектом person

            Hibernate.initialize(person.getItems()); // можно вместо этого написать HQl-код:
//          List<Item> items =  session.createQuery("SELECT i from Item i where i.owner.id=:personId", Item.class).setParameter("personId", person.getId()).getResultList();

            session.getTransaction().commit();

            System.out.println("Вне второй сессии");
           System.out.println(person.getItems()); // сработает, т.к. связаннне товары были загружены



        }
    }
}
