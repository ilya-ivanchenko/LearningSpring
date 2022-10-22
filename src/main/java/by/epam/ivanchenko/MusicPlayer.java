package by.epam.ivanchenko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MusicPlayer {

//    @Autowired
//    public MusicPlayer(@Qualifier("classicalMusicList") Music music1, @Qualifier("rockMusicList") Music music2) {
//        this.music1 = music1;
//        this.music2 = music2;
//    }

//    private Music music1;
//    private Music music2;
//    private List<Music> musicList = new ArrayList<>();
//    private String name;
    @Autowired
    private ClassicalMusic classicalMusicList;
    @Autowired
    private RockMusic rockMusicList;


//    public void setMusicList(List<Music> musicList) {
//        this.musicList = musicList;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getVolume() {
//        return volume;
//    }
//
//    public void setVolume(int volume) {
//        this.volume = volume;
//    }
//
//    private int volume;


//    @Autowired
//    public void setMusic(Music music) {
//        this.music = music;
//    }

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusicList, RockMusic rockMusicList) {
        this.classicalMusicList = classicalMusicList;
        this.rockMusicList = rockMusicList;
    }


//    public MusicPlayer(List<Music> musicList) {    // IoC
//        this.musicList = musicList;
//    }
//
//    public void setMusic(List<Music> musicList) {
//        this.musicList = musicList;
//    }

    //    public void playMusic(){
//        for (Music track: musicList) {
//            System.out.println("Now playing: " + track.getSong());
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                System.out.println("Error in thread: " + e.getMessage());
//            }
//        }
//    }
    public void playMusic(Genre genre) {
        Random random = new Random();
        int randomNumber = random.nextInt(3);

        if (genre == Genre.CLASSICAL) {
            System.out.println(classicalMusicList.getSong().get(randomNumber));
        } else if (genre == Genre.ROCK) {
            System.out.println(rockMusicList.getSong().get(randomNumber));
        }
    }
}


