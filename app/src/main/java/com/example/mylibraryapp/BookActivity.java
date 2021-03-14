package com.example.mylibraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    TextView txtBookName, txtAuthor, txtPages, txtLongDesc;
    ImageView imgBookCover;
    Button btnAddToCurrentReading, btnAddToFavorites, btnAddToWishlist, btnAddToAlreadyRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        txtBookName = findViewById(R.id.txtBookNamee);
        txtAuthor = findViewById(R.id.txtAuthorNamee);
        txtPages = findViewById(R.id.txtPages);
        txtLongDesc = findViewById(R.id.txtLongDescription);
        imgBookCover = findViewById(R.id.imgBookCover);
        btnAddToAlreadyRead = findViewById(R.id.btnAddToAlreadyRead);
        btnAddToCurrentReading = findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToFavorites = findViewById(R.id.btnAddToFav);
        btnAddToWishlist = findViewById(R.id.btnAddToWishlist);
        int bookIdd = getIntent().getIntExtra("bookId", -1);

        Book book = Utils.getInstance().getBookById(bookIdd);
        if (book != null) {
            setData(book);
        }
        setData(book);
        handleIfAlreadyRead(book);
        handleCurrentlyReading(book);
        handleFavorite(book);
        handleWishlist(book);
    }

    private void handleWishlist(Book book) {
        ArrayList<Book> wishlistBookss = Utils.getWishlistBooks();
        boolean check = false;
        for (Book b : wishlistBookss) {
            if (b.getId() == book.getId()) {
                check = true;

            }
        }
        if (check) {
            btnAddToWishlist.setEnabled(false);
        } else {
            btnAddToWishlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToWishlist(book)) {
                        Toast.makeText(BookActivity.this, book.getName() + " was added to the wishlist of books", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, WishlistActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, book.getName() + " could not be added to the list", Toast.LENGTH_SHORT).show();
                    }

                }
            });


        }

    }


    private void handleFavorite(Book book) {
        ArrayList<Book> favoriteBookss = Utils.getFavoriteBooks();
        boolean check = false;
        for (Book b : favoriteBookss) {
            if (b.getId() == book.getId()) {
                check = true;

            }
        }
        if (check) {
            btnAddToFavorites.setEnabled(false);
        } else {
            btnAddToFavorites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToFavoriteBooks(book)) {
                        Toast.makeText(BookActivity.this, book.getName() + " was added to list of Favorite books", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, FavoriteBooksActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, book.getName() + " could not be added to the list", Toast.LENGTH_SHORT).show();
                    }

                }
            });


        }




    }

    private void handleCurrentlyReading(Book book){
        ArrayList<Book> currentlyReadingBookss = Utils.getCurrentlyReadingBooks();
        boolean check = false;
        for (Book b : currentlyReadingBookss) {
            if (b.getId() == book.getId()) {
                check = true;

            }
        }
        if (check) {
            btnAddToCurrentReading.setEnabled(false);
        } else {
            btnAddToCurrentReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToCurrentlyReading(book)) {
                        Toast.makeText(BookActivity.this, book.getName() + " was added to list of currently reading books", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, CurrentlyReadingActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, book.getName() + " could not be added to the list", Toast.LENGTH_SHORT).show();
                    }

                }
            });


        }



    }

    private void handleIfAlreadyRead(Book book) {
        ArrayList<Book> alreadyReadBookss = Utils.getAlreadyReadBooks();
        boolean check = false;
        for (Book b : alreadyReadBookss) {
            if (b.getId() == book.getId()) {
                check = true;

            }
        }
        if (check) {
            btnAddToAlreadyRead.setEnabled(false);
        } else {
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToAlreadyRead(book)) {
                        Toast.makeText(BookActivity.this, book.getName() + " was added to list of already read books", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, AlreadyReadBooksActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, book.getName() + " could not be added to the list", Toast.LENGTH_SHORT).show();
                    }

                }
            });


        }


    }

    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtLongDesc.setText(book.getLongDesc());
        Glide.with(this).asBitmap().load(book.getImageUrl()).into(imgBookCover);

    }
}