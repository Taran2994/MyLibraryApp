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
                    "Marriage of the author", "2 States: The Story of My Marriage is autobiographical with only names changed. The story is about a couple Krish and Ananya, who hail from two different states of India, Punjab and Tamil Nadu, respectively, who are deeply in love and want to marry. It is narrated from a first person point of view in a humorous tone, often taking digs at both Tamil and Punjabi cultures.\n" +
                            "\n" +
                            "The story begins in the IIM Ahmedabad mess hall where Krish, a Punjabi boy from Delhi sights a beautiful girl Ananya, a Tamilian from Chennai quarreling with the mess staff about the food. Ananya was tagged as the \"Best girl of the fresher batch\". They become friends within a few days. Both graduate and get jobs with serious plans for their wedding. At first, Krish tries to convince his girlfriend Ananya's parents by helping Ananya's brother Manju IIT tuition and by helping her father Swaminathan create his first PowerPoint presentation. He later convinces her mom by helping her fulfill her biggest dream of singing at a concert by arranging for her to perform at the concert organised by Krish's employer City Bank.\n" +
                            "\n" +
                            "With Ananya's parents convinced, the couple then has to convince Krish's mother. But they run into problems as Krish's mother's relatives don't quite like the relationship and do not want Krish to marry a Tamilian. They are won over after Ananya intervenes to help one of Krish's cousins get married. Now as they have convinced both their parents, they decide to make a trip to Goa to give their parents an opportunity to get to know each other. But this too ends badly as Ananya's parents have a fallout with Krish's mother after which they leave, deciding that the families can never get along with each other. Krish returns home and becomes a depressed workaholic.\n" +
                            "\n" +
                            "It is shown throughout the story that Krish was not on good terms with his father and doesn't share a close bond with him. But finally, it is revealed that Krish's father travels to Chennai to meet Ananya's parents and successfully convinces them, by spending a whole day. Thus, father and son are reconciled and the novel ends with Ananya giving birth to twin boys. Krish says that the babies belong to a state called 'India', with a thought to end inequality.", 0, 0, 0, 0);
            addBook(2, "5 point someone", "Chetan Bhagat", 533, "https://images-na.ssl-images-amazon.com/images/I/511wMMedbhL._SX327_BO1,204,203,200_.jpg",
                    "A story of 3 friends who study in the same class in an engineering college", "The book is narrated by Hari, with some small passages by his friends Ryan and Alok, as well as a letter by Hari's girlfriend Neha Cherian. It deals with the lives of the 3 friends, whose elation on making it to one of the best engineering colleges in India is quickly deflated by the rigour and monotony of the academic work. Most of the book deals with the numerous attempts by the trio to cope with and/or beat the system as well as Hari's fling with Neha who just happens to be the daughter of Prof. Cherian, the domineering head of the Mechanical Engineering department of their college. It takes some dark turns every now and then, especially when it comes to the families of the protagonists. Most of the action, however, takes place inside the campus as the boys, led by the ever creative Ryan, frequently lamenting how the internationally lauded IIT system has stifled their creativity by forcing them to value grades more than anything else. Uninspiring teaching" +
                            " and numerous assignments add to their woes, though the boys do find a sympathiser in Prof Veera.", 0, 0, 0, 0);
            addBook(3, "Half Girlfriend", "Chetan Bhagat", 323, "https://upload.wikimedia.org/wikipedia/en/thumb/c/c6/Half_Girlfriend.jpg/220px-Half_Girlfriend.jpg",
                    "Half Girlfriend is an Indian English coming of age, young adult romance novel by Indian author Chetan Bhagat.", "Half Girlfriend is an Indian English coming of age, young adult romance novel by Indian author Chetan Bhagat.[1] The novel, set in rural Bihar, New Delhi, Patna, and New York, is the story of a Bihari boy in quest of winning over the girl he loves.[2][3] This is Bhagat's sixth novel which was released on 1 October 2014[4] by Rupa Publications. The novel has also been published in Hindi[5] and Gujarati.[6]\n" +
                            "\n" +
                            "Dedicated to \"non English-types\", as Chetan Bhagat wrote, the book divulges the sentiments and linguistic struggles of a backward rural Bhojpuri-laced Hindi-speaking boy from Bihar as he enrolls himself at the prestigious English-medium St. Stephen’s College, New Delhi, and falls in love with a \"high class English-speaking rich Delhi girl\" schooled at Modern School, New Delhi. The girl does not admit the relationship but agrees to be his \"half girlfriend\".[7] Chetan Bhagat commented, \"Half-Girlfriend, to me, is a unique Indian phenomenon, where boys and girls are not clear about their relationship status with each other. A boy may think he is more than friends with the girl, but the girl is still not his girlfriend. Hence, I thought we needed a term like 'Half girlfriend'. Because, in India, that is what most men get.", 0, 0, 0, 0);
            addBook(4, "3 Mistakes of my life", "Chetan Bhagat", 448, "https://images-na.ssl-images-amazon.com/images/I/51nziLHeduL.jpg",
                    "The novel follows the story of three friends and is based in the city of Ahmedabad in western India.", "In late-2000, a young boy in Ahmedabad called Govind dreamt of having a business. To accomodate his friends Ish and Omi's passion, they open a cricket shop. Govind's wants to make money and thinks big. Ish is all about nurturing Ali, the batsman with a rare gift. Omi knows his limited capabiltiies and just wants to be with his friends. However, nothing comes easy in a turbulent city. To realize their goals, they will have to face it all - religious politics, earthquakes, riots, unacceptable love and above all, their own mistakes. Will they make it? Can an individual's dreams overcome the nightmares offered by real life? Can we succeed despite a few mistakes?", 0, 0, 0, 0);

        }


    }

}
