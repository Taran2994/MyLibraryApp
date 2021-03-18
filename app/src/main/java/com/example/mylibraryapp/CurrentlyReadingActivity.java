package com.example.mylibraryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CurrentlyReadingActivity extends AppCompatActivity {
    RecyclerView currentlyRecView;
    TextView txtEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading);
        currentlyRecView = findViewById(R.id.CurrentlyReadingRecView);
        txtEmpty=findViewById(R.id.txtEmptyCurrent);
        BooksRecyclerViewAdapter adapter = new BooksRecyclerViewAdapter(this, "CurrentlyReadingActivity");
        currentlyRecView.setAdapter(adapter);
        currentlyRecView.setLayoutManager(new LinearLayoutManager(this));
        DatabaseHelper helper = new DatabaseHelper(this);

        adapter.setBookList(helper.getCurrentlyReadingBooks());
        if (helper.getCurrentlyReadingBooks().size()==0){
            currentlyRecView.setVisibility(View.GONE);
            txtEmpty.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}