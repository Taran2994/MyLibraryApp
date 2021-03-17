package com.example.mylibraryapp;

import android.content.Context;

import java.util.ArrayList;

public class Utils {
    DatabaseHelper dbHelper;

    private static Utils instance;
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wishlistBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;

    public static ArrayList<Book> getAllBooks() {


        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWishlistBooks() {
        return wishlistBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public static Utils getInstance(Context context) {
        if (instance == null) {
            instance = new Utils(context);
        }
        return instance;
    }

    private Utils(Context context) {
        allBooks = new ArrayList<>();
        alreadyReadBooks = new ArrayList<>();
        wishlistBooks = new ArrayList<>();
        currentlyReadingBooks = new ArrayList<>();
        favoriteBooks = new ArrayList<>();
        dbHelper = new DatabaseHelper(context);


    }


    public Book getBookById(int id) {
        for (Book b : allBooks) {
            if (b.getId() == id) {
                return b;
            }

        }
        return null;
    }

    public boolean addToAlreadyRead(Book b) {
        return alreadyReadBooks.add(b);
    }

    public boolean addToCurrentlyReading(Book b) {
        return currentlyReadingBooks.add(b);

    }

    public boolean addToFavoriteBooks(Book b) {
        return favoriteBooks.add(b);
    }

    public boolean addToWishlist(Book b) {
        return wishlistBooks.add(b);
    }


}
