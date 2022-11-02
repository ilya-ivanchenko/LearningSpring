package by.epam.ivanchenko.util;

import by.epam.ivanchenko.dao.PersonDAO;
import by.epam.ivanchenko.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);         // проверяем, чтобы валидация была только на классе Person (на др. сущностях - др. валидация)
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
                                                   // проверяем, есть ли чел. с таким же email в БД
        if(personDAO.show(person.getEmail()).isPresent()) {    //вместо проверки на  null
            errors.rejectValue("email", "", "Email is already exist");
        }
    }
}
