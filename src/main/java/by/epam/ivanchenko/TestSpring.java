package by.epam.ivanchenko;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


//        ClassicalMusic classicalMusic = context.getBean("classicMusic", ClassicalMusic.class);
//        System.out.println(classicalMusic.getSong());

//        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//
//        boolean comparison = firstMusicPlayer == secondMusicPlayer;
//
//        firstMusicPlayer.setVolume(10);
//
////        musicPlayer.playMusic();
////
////        System.out.println(musicPlayer.getName());
////        System.out.println("volume " + musicPlayer.getVolume());
////
////        System.out.println(musicPlayer.getName());
////        System.out.println("volume " + musicPlayer.getVolume());
//        System.out.println(comparison);
//        System.out.println(firstMusicPlayer.getVolume());
//        System.out.println(secondMusicPlayer.getVolume());

//        Music music = context.getBean("classicalMusic", Music.class);
//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        musicPlayer.playMusic();
        Computer computer = context.getBean("computer", Computer.class);
//        System.out.println(computer);

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic(Genre.ROCK);
        musicPlayer.playMusic(Genre.CLASSICAL);

        context.close();
    }
}
