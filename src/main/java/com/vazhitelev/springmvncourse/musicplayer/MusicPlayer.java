package com.vazhitelev.springmvncourse.musicplayer;

import com.vazhitelev.springmvncourse.musictype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class MusicPlayer {
    private Music music1;
    private Music music2;
    private List<Music> listMusic = new ArrayList<>();

    @Value("${musicPlayer.playerN}")
    private String playerName;
    private int serialNumber;

    public MusicPlayer() {
    }
//    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1,
                       @Qualifier("rapMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    @Autowired
    public void setMusicList(List<Music> listMusic) {
        this.listMusic = listMusic;
    }


    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public int getSerialNumber() {
        return serialNumber;
    }
    @Value("${musicPlayer.serialNumber}")
    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }


    public void playMusic() {
        System.out.println("Сейчас играет: " + music1.getSongs(0) + ", после будет: " + music1.getSongs(1));
    }
    public void playMusicList(){
        for (Music music: listMusic) {
            System.out.println("Сейчас играет: " + music.getSong());
        }
    }
    public void playRandomSong(MusicType musicType) {
        Class classType =
                musicType == MusicType.ROCK ? RockMusic.class :
                musicType == MusicType.RAP ? RapMusic.class :
                musicType == MusicType.CLASSIC ? ClassicMusic.class : null;

        List<String> songs = null;
        String song = "Какой странный вкус музыки";

        if (classType != null) {
            songs = listMusic.stream().
                    filter(classType::isInstance).
                    flatMap(songList -> songList.getSongs().stream()).
                    collect(Collectors.toList());

            song = songs.get(new Random().nextInt(songs.size()));
        }
        System.out.println(song);
    }
}
