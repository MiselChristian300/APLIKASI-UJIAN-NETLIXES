package com.example.netflixeslite;

public class movies {
    private String title;
    private int GambarMovie;

    public movies(String title, int gambarMovie) {
        this.title = title;
        GambarMovie = gambarMovie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGambarMovie() {
        return GambarMovie;
    }

    public void setGambarMovie(int gambarMovie) {
        GambarMovie = gambarMovie;
    }
}
