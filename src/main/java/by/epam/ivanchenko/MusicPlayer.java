package by.epam.ivanchenko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//@Component
public class MusicPlayer {

//    @Autowired
    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;

    }

    private List<Music> musicList;
//    private Music music1;
//    private Music music2;
//    private List<Music> musicList = new ArrayList<>();
    @Value("${musicPlayer.name}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;
//    @Autowired
//    private ClassicalMusic classicalMusicList;
//    @Autowired
//    private RockMusic rockMusicList;
//    private RapMusic rapMusicList;


//    public void setMusicList(List<Music> musicList) {
//        this.musicList = musicList;
//    }
//
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




//    @Autowired
//    public void setMusic(Music music) {
//        this.music = music;
//    }

//    @Autowired
//    public MusicPlayer(ClassicalMusic classicalMusicList, RockMusic rockMusicList) {
//        this.classicalMusicList = classicalMusicList;
//        this.rockMusicList = rockMusicList;
//    }


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


    public String playMusic() {
        Random random = new Random();
        int randomNumber = random.nextInt(musicList.size());

        return "Now Playing: " + musicList.get(randomNumber).getSong() + "\nVolume " + volume + "\nDevice: " + name;
    }
}


