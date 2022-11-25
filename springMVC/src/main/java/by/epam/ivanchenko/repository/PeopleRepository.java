package by.epam.ivanchenko.repository;

import by.epam.ivanchenko.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {                                              // Person - класс сущности, Integer - тип первичного ключа(класс-обертка)

    List<Person> findByName(String name);                                                                               // Пишем findBy... и название поля из класса сущности, например: name/age/email

    List<Person> findByNameOrderByAge(String name);                                                                     // Выбор по имени и сортировка по возрасту

    List<Person> findByEmail(String email);

    List<Person> findByNameStartingWith(String startingWith);                                                           // Выбор людей по начальным буквам имени

    List<Person> findByNameOrEmail(String name, String email);                                                          // Выбор людей, у которых совпало либо имя либо имейл
}
