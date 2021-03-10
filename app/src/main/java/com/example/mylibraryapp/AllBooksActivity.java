package com.example.mylibraryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private RecyclerView booksRecView;
    private BooksRecyclerViewAdapter adapter;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        booksRecView=findViewById(R.id.booksRecView);
        adapter= new BooksRecyclerViewAdapter(this);

        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new GridLayoutManager(this,2));
        ArrayList<Book> books= new ArrayList<>();
        books.add(new Book(1, "2 States", "Chetan Bhagat", 448,"https://upload.wikimedia.org/wikipedia/en/thumb/3/3a/2_States_-_The_Story_Of_My_Marriage.jpg/220px-2_States_-_The_Story_Of_My_Marriage.jpg",
                "A story of 2 states","This is a long desc"));
        books.add(new Book(2, "3 Idiots", "Chetan Bhagat", 448,"https://upload.wikimedia.org/wikipedia/en/thumb/3/3a/2_States_-_The_Story_Of_My_Marriage.jpg/220px-2_States_-_The_Story_Of_My_Marriage.jpg",
                "A story of 2 states","This is a long desc"));
        books.add(new Book(3, "Half Girlfriend", "Chetan Bhagat", 448,"https://upload.wikimedia.org/wikipedia/en/thumb/3/3a/2_States_-_The_Story_Of_My_Marriage.jpg/220px-2_States_-_The_Story_Of_My_Marriage.jpg",
                "A story of 2 states","This is a long desc"));
        books.add(new Book(4, "3 Mistakes of my life", "Chetan Bhagat", 448,"https://upload.wikimedia.org/wikipedia/en/thumb/3/3a/2_States_-_The_Story_Of_My_Marriage.jpg/220px-2_States_-_The_Story_Of_My_Marriage.jpg",
                "A story of 2 states","This is a long desc"));
        adapter.setBookList(books);
    }
}