package com.plorial.newstest.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.plorial.newstest.model.DownloadImageTask;
import com.plorial.newstest.R;
import com.plorial.newstest.model.pojo.Article;

/**
 * Created by plorial on 12/19/16.
 */

public class ArticleActivity extends AppCompatActivity {

    public static final String TAG = ArticleActivity.class.getSimpleName();

    private Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        article = getIntent().getExtras().getParcelable(TAG);
        Log.d(TAG, article.getTitle());
        TextView title = (TextView) findViewById(R.id.tvArticleTitle);
        TextView description = (TextView) findViewById(R.id.tvDescription);
        TextView time = (TextView) findViewById(R.id.tvPublishedTime);
        TextView url = (TextView) findViewById(R.id.tvArticleUrl);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        title.setText(article.getTitle());
        description.setText(article.getDescription());
        time.setText(article.getPublishedAt());
        url.setText(article.getUrl());
        if(article.getUrlToImage() != null) {
            DownloadImageTask task = new DownloadImageTask(imageView);
            task.execute(article.getUrlToImage());
        }
    }
}
