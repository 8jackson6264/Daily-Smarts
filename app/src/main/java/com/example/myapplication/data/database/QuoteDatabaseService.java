package com.example.myapplication.data.database;

import android.content.Context;
import android.os.AsyncTask;

import com.example.myapplication.data.Quote;

import java.util.List;

import javax.inject.Inject;

public class QuoteDatabaseService {
    private final QuoteDAO quoteDAO;

    @Inject
    public QuoteDatabaseService(Context context) {
        quoteDAO = Database.getInstance(context).quoteDAO();
    }


    public void getAllQuotes(DataListener<List<Quote>> dataListener) {
        new AsyncTask<Void, Void, List<Quote>>() {
            @Override
            protected List<Quote> doInBackground(Void... voids) {
                return quoteDAO.getAll();
            }

            @Override
            protected void onPostExecute(List<Quote> students) {
                dataListener.onData(students);
            }
        }.execute();
    }

    public void addQuote(Quote quote) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                quoteDAO.insertAll((quote));
                return null;

            }
        }.execute();
    }

    public void deleteQuote(Quote quote) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                quoteDAO.deleteQuote(quote);
                return null;
            }
        }.execute();
    }

    public interface DataListener<T> {
        void onData(T data);
    }
}
