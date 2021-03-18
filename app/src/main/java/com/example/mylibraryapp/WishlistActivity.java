package com.example.mylibraryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WishlistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);
        RecyclerView wishlistRecView = findViewById(R.id.wishlistRecView);
        BooksRecyclerViewAdapter adapter = new BooksRecyclerViewAdapter(this, "WishlistActivity");
        DatabaseHelper helper = new DatabaseHelper(this);
        TextView txtEmpty= findViewById(R.id.txtEmptyWish);

        adapter.setBookList(helper.getWishlistBooks());

        wishlistRecView.setAdapter(adapter);
        wishlistRecView.setLayoutManager(new LinearLayoutManager(this));
        if (helper.getWishlistBooks().size()==0){
            wishlistRecView.setVisibility(View.GONE);
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