package com.plorial.newstest.presenter;

import android.content.Intent;

import com.plorial.newstest.model.Model;
import com.plorial.newstest.model.ModelImpl;
import com.plorial.newstest.model.api.NewsApiModule;
import com.plorial.newstest.model.pojo.Article;
import com.plorial.newstest.model.pojo.News;
import com.plorial.newstest.view.ArticleActivity;
import com.plorial.newstest.view.NewsListView;

import retrofit.HttpException;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by plorial on 12/19/16.
 */

public class NewsListPresenter implements Presenter {

    private NewsListView view;

    private Model model = new ModelImpl();
    private Subscription subscription = Subscriptions.empty();

    public NewsListPresenter(NewsListView view){
        this.view = view;
    }

    @Override
    public void loadNews() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

        subscription = model.getNews(NewsApiModule.Sources.GoogleNews.toString()).subscribe(new Observer<News>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                view.showError(e.getMessage());
            }

            @Override
            public void onNext(News news) {
                view.showNewsList(news);
            }
        });
    }

    @Override
    public void onStop() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    @Override
    public void onItemClick(Article article) {
        Intent intent = new Intent(view.getContext(), ArticleActivity.class);
        intent.putExtra(ArticleActivity.TAG, article);
        view.getContext().startActivity(intent);
    }
}
