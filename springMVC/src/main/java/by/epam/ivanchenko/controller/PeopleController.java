package by.epam.ivanchenko.controller;

//import by.epam.ivanchenko.dao.PersonDAO;
import by.epam.ivanchenko.model.Person;

import by.epam.ivanchenko.service.ItemService;
import by.epam.ivanchenko.service.PeopleService;
//import by.epam.ivanchenko.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

//    private final PersonDAO personDAO;
    private final PeopleService peopleService;
//    private final PersonValidator personValidator;
    private final ItemService itemService;

    @Autowired
    public PeopleController(PeopleService peopleService, ItemService itemService) {
        this.peopleService = peopleService;
        this.itemService = itemService;
    }

    @GetMapping()                                                        //по URL /people будет вызываться метод index()
    public String index(Model peopleModel) {
        peopleModel.addAttribute("people", peopleService.findAll());

        itemService.findByItemName("Airpods");
        itemService.findByOwner(peopleService.findAll().get(0));

        peopleService.test();

        return "people/index";
    }

    @GetMapping("/{id}")                                                  // {}  значат, что передаваться будет значение
    public String show(@PathVariable("id") int id, Model peopleModel) {      //извлекаем id из URL
        peopleModel.addAttribute("person", peopleService.findOne(id));
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
//        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()) {
            return "people/new";
        }
        peopleService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model peopleModel, @PathVariable("id") int id) {
        peopleModel.addAttribute("person", peopleService.findOne(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id) {
//        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()) {
            return "people/edit";
        }
        peopleService.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete( @PathVariable("id") int id) {
        peopleService.delete(id);
        return "redirect:/people";
    }

    //
}
