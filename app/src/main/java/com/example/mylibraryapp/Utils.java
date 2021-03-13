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
                "Marriage of the author", "A story of 3 friends who study in the same class in an engineering college" +
                "A story of 3 friends who study in the same class in an engineering college" +
                "A story of 3 friends who study in the same class in an engineering college" +
                "A story of 3 friends who study in the same class in an engineering college" +
                "A story of 3 friends who study in the same class in an engineering college" +
                "A story of 3 friends who study in the same class in an engineering college" +
                "A story of 3 friends who study in the same class in an engineering college"));
        allBooks.add(new Book(2, "5 point someone", "Chetan Bhagat", 533, "https://images-na.ssl-images-amazon.com/images/I/511wMMedbhL._SX327_BO1,204,203,200_.jpg",
                "A story of 3 friends who study in the same class in an engineering college", "This is a long desc"));
        allBooks.add(new Book(3, "Half Girlfriend", "Chetan Bhagat", 323, "https://upload.wikimedia.org/wikipedia/en/thumb/c/c6/Half_Girlfriend.jpg/220px-Half_Girlfriend.jpg",
                "Romantic tale about the friendship of 2 teens", "This is a long desc"));
        allBooks.add(new Book(4, "3 Mistakes of my life", "Chetan Bhagat", 448, "https://images-na.ssl-images-amazon.com/images/I/51nziLHeduL.jpg",
                "An amazing india story of cricket and riots", "This is a long desc"));
    }

    public Book getBookById(int id) {
        for (Book b : allBooks) {
            if (b.getId() == id) {
                return b;
            }

        }
        return null;
    }

    public boolean addToAlreadyRead(Book b)
    {
        return alreadyReadBooks.add(b);
    }

    public boolean addToCurrentlyReading(Book b)
    {
        return currentlyReadingBooks.add(b);

    }
    public boolean addToFavoriteBooks(Book b)
    {
        return favoriteBooks.add(b);
    }
    public boolean addToWishlist(Book b)
    {
        return wishlistBooks.add(b);
    }
}
