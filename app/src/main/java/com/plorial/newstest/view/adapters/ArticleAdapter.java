package com.plorial.newstest.view.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.plorial.newstest.R;
import com.plorial.newstest.model.pojo.Article;

/**
 * Created by plorial on 12/19/16.
 */

public class ArticleAdapter extends ArrayAdapter<Article> {

    private Context context;
    private int resource;

    public ArticleAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource, null);
        }

        Article article = super.getItem(position);
        if (article != null){
            TextView title = (TextView) view.findViewById(R.id.tvTitle);
            ImageView img = (ImageView) view.findViewById(R.id.img);
            title.setText(article.getTitle());
            if(article.getUrlToImage() != null){
                img.setVisibility(View.GONE);
            }
        }
        return view;
    }
}
