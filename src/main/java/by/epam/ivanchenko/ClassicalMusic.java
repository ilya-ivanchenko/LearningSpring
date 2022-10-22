package by.epam.ivanchenko;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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




    public void myInit() {
        System.out.println("starting initialization...");
    }

    public void myDestroy() {
        System.out.println("starting destroying...");
    }
}
