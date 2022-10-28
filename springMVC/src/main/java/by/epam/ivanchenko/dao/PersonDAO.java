package by.epam.ivanchenko.dao;

import by.epam.ivanchenko.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component                                        // созд. бина
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;


    //вместо конструктора исп. блок инициализации
    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 25, "tom@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT,"Jeff", 42, "jeff@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT,"Mike", 35, "mike@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT,"Ilya", 37, "ilya@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
