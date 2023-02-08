package com.example.netflixeslite;

public class tvshow {
    private String namaTv;
    private int gambartv;

    public String getNamaTv() {
        return namaTv;
    }

    public void setNamaTv(String namaTv) {
        this.namaTv = namaTv;
    }

    public int getGambartv() {
        return gambartv;
    }

    public void setGambartv(int gambartv) {
        this.gambartv = gambartv;
    }

    public tvshow(String namaTv, int gambartv) {
        this.namaTv = namaTv;
        this.gambartv = gambartv;

    }
}
