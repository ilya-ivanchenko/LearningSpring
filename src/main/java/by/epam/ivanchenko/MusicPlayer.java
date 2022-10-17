package by.epam.ivanchenko;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
//    private Music music;
    private List<Music> musicList = new ArrayList<>();
    private String name;


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

    public MusicPlayer() {
    }

    public MusicPlayer(List<Music> musicList){    // IoC
        this.musicList = musicList;
    }

    public void setMusic(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void playMusic(){
        for (Music x: musicList) {
            System.out.println("Now playing: " + musicList.get(musicList.indexOf(x)).getSong());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Error in thread: " + e.getMessage());
            }
        }
    }
}
