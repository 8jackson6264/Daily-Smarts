package com.example.myapplication.data.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.data.Quote;

import java.util.List;

@Dao
public interface QuoteDAO {
    @Query("SELECT * FROM quotes")
    List<Quote> getAll();

    @Insert
    void insertAll(Quote... quotes);

    @Delete
    void deleteQuote(Quote quote);
}
