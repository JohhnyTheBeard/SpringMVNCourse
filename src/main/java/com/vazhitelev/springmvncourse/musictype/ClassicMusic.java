package com.vazhitelev.springmvncourse.musictype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class ClassicMusic implements Music {
    private String name = "Symphony №3";
    @Value("#{'${classicMusicList}'.split(',')}")
    private List<String> classicMusicList = new ArrayList<>();

    @Override
    public String getSong() {
        return name;
    }

    @Override
    public List<String> getSongs() {
        return classicMusicList;
    }

    @Override
    public String getSongs(int songNumber) {
        return null;
    }
}
