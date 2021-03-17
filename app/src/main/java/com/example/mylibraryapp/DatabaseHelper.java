package com.example.mylibraryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "BooksDatabse";
    private static final String TABLE_NAME = "books_table";
    private static final String COLUMN_ID = "book_id";
    private static final String COLUMN_BOOK = "book_name";
    private static final String COLUMN_AUTHOR = "author";
    private static final String COLUMN_PAGES = "pages";
    private static final String COLUMN_IMGURL = "img_url";

    private static final String COLUMN_SHORTDESC = "short_desc";
    private static final String COLUMN_LONGDESC = "long_desc";
    private static final String COLUMN_CURRENT = "curr_read";
    private static final String COLUMN_ALREADY = "already_read";
    private static final String COLUMN_WISHLIST = "wishlist";
    private static final String COLUMN_FAVORITES = "favorites";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER NOT NULL CONSTRAINT book_pk PRIMARY KEY, " +
                COLUMN_BOOK + " varchar(200) NOT NULL, " +
                COLUMN_AUTHOR + " varchar(200) NOT NULL, " +
                COLUMN_PAGES + " INTEGER NOT NULL, " +
                COLUMN_IMGURL + " TEXT NOT NULL, " +
                COLUMN_SHORTDESC + " TEXT NOT NULL, " +
                COLUMN_LONGDESC + " TEXT NOT NULL, " +
                COLUMN_CURRENT + " INTEGER NOT NULL, " +
                COLUMN_ALREADY + " INTEGER NOT NULL, " +
                COLUMN_WISHLIST + " INTEGER NOT NULL, " +
                COLUMN_FAVORITES + " INTEGER NOT NULL );";
        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = " DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        db.execSQL(sql);
        onCreate(db);

    }

    public boolean addBook(int id, String book_name, String author, int pages, String imgUrl, String short_desc, String long_desc,
                           int currently_reading, int already_read, int wishlist, int favorites) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, id);
        cv.put(COLUMN_BOOK, book_name);
        cv.put(COLUMN_AUTHOR, author);
        cv.put(COLUMN_PAGES, pages);
        cv.put(COLUMN_IMGURL, imgUrl);
        cv.put(COLUMN_SHORTDESC, short_desc);
        cv.put(COLUMN_LONGDESC, long_desc);
        cv.put(COLUMN_CURRENT, currently_reading);
        cv.put(COLUMN_ALREADY, already_read);
        cv.put(COLUMN_WISHLIST, wishlist);
        cv.put(COLUMN_FAVORITES, favorites);
        return sqLiteDatabase.insert(TABLE_NAME, null, cv) != -1;


    }


    public boolean addToCurrentlyReadingBooks(Book book) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_CURRENT, 1);
        Boolean b = sqLiteDatabase.update(TABLE_NAME, cv, COLUMN_ID + "=?", new String[]{String.valueOf(book.getId())}) > 0;
        sqLiteDatabase.close();
        return b;

    }

    public boolean addToFavorites(Book book) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_FAVORITES, 1);
        Boolean b = sqLiteDatabase.update(TABLE_NAME, cv, COLUMN_ID + "=?", new String[]{String.valueOf(book.getId())}) > 0;
        sqLiteDatabase.close();
        return b;

    }

    public boolean addToWishlist(Book book) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_WISHLIST, 1);
        Boolean b = sqLiteDatabase.update(TABLE_NAME, cv, COLUMN_ID + "=?", new String[]{String.valueOf(book.getId())}) > 0;
        sqLiteDatabase.close();
        return b;

    }

    public boolean addToAlreadyRead(Book book) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ALREADY, 1);
        Boolean b = sqLiteDatabase.update(TABLE_NAME, cv, COLUMN_ID + "=?", new String[]{String.valueOf(book.getId())}) > 0;
        sqLiteDatabase.close();
        return b;

    }


    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> allBooksList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                Book book = new Book(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                        cursor.getInt(7), cursor.getInt(8), cursor.getInt(9), cursor.getInt(10));
                allBooksList.add(book);


            } while (cursor.moveToNext());
            cursor.close();
        }
        return allBooksList;


    }

    public ArrayList<Book> getCurrentlyReadingBooks() {
        ArrayList<Book> currentlyRead = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_CURRENT + " = 1", null);

        if (cursor.moveToFirst()) {
            do {
                Book book = new Book(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                        cursor.getInt(7), cursor.getInt(8), cursor.getInt(9), cursor.getInt(10));
                currentlyRead.add(book);


            } while (cursor.moveToNext());
            cursor.close();
        }
        return currentlyRead;


    }

    public ArrayList<Book> getAlreadReadBooks() {
        ArrayList<Book> alreadyRead = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ALREADY + " = 1", null);

        if (cursor.moveToFirst()) {
            do {
                Book book = new Book(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                        cursor.getInt(7), cursor.getInt(8), cursor.getInt(9), cursor.getInt(10));
                alreadyRead.add(book);


            } while (cursor.moveToNext());
            cursor.close();
        }
        return alreadyRead;


    }

    public ArrayList<Book> getWishlistBooks() {
        ArrayList<Book> wishlistBooks = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_WISHLIST + " = 1", null);

        if (cursor.moveToFirst()) {
            do {
                Book book = new Book(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                        cursor.getInt(7), cursor.getInt(8), cursor.getInt(9), cursor.getInt(10));
                wishlistBooks.add(book);


            } while (cursor.moveToNext());
            cursor.close();
        }
        return wishlistBooks;


    }

    public ArrayList<Book> getFavoriteBooks() {
        ArrayList<Book> favBooks = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_FAVORITES + " = 1", null);

        if (cursor.moveToFirst()) {
            do {
                Book book = new Book(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                        cursor.getInt(7), cursor.getInt(8), cursor.getInt(9), cursor.getInt(10));
                favBooks.add(book);


            } while (cursor.moveToNext());
            cursor.close();
        }
        return favBooks;


    }

    public boolean removeFromAlreadyRead(Book book) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ALREADY, 0);
        Boolean b = sqLiteDatabase.update(TABLE_NAME, cv, COLUMN_ID + "=?", new String[]{String.valueOf(book.getId())}) > 0;
        sqLiteDatabase.close();
        return b;

    }

    public boolean removeFromCurrentlyReading(Book book) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_CURRENT, 0);
        Boolean b = sqLiteDatabase.update(TABLE_NAME, cv, COLUMN_ID + "=?", new String[]{String.valueOf(book.getId())}) > 0;
        sqLiteDatabase.close();
        return b;
    }

    public boolean removeFromFavorites(Book book) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_FAVORITES, 0);
        Boolean b = sqLiteDatabase.update(TABLE_NAME, cv, COLUMN_ID + "=?", new String[]{String.valueOf(book.getId())}) > 0;
        sqLiteDatabase.close();

        return b;

    }

    public boolean removeFromWishlist(Book book) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_WISHLIST, 0);
        Boolean b = sqLiteDatabase.update(TABLE_NAME, cv, COLUMN_ID + "=?", new String[]{String.valueOf(book.getId())}) > 0;
        sqLiteDatabase.close();

        return b;
    }


    public Book getBook(int id) {
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.query(TABLE_NAME,
                null, "book_id=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        Book book = new Book(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                cursor.getInt(7), cursor.getInt(8), cursor.getInt(9), cursor.getInt(10));
        db.close();
        return book;

    }

    public void initData() {


        if (getAllBooks().size() == 0) {
            addBook(1, "2 States", "Chetan Bhagat", 448, "https://upload.wikimedia.org/wikipedia/en/thumb/3/3a/2_States_-_The_Story_Of_My_Marriage.jpg/220px-2_States_-_The_Story_Of_My_Marriage.jpg",
                    "Marriage of the author", "A story of 3 friends who study in the same class in an engineering college" +
                            "A story of 3 friends who study in the same class in an engineering college" +
                            "A story of 3 friends who study in the same class in an engineering college" +
                            "A story of 3 friends who study in the same class in an engineering college" +
                            "A story of 3 friends who study in the same class in an engineering college" +
                            "A story of 3 friends who study in the same class in an engineering college" +
                            "A story of 3 friends who study in the same class in an engineering college", 0, 0, 0, 0);
            addBook(2, "5 point someone", "Chetan Bhagat", 533, "https://images-na.ssl-images-amazon.com/images/I/511wMMedbhL._SX327_BO1,204,203,200_.jpg",
                    "A story of 3 friends who study in the same class in an engineering college", "This is a long desc", 0, 0, 0, 0);
            addBook(3, "Half Girlfriend", "Chetan Bhagat", 323, "https://upload.wikimedia.org/wikipedia/en/thumb/c/c6/Half_Girlfriend.jpg/220px-Half_Girlfriend.jpg",
                    "Romantic tale about the friendship of 2 teens", "This is a long desc", 0, 0, 0, 0);
            addBook(4, "3 Mistakes of my life", "Chetan Bhagat", 448, "https://images-na.ssl-images-amazon.com/images/I/51nziLHeduL.jpg",
                    "An amazing india story of cricket and riots", "This is a long desc", 0, 0, 0, 0);

        }


    }

}
