package com.plorial.newstest.presenter;

import com.plorial.newstest.model.pojo.Article;

/**
 * Created by plorial on 12/19/16.
 */

public interface Presenter {

    void loadNews();
    void onStop();
    void onItemClick(Article article);
}
