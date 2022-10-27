package by.epam.ivanchenko.controller;

import by.epam.ivanchenko.dao.PersonDAO;
import by.epam.ivanchenko.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

//    @Autowired                                                              //внедрение объекта personDAO
    private final PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
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
    public String createPeople(@ModelAttribute("person")Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }
}
