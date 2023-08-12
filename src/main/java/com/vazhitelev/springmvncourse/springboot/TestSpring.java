package com.vazhitelev.springmvncourse.springboot;

import com.vazhitelev.springmvncourse.musicplayer.MusicPlayer;
import com.vazhitelev.springmvncourse.musictype.MusicType;
import com.vazhitelev.springmvncourse.springconfig.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

//        musicPlayer.playMusic();

        MusicType musicType = MusicType.values()[new Random().nextInt(4)];
        System.out.println(musicType);
        musicPlayer.playRandomSong(musicType);

        System.out.println(musicPlayer.getPlayerName());
        System.out.println(musicPlayer.getSerialNumber());

        context.close();
    }
}
