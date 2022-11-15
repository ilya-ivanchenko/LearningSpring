package by.epam.ivanchenko;

import by.epam.ivanchenko.model.Passport;
import by.epam.ivanchenko.model.Person;
import by.epam.ivanchenko.model.Principal;
import by.epam.ivanchenko.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Principal.class).addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

//            Principal principal = session.get(Principal.class, 3);
//            System.out.println(principal.getName());
//            System.out.println(principal.getSchool().getSchoolNumber());

//            School school = session.get(School.class,2);
//            System.out.println(school.getSchoolNumber());
//            System.out.println(school.getPrincipal().getName());

//            Principal principal = new Principal("Nick",39);
//            School school = new School(46);
//            principal.setSchool(school);
//            session.save(principal);

//            School school = session.get(School.class, 3);
//            Principal principal = new Principal("Den", 32);
//            school.setPrincipal(principal);
//            principal.setSchool(school);
//            session.update(school);
//            session.save(principal);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
