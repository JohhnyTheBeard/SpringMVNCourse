package com.vazhitelev.springmvncourse.musictype;

import java.util.List;

public interface Music {
    String getSong();
    List<String> getSongs();
    String getSongs(int songNumber);
}
