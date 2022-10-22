package by.epam.ivanchenko;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class ClassicalMusic implements Music {
    List<String> classicalMusicList = new ArrayList<>();

     {
        classicalMusicList.add("Vivaldi");
        classicalMusicList.add("Bah");
        classicalMusicList.add("Zimmer");
    }

    @Override
    public List<String> getSong() {
        return classicalMusicList;
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
