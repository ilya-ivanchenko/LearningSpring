package by.epam.ivanchenko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private int id;
    private Genre genre;
    private MusicPlayer musicPlayer;

//    @Override
//    public String toString() {
//        return "Computer: " + id + ". " + musicPlayer.playMusic(Genre.ROCK);
//    }


@Autowired
    public Computer(MusicPlayer musicPlayer) {
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }
}
