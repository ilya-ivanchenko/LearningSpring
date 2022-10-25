package by.epam.ivanchenko;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

//@Component
//@Scope("prototype")
public class ClassicalMusic implements Music {

    @Override
    public String getSong() {
        return "Zimmer";
    }

    @PostConstruct
    public void myInit() {
        System.out.println("starting initialization...");
    }

    @PreDestroy
    public void myDestroy() {
        System.out.println("starting destroying...");
    }
}
