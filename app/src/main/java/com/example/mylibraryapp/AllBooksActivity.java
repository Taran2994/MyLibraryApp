package com.example.mylibraryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private RecyclerView booksRecView;
    private BooksRecyclerViewAdapter adapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        booksRecView = findViewById(R.id.booksRecView);
        adapter = new BooksRecyclerViewAdapter(this,"AllBooksActivity");

        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new LinearLayoutManager(this));
        DatabaseHelper helper = new DatabaseHelper(this);


        adapter.setBookList(helper.getAllBooks());
    }
}