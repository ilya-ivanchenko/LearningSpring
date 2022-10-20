package by.epam.ivanchenko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicPlayer {

    private Music music;
    private List<Music> musicList = new ArrayList<>();
    private String name;
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    private int volume;


//    @Autowired
//    public void setMusic(Music music) {
//        this.music = music;
//    }


    public MusicPlayer() {
    }


    public MusicPlayer(List<Music> musicList){    // IoC
        this.musicList = musicList;
    }

    public void setMusic(List<Music> musicList) {
        this.musicList = musicList;
    }

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
public String playMusic(){
        return "Now playing: " + classicalMusic.getSong();

        }
 }


