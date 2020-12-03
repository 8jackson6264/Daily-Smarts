package com.example.myapplication.data.api;

import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.data.Quote;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Api instance;
    private final ApiQuoteService service;

    private Api() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.forismatic.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiQuoteService.class);
    }

    public static Api getInstance() {
        if (instance == null) instance = new Api();
        return instance;
    }

    public void getRandomEnglishQuote(final ApiListener listener) {
        service.getRandomEnglishQuote().enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                if (response.isSuccessful()) {
                    listener.onQuoteReceived(response.body().getQuoteText(), response.body().getQuoteAuthor());
                } else {
                    listener.onFailure();
                }
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {
                listener.onFailure();
            }
        });
    }

    public void getRandomRussianQuote(final ApiListener listener) {
        service.getRandomRussianQuote().enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                if (response.isSuccessful()) {
                    listener.onQuoteReceived(response.body().getQuoteText(), response.body().getQuoteAuthor());
                } else {
                    listener.onFailure();
                }
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {
                listener.onFailure();
            }
        });
    }

    public interface ApiListener {
        void onQuoteReceived(String quote, String author);

        void onFailure();
    }


}