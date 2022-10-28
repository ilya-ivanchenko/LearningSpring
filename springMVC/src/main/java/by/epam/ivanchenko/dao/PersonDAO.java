package by.epam.ivanchenko.dao;

import by.epam.ivanchenko.model.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component                                        // созд. бина
public class PersonDAO {
    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:mysql://localhost/people";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    private static final String SHOW_ALL_USER = "SELECT * FROM person";


    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SHOW_ALL_USER);

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));

                people.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    public Person show(int id) {
//        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        return null; //
    }


    public void save(Person person){
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);
        try {
            Statement statement = connection.createStatement();

            String ADD_NEW_USER = "INSERT INTO person VALUES (" + 1 + ", '" +  person.getName() + "', " +
            person.getAge() + ", '"  + person.getEmail() + "')";

            statement.executeUpdate(ADD_NEW_USER);
        } catch (SQLException e) {
            e.printStackTrace(); //
        }
    }

    public void update(int id, Person updatePerson){
//        Person personToBeUpdated = show(id);
//        personToBeUpdated.setName(updatePerson.getName());
//        personToBeUpdated.setAge(updatePerson.getAge());
//        personToBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
//        people.removeIf(p -> p.getId() == id);
    }
}
