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
    private static final String ADD_PERSON = "INSERT INTO person VALUES(1, ?, ?, ?)";
    private static final String FIND_PERSON = "SELECT * FROM person WHERE id = ?";
    private static final String EDIT_PERSON = "UPDATE person SET name = ?, age = ?, email = ? WHERE id = ?";
    private static final String DELETE_PERSON = "DELETE FROM person WHERE  id = ?";

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
        Person person = null;
        ResultSet resultSet;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_PERSON);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            resultSet.next();

            person = new Person();                                                          // получим только первого, если есть одинкаовые id
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getInt("age"));
            person.setEmail(resultSet.getString("email"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }


    public void save(Person person) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_PERSON);

            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); //
        }
    }

    public void update(int id, Person updatePerson) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_PERSON);

            preparedStatement.setString(1, updatePerson.getName());
            preparedStatement.setInt(2, updatePerson.getAge());
            preparedStatement.setString(3, updatePerson.getEmail());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); //
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PERSON);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); //
        }
    }
}
