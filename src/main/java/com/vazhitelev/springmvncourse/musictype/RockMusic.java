package com.vazhitelev.springmvncourse.musictype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusic implements Music {
    @Value("#{'${rockMusicList}'.split(',')}")
    private List<String> rockMusicList = new ArrayList<>();
    private String name = "Rock you like a hurricane";

    private RockMusic() {
    }

    public static RockMusic getRockMusic() {
        return new RockMusic();
    }
    @Override
    public String getSong() {
        return name;
    }
    public List<String> getSongs() {
        return rockMusicList;
    }

    public String getSongs(int songNumber) {
        return rockMusicList.get(songNumber);
    }

    @Override
    public String toString() {
        return name;
    }
    public void doMyInit() {
        System.out.println("Initialisation complete!");
    }
    public void doMyDestroy() {
        System.out.println("Destroying complete!");
    }
}
