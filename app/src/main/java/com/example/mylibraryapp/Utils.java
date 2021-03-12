package com.example.mylibraryapp;

import java.util.ArrayList;

public class Utils {

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

    public static Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    private Utils() {
        allBooks = new ArrayList<>();
        alreadyReadBooks = new ArrayList<>();
        wishlistBooks = new ArrayList<>();
        currentlyReadingBooks = new ArrayList<>();
        favoriteBooks = new ArrayList<>();

        initData();
    }

    private void initData() {

        allBooks.add(new Book(1, "2 States", "Chetan Bhagat", 448, "https://upload.wikimedia.org/wikipedia/en/thumb/3/3a/2_States_-_The_Story_Of_My_Marriage.jpg/220px-2_States_-_The_Story_Of_My_Marriage.jpg",
                "A story of 2 states", "A story of 3 friends who study in the same class in an engineering college" +
                "A story of 3 friends who study in the same class in an engineering college" +
                "A story of 3 friends who study in the same class in an engineering college" +
                "A story of 3 friends who study in the same class in an engineering college" +
                "A story of 3 friends who study in the same class in an engineering college" +
                "A story of 3 friends who study in the same class in an engineering college" +
                "A story of 3 friends who study in the same class in an engineering college"));
        allBooks.add(new Book(2, "3 Idiots", "Chetan Bhagat", 448, "https://upload.wikimedia.org/wikipedia/en/thumb/3/3a/2_States_-_The_Story_Of_My_Marriage.jpg/220px-2_States_-_The_Story_Of_My_Marriage.jpg",
                "A story of 3 friends who study in the same class in an engineering college", "This is a long desc"));
        allBooks.add(new Book(3, "Half Girlfriend", "Chetan Bhagat", 448, "https://upload.wikimedia.org/wikipedia/en/thumb/3/3a/2_States_-_The_Story_Of_My_Marriage.jpg/220px-2_States_-_The_Story_Of_My_Marriage.jpg",
                "A story of 2 states", "This is a long desc"));
        allBooks.add(new Book(4, "3 Mistakes of my life", "Chetan Bhagat", 448, "https://upload.wikimedia.org/wikipedia/en/thumb/3/3a/2_States_-_The_Story_Of_My_Marriage.jpg/220px-2_States_-_The_Story_Of_My_Marriage.jpg",
                "A story of 2 states", "This is a long desc"));
    }

    public Book getBookById(int id) {
        for (Book b : allBooks) {
            if (b.getId() == id) {
                return b;
            }

        }
        return null;
    }
}
