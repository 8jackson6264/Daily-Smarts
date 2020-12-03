package com.example.myapplication.data.api;

import com.example.myapplication.data.Quote;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiQuoteService {
    @GET("/api/1.0/?method=getQuote&format=json&lang=en")
    Call<Quote> getRandomEnglishQuote();

    @GET("/api/1.0/?method=getQuote&format=json&lang=ru")
    Call<Quote> getRandomRussianQuote();
}
