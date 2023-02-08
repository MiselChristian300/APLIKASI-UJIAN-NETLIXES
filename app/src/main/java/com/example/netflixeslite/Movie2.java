package com.example.netflixeslite;

public class Movie2 {
    private String title,gambarposter;
    private int gambarmovie;

    public Movie2(String title, int gambarmovie) {
        this.title = title;
        this.gambarmovie = gambarmovie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGambarmovie() {
        return gambarmovie;
    }

    public void setGambarmovie(int gambarmovie) {
        this.gambarmovie = gambarmovie;
    }
}
