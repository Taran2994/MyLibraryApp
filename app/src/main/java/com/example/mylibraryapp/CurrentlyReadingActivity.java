package com.example.mylibraryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class CurrentlyReadingActivity extends AppCompatActivity {
    RecyclerView currentlyRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading);
        currentlyRecView=findViewById(R.id.CurrentlyReadingRecView);
        BooksRecyclerViewAdapter adapter= new BooksRecyclerViewAdapter(this);
        currentlyRecView.setAdapter(adapter);
        currentlyRecView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBookList(Utils.getCurrentlyReadingBooks());
    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}