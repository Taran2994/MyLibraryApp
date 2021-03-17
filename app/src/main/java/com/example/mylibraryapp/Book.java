package com.example.mylibraryapp;

public class Book {
    private int id, pages, currently_reading, already_read, wishlist, favorites;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrently_reading() {
        return currently_reading;
    }

    public void setCurrently_reading(int currently_reading) {
        this.currently_reading = currently_reading;
    }

    public int getAlready_read() {
        return already_read;
    }

    public void setAlready_read(int already_read) {
        this.already_read = already_read;
    }

    public int getWishlist() {
        return wishlist;
    }

    public void setWishlist(int wishlist) {
        this.wishlist = wishlist;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", pages=" + pages +
                ", currently_reading=" + currently_reading +
                ", already_read=" + already_read +
                ", wishlist=" + wishlist +
                ", favorites=" + favorites +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                '}';
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public Book(int id, String name, String author, int pages, String imageUrl, String shortDesc, String longDesc, int currently_reading, int already_read, int wishlist, int favorites) {
        this.id = id;
        this.pages = pages;
        this.name = name;
        this.author = author;
        this.imageUrl = imageUrl;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.currently_reading = currently_reading;
        this.already_read = already_read;
        this.wishlist = wishlist;
        this.favorites = favorites;
    }

    private String name, author, imageUrl, shortDesc, longDesc;
}
