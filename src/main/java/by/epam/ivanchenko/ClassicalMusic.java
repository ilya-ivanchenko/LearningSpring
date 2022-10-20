package by.epam.ivanchenko;


import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music{
    private ClassicalMusic() {
    }

    public static ClassicalMusic myFactoryMethod() {
        return new ClassicalMusic();
    }
    @Override
    public String getSong() {
        return "Times of the year - Vivaldi";
    }

    public void myInit() {
        System.out.println("starting initialization...");
    }

    public void myDestroy() {
        System.out.println("starting destroying...");
    }
}
