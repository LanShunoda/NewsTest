package com.plorial.newstest.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.plorial.newstest.R;
import com.plorial.newstest.model.pojo.News;
import com.plorial.newstest.presenter.NewsListPresenter;
import com.plorial.newstest.presenter.Presenter;
import com.plorial.newstest.view.adapters.ArticleAdapter;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NewsListView {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ArrayAdapter adapter;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list_view);
        adapter = new ArticleAdapter(this, R.layout.article_list_item);
        listView.setAdapter(adapter);
        presenter = new NewsListPresenter(this);
        presenter.loadNews();
    }

    @Override
    public void showNewsList(News news) {
        adapter.addAll(news.getArticles());
    }

    @Override
    public void showError(String error) {
        Log.e(TAG, error);
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
