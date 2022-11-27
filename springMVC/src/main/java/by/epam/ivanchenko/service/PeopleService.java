package by.epam.ivanchenko.service;

import by.epam.ivanchenko.model.Mood;
import by.epam.ivanchenko.model.Person;
import by.epam.ivanchenko.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
// Методы и классы можно помечать
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> person = peopleRepository.findById(id);
        return person.orElse(null);
    }

    @Transactional                                                                                                      // Указываем, т.к. вносим изменения (вместо стандартного readOnly)
    public void save(Person person) {
        person.setCreatedAt(new Date());
        person.setMood(Mood.CALM);

        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatePerson) {
        updatePerson.setId(id);
        peopleRepository.save(updatePerson);
    }
    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

    public void test() {
        System.out.println("Testing with debug. Inside Hibernate Transaction.");
    }

}
