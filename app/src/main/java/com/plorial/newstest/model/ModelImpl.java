package com.plorial.newstest.model;

import com.plorial.newstest.model.api.NewsApiInterface;
import com.plorial.newstest.model.api.NewsApiModule;
import com.plorial.newstest.model.pojo.News;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by plorial on 12/19/16.
 */

public class ModelImpl implements Model {

    private NewsApiInterface apiInterface = NewsApiModule.getApiInterface();

    @Override
    public Observable<News> getNews(String source) {
        return apiInterface.getNews(source, NewsApiModule.getApiKey())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<News> getNews(String source, String sortBy) {
        return apiInterface.getNews(source, sortBy, NewsApiModule.getApiKey())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
