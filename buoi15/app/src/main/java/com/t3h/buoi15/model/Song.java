package com.t3h.buoi15.model;

import com.t3h.basemodule.models.BaseModels;

public class Song extends BaseModels {
    private String data ;
     private String title ;
    private  int duration ;
    private  int size ;
    private  String artist ;
    private  String Album ;

    public String getData() {
        return data;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public int getSize() {
        return size;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return Album;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setAlbum(String album) {
        Album = album;
    }
}
