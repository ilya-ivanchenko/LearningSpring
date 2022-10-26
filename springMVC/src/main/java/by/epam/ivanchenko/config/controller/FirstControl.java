package by.epam.ivanchenko.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")                // все адреса в этом классе будут иметь префикс  first, т.е. first/hello
public class FirstControl {

    @GetMapping("/hello")
    public String helloPage() {
        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodByePage() {
        return"first/goodbye";
    }
}
