package com.vazhitelev.springmvncourse.springconfig;

import com.vazhitelev.springmvncourse.musicplayer.MusicPlayer;
import com.vazhitelev.springmvncourse.musictype.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("com.vazhitelev.springmvncourse")
@PropertySource("classpath:application.properties")
public class SpringConfig {
    @Bean
    public RockMusic rockMusic(){
        return RockMusic.getRockMusic();
    }
    @Bean
    public ClassicMusic classicMusic() {
        return new ClassicMusic();
    }
    @Bean
    public RapMusic rapMusic() {
        return new RapMusic();
    }
    @Bean
    public List<Music> musicList() {
        return Arrays.asList(rockMusic(), rapMusic(), classicMusic());
    }

    @Bean
    public MusicPlayer musicPlayer() {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.setMusicList(musicList());
        return musicPlayer;
    }

}
