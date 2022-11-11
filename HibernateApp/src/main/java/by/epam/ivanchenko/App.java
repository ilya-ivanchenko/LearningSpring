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

//           Person person1 = new Person("Test1", 30);
//           Person person2 = new Person("Test2", 25);
//           Person person3 = new Person("Test3", 28);
//           session.save(person1);
//           session.save(person2);
//           session.save(person3);

//           Person person =  session.get(Person.class,2);
//           person.setName("New name");

//            session.delete(person);
            Person person = new Person("Some person", 40);
            session.save(person);

            session.getTransaction().commit();

            System.out.println(person.getId());

        } finally {
            sessionFactory.close();
        }
    }
}
