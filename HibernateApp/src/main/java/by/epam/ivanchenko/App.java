package by.epam.ivanchenko;

import by.epam.ivanchenko.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);      //передаем класс, помеч. Entity

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Person person = session.get(Person.class,1);                                    // поиск и получение сущности Person  в БД по primary key = 1
            System.out.println(person.getName());
            System.out.println(person.getAge());

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
