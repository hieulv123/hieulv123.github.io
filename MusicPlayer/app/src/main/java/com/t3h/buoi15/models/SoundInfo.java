package com.t3h.buoi15.models;

public class SoundInfo {
    private boolean isStarting ;
    private boolean isPlaying ;
    private String name ;
    private int duration ;

    public void setStarting(boolean starting) {
        isStarting = starting;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isStarting() {
        return isStarting;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getPosition() {
        return position;
    }

    private int position ;
}
