package by.epam.ivanchenko.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondControl {
    @GetMapping("/exit")
    public String exit() {
        return "second/exit";
    }
}
