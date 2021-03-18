package com.example.mylibraryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AlreadyReadBooksActivity extends AppCompatActivity {

    RecyclerView alreadReadRecView;
    TextView txtEmptyList;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read_books);
        txtEmptyList=findViewById(R.id.txtEmptyAlready);
        alreadReadRecView = findViewById(R.id.alreadyReadRecView);
        BooksRecyclerViewAdapter adap = new BooksRecyclerViewAdapter(this, "AlreadyReadBooksActivity");
        alreadReadRecView.setAdapter(adap);
        alreadReadRecView.setLayoutManager(new LinearLayoutManager(this));
        DatabaseHelper helper = new DatabaseHelper(this);


        adap.setBookList(helper.getAlreadReadBooks());
        if (helper.getAlreadReadBooks().size()==0){
            alreadReadRecView.setVisibility(View.GONE);
            txtEmptyList.setVisibility(View.VISIBLE);
        }


    }
}