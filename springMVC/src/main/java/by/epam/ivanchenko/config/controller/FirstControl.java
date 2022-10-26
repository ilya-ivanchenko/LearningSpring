package by.epam.ivanchenko.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")                // все адреса в этом классе будут иметь префикс  first, т.е. first/hello
public class FirstControl {

    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request) {
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        System.out.println("Hello, " + name + " " + surname);

        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }


    @GetMapping("/calculator")
    public String calculate(@RequestParam("a") int a, @RequestParam("b") int b,
                            @RequestParam("action") String action, Model calc) {

        double result;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = a / (double) b;
                break;
            default:
                result = 0;
                break;
        }

        calc.addAttribute("result", result);
        return "first/calculator";
    }
}
