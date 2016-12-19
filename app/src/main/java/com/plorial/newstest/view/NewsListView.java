package com.plorial.newstest.view;

import com.plorial.newstest.model.pojo.News;

import java.util.List;

/**
 * Created by plorial on 12/19/16.
 */

public interface NewsListView extends View {
    void showNewsList(News news);
}
