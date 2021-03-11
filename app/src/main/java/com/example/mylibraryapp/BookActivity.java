package com.example.mylibraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {
    TextView txtBookName, txtAuthor, txtPages, txtLongDesc;
    ImageView imgBookCover;
    Button btnCurrentReading, btnFavorites, btnWishlist, btnAlreadyRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        txtBookName = findViewById(R.id.txtBookNamee);
        txtAuthor = findViewById(R.id.txtAuthorNamee);
        txtPages = findViewById(R.id.txtPages);
        txtLongDesc = findViewById(R.id.txtLongDescription);
        imgBookCover = findViewById(R.id.imgBookCover);
        Book book = new Book(1, "2 States", "Chetan Bhagat", 448, "https://upload.wikimedia.org/wikipedia/en/thumb/3/3a/2_States_-_The_Story_Of_My_Marriage.jpg/220px-2_States_-_The_Story_Of_My_Marriage.jpg",
                "A story of 2 states", "A story of 3 friends who study in the same class in an engineering college." );


        setData(book);
    }

    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtLongDesc.setText(book.getLongDesc());
        Glide.with(this).asBitmap().load(book.getImageUrl()).into(imgBookCover);

    }
}