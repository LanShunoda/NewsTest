package com.plorial.newstest.model.api;

import com.plorial.newstest.model.pojo.Article;
import com.plorial.newstest.model.pojo.News;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by plorial on 12/19/16.
 */

public interface NewsApiInterface {

    @GET("articles")
    Observable<News> getNews(@Query("source") String source, @Query("apiKey") String apiKey);
    @GET("articles")
    Observable<News> getNews(@Query("source") String source, @Query("apiKey") String apiKey, @Path("sortBy") String sortBy);
}
