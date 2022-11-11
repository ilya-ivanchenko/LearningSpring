package by.epam.ivanchenko;

import by.epam.ivanchenko.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);      //передаем класс, помеч. Entity

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

//            List<Person> people  = session.createQuery("FROM Person WHERE name LIKE 'J%'").getResultList();   // HQL - запрос
//            session.createQuery("UPDATE Person SET name='Test' WHERE age < 25").executeUpdate();
            session.createQuery("DELETE FROM Person WHERE age < 25").executeUpdate();

//            for(Person person : people) {
//                System.out.println(person);
//            }

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
