package by.epam.ivanchenko.controller;

import by.epam.ivanchenko.dao.PersonDAO;
import by.epam.ivanchenko.model.Person;

import by.epam.ivanchenko.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;
    private final PersonValidator personValidator;

    @Autowired
    public PeopleController(PersonDAO personDAO, PersonValidator personValidator) {
        this.personDAO = personDAO;
        this.personValidator = personValidator;
    }

    @GetMapping()                                                        //по URL /people будет вызываться метод index()
    public String index(Model peopleModel) {
        peopleModel.addAttribute("people", personDAO.index());  //получение людей и передача на View
        return "people/index";
    }

    @GetMapping("/{id}")                                                  // {}  значат, что передаваться будет значение
    public String show(@PathVariable("id") int id, Model peopleModel) {      //извлекаем id из URL
        peopleModel.addAttribute("person", personDAO.show(id));                                                                     //получение одного чел по id и передача его на View
        return "people/show";
    }

    @GetMapping("/new")
//    public String newPerson(Model peopleModel) {
//        peopleModel.addAttribute("person", new Person());
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping
    public String createPeople(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {   // валидируемый объект + объект bindingResult для ошибок валидации
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()) {
            return "people/new";
        }
        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model peopleModel, @PathVariable("id") int id) {
        peopleModel.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id) {
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()) {
            return "people/edit";
        }
        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete( @PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}
