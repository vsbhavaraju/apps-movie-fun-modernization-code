package org.superbiz.moviefun.albumsui;

import java.util.Objects;

public class AlbumInfo {


    private Long id;
    private String artist;
    private String title;
    private int year;
    private int rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumInfo albumInfo = (AlbumInfo) o;
        return year == albumInfo.year &&
                rating == albumInfo.rating &&
                Objects.equals(id, albumInfo.id) &&
                Objects.equals(artist, albumInfo.artist) &&
                Objects.equals(title, albumInfo.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, artist, title, year, rating);
    }



    public AlbumInfo(String artist, String title, int year, int rating) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    public AlbumInfo(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }




}
