package com.example.agatarychter.androidtv;
public class Photo {

    private long id;
    private String title;
    private int image;

    public Photo(String title, int image){
        this.title = title;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Photo() {
    }

       @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                                '}';
    }

    public int getImage() {
        return image;
    }
}