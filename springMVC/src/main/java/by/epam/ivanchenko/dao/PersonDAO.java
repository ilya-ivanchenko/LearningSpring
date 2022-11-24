package by.epam.ivanchenko.dao;

import by.epam.ivanchenko.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

//    private static final String SHOW_ALL_USER = "SELECT * FROM person";
//    private static final String ADD_PERSON = "INSERT INTO person (name, age, email, address) VALUES(?, ?, ?, ?)";
//    private static final String ADD_PERSON_TEST = "INSERT INTO person VALUES(?, ?, ?, ?)";
//    private static final String FIND_PERSON = "SELECT * FROM person WHERE id = ?";
//    private static final String FIND_PERSON_EMAIL = "SELECT * FROM person WHERE email = ?";
//    private static final String EDIT_PERSON = "UPDATE person SET name = ?, age = ?, email = ?, address = ? WHERE id = ?";
//    private static final String DELETE_PERSON = "DELETE FROM person WHERE  id = ?";

    private static final String SHOW_ALL_USER_HQL = "select p from Person p";
    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /*  Tут не надо вручную управлять транзакцией(beginTransaction(), commit() ....), как в  чистом Hibernate.
     * После выполнения всех строк метода транзакция будет commit
     */
    @Transactional(readOnly = true)                                                                         // В этой транзакции мы только читаем данные, не внося изменений (good practice)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();
        List<Person> people = session.createQuery(SHOW_ALL_USER_HQL, Person.class).getResultList();          // HQL

        return people;
    }

    public Person show(int id) {
        return null;
    }

    public Optional<Person> show(String email) {
        return null;
    }

    public void save(Person person) {

    }

    public void update(int id, Person updatePerson) {

    }

    public void delete(int id) {

    }


//    // тест пакетной вставки 1000 записей
//
//
//    public void testMultipleUpdate() {
//        List<Person> people = create1000People();
//
//        long before = System.currentTimeMillis();
//
//        for (Person person : people) {
//            jdbcTemplate.update(ADD_PERSON_TEST, person.getId(), person.getName(), person.getAge(), person.getEmail());
//        }
//
//        long after = System.currentTimeMillis();
//
//        System.out.println("Time: " + (after - before));               // время вставки 1000 записей
//    }
//
//    public void testBatchUpdate() {                                   // пакетная вставка 1000 записей
//        List<Person> people = create1000People();
//
//        long before = System.currentTimeMillis();
//
//        jdbcTemplate.batchUpdate(ADD_PERSON_TEST, new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
//                preparedStatement.setInt(1, people.get(i).getId());
//                preparedStatement.setString(2, people.get(i).getName());
//                preparedStatement.setInt(3, people.get(i).getAge());
//                preparedStatement.setString(4, people.get(i).getEmail());
//            }
//
//            @Override
//            public int getBatchSize() {
//                return people.size();
//            }
//        });
//
//        long after = System.currentTimeMillis();
//
//        System.out.println("Time with batch : " + (after - before));
//    }
//
//    public List<Person> create1000People() {
//        List<Person> people = new ArrayList<>();
//
//        for (int i = 0; i < 1000; i++) {
//            people.add(new Person(i, "Name" + i, 30, "test" + i + "@gmail.com", "my address"));
//        }
//        return people;
//    }
}
