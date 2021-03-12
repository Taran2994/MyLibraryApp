package com.example.mylibraryapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BooksRecyclerViewAdapter extends RecyclerView.Adapter<BooksRecyclerViewAdapter.ViewHolder>  {

    private ArrayList<Book> bookList= new ArrayList<>();
    private Context cntnxt;

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
        notifyDataSetChanged();
    }

    public BooksRecyclerViewAdapter(Context context)
    {
        this.cntnxt=context;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtBookName.setText(bookList.get(position).getName());
        Glide.with(cntnxt).asBitmap().load(bookList.get(position).getImageUrl())
                .into(holder.imgBook);
        holder.txtAuthor.setText(bookList.get(position).getAuthor());
        holder.txtShortDesc.setText(bookList.get(position).getShortDesc());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(cntnxt,BookActivity.class);
                intent.putExtra("bookId", bookList.get(position).getId());
                cntnxt.startActivity(intent);
            }
        });
        holder.imgDownArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imgDownArrow.setVisibility(View.GONE);
                holder.expandCard.setVisibility(View.VISIBLE);
            }
        });
        holder.imgUpArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.expandCard.setVisibility(View.GONE);
                holder.imgDownArrow.setVisibility(View.VISIBLE);
            }
        });



    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

    private CardView parent;
    private ImageView imgBook, imgDownArrow, imgUpArrow;
    private TextView txtBookName,txtAuthor, txtShortDesc;
    private LinearLayout expandCard;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        parent= itemView.findViewById(R.id.parent);
        imgBook=itemView.findViewById(R.id.imgBook);
        txtBookName=itemView.findViewById(R.id.txtBookName);
        imgDownArrow=itemView.findViewById(R.id.imgDownArrow);
        imgUpArrow=itemView.findViewById(R.id.imgUpArrow);
        expandCard=itemView.findViewById(R.id.expandCard);
        txtAuthor=itemView.findViewById(R.id.txtAuthor);
        txtShortDesc=itemView.findViewById(R.id.txtShortDesc);


    }
    }

}
