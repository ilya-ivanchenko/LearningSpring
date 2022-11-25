package by.epam.ivanchenko.repository;

import by.epam.ivanchenko.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {                                               // Person - класс сущности, Integer - тип первичного ключа(класс-обертка)
}
