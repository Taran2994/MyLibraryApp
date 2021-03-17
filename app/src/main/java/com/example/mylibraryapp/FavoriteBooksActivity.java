package com.example.mylibraryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class FavoriteBooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_books);
        RecyclerView favBookRecView = findViewById(R.id.favoriteBookRecyView);
        BooksRecyclerViewAdapter adapter = new BooksRecyclerViewAdapter(this, "FavoriteBooksActivity");
        favBookRecView.setAdapter(adapter);
        favBookRecView.setLayoutManager(new LinearLayoutManager(this));
        DatabaseHelper helper = new DatabaseHelper(this);

        adapter.setBookList(helper.getFavoriteBooks());
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}