package com.example.myapplication.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.data.Quote;

import java.util.ArrayList;
import java.util.List;

public class MyQuotesAdapter extends RecyclerView.Adapter<MyQuotesAdapter.ViewHolder>{

    List<Quote> quotesList;

    public MyQuotesAdapter() {
        this.quotesList = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quote,
                parent,
                false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtAuthor.setText(quotesList.get(position).quoteAuthor);
        holder.txtQuote.setText(quotesList.get(position).quoteText);
    }

    @Override
    public int getItemCount() {
        return quotesList.size();
    }

    public void setQuotesList(List<Quote> quotesList) {
        this.quotesList = quotesList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView btnSave;
        ImageView btnShare;
        TextView txtQuote;
        TextView txtAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnSave = itemView.findViewById(R.id.btn_save);
            btnShare = itemView.findViewById(R.id.btn_share);
            txtQuote = itemView.findViewById(R.id.txt_quote);
            txtAuthor = itemView.findViewById(R.id.txt_author);

        }
    }
}
