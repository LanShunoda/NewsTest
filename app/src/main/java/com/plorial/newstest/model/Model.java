package com.plorial.newstest.model;

import com.plorial.newstest.model.pojo.News;

import java.util.List;

import rx.Observable;

/**
 * Created by plorial on 12/19/16.
 */

public interface Model {

    Observable<News> getNews(String source);
    Observable<News> getNews(String source, String sortBy);
}
