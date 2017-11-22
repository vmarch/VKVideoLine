package com.devtolife.vkvideoline;

import static java.lang.Long.valueOf;

public class ModelVideo {

    private int id;
    private String urlImage;
    private String name;
    private int time;
    private String urlVideo;
    private String stringTimeVideo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
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

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }





    public ModelVideo(int id, String image, String name, int intTime, String urlVideo) {
        this.id = id;
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
