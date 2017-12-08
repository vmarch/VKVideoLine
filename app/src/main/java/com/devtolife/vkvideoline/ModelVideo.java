package com.devtolife.vkvideoline;

import static java.lang.Long.valueOf;

public class ModelVideo {

    private int idVideo;
    private int ownerIdVideo;
    private String urlImage;
    private String name;
    private int time;
    private String urlVideo;
    private String stringTimeVideo;
    public String urlOfVideo;

    public int getIdVideo() {
        return idVideo;
    }

    public int getOwnerIdVideo() {
        return ownerIdVideo;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public ModelVideo(int idVideo, int ownerId, String image, String name, int intTime, String urlVideo) {
        this.idVideo = idVideo;
        this.ownerIdVideo = ownerId;
        this.urlImage = image;
        this.name = name;
        this.time = intTime;
        this.urlVideo = urlVideo;
        getTime();
    }

    public ModelVideo(String image, String name, int intTime, String urlVideo) {
        this.urlImage = image;
        this.name = name;
        this.time = intTime;
        this.urlVideo = urlVideo;
        getTime();
    }

    public String getTime() {

        Long minutes = valueOf(time % 3600 / 60);
        Long seconds = valueOf(time % 60);

        if (minutes < 10 && seconds < 10) {
            stringTimeVideo = String.valueOf("0" + minutes + ":" + "0" + seconds);
        } else if (minutes >= 10 && seconds < 10) {
            stringTimeVideo = String.valueOf(minutes + ":" + "0" + seconds);
        } else if (minutes < 10 && seconds >= 10) {
            stringTimeVideo = String.valueOf("0" + minutes + ":" + seconds);
        } else if (minutes >= 10 && seconds >= 10) {
            stringTimeVideo = String.valueOf(minutes + ":" + seconds);
        }
        return stringTimeVideo;
    }
}
