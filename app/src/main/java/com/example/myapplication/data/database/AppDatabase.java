package com.example.myapplication.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication.data.Quote;

@Database(entities = {Quote.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract QuoteDAO quoteDAO();
}
