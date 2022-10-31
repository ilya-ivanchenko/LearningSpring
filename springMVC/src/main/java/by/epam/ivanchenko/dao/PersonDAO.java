package by.epam.ivanchenko.dao;

import by.epam.ivanchenko.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component                                                              // созд. бина
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    // внедерение объекта JDBCTemplate с помощью конструктора в DAO
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SHOW_ALL_USER = "SELECT * FROM person";
    private static final String ADD_PERSON = "INSERT INTO person VALUES(1, ?, ?, ?)";
    private static final String ADD_PERSON_TEST = "INSERT INTO person VALUES(?, ?, ?, ?)";
    private static final String FIND_PERSON = "SELECT * FROM person WHERE id = ?";
    private static final String EDIT_PERSON = "UPDATE person SET name = ?, age = ?, email = ? WHERE id = ?";
    private static final String DELETE_PERSON = "DELETE FROM person WHERE  id = ?";

    public List<Person> index() {
//      return jdbcTemplate.query(SHOW_ALL_USER, new PersonMapper());
//  т.к. в PersonMapper у объекта Person такие же поля, как и в таблице в БД, то можно использовть встроенный rowMapper:
        return jdbcTemplate.query(SHOW_ALL_USER, new BeanPropertyRowMapper<>(Person.class));
    }

    /* Запросы в JDBCTemplate по умолчанию PreparedStatement
     */
    public Person show(int id) {
        return jdbcTemplate.query(FIND_PERSON, new BeanPropertyRowMapper<>(Person.class), id).stream().findAny().orElse(null);
// id - подставляем вместо ? массив объектов - так только в query. В update просто перечисляем
    }
// stream().findAny().orElse(null)  - если будет хоть один объект Person, то он будет возвращен, если  строк не найдено - то возвращено null (может быть объект Error)

    public void save(Person person) {
        jdbcTemplate.update(ADD_PERSON, person.getName(), person.getAge(), person.getEmail());
    }

    public void update(int id, Person updatePerson) {
        jdbcTemplate.update(EDIT_PERSON, updatePerson.getName(), updatePerson.getAge(), updatePerson.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update(DELETE_PERSON, id);
    }


    // тест пакетной вставки 1000 записей


    public void testMultipleUpdate() {
        List<Person> people = create1000People();

        long before = System.currentTimeMillis();

        for (Person person : people) {
            jdbcTemplate.update(ADD_PERSON_TEST, person.getId(), person.getName(), person.getAge(), person.getEmail());
        }

        long after = System.currentTimeMillis();

        System.out.println("Time: " + (after - before));               // время вставки 1000 записей
    }

    public void testBatchUpdate() {                                   // пакетная вставка 1000 записей
        List<Person> people = create1000People();

        long before = System.currentTimeMillis();

        jdbcTemplate.batchUpdate(ADD_PERSON_TEST, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, people.get(i).getId());
                preparedStatement.setString(2, people.get(i).getName());
                preparedStatement.setInt(3, people.get(i).getAge());
                preparedStatement.setString(4, people.get(i).getEmail());
            }

            @Override
            public int getBatchSize() {
                return people.size();
            }
        });

        long after = System.currentTimeMillis();

        System.out.println("Time with batch : " + (after - before));
    }

    public List<Person> create1000People() {
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            people.add(new Person(i, "Name" + i, 30, "test" + i + "@gmail.com"));
        }
        return people;
    }
}
