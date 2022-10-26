package by.epam.ivanchenko.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")                // все адреса в этом классе будут иметь префикс  first, т.е. first/hello
public class FirstControl {

    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request) {
    public String helloPage(@RequestParam("name") String name,
                            @RequestParam(value = "surname", required = false) String surname) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");

        System.out.println("Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
