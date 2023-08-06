package com.vazhitelev.springmvncourse.musictype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RapMusic implements Music {
    private String name = "Gangsta's paradise";
    @Value("#{'${rapMusicList}'.split(',')}")
    private List<String> rapMusicList = new ArrayList<>();

    @Override
    public String getSong() {
        return name;
    }

    @Override
    public List<String> getSongs() {
        return rapMusicList;
    }
    @Override
    public String getSongs(int songNumber) {
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
