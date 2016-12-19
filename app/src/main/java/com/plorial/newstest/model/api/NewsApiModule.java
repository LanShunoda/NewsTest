package com.plorial.newstest.model.api;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by plorial on 12/19/16.
 */

public class NewsApiModule {

    private final static String BASE_URL = "https://newsapi.org/v1/";
    private final static String API_KEY = "fe179956c28e4c38817810152cc1db38";

    public static NewsApiInterface getApiInterface(){
        Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

        return builder.build().create(NewsApiInterface.class);
    }

    public static String getApiKey(){return API_KEY;};

    public enum SortBy{
        TOP("top"),
        LATEST("latest"),
        POPULAR("popular");

        private String sort;

        private SortBy(final String sort){
            this.sort = sort;
        }

        @Override
        public String toString() {
            return sort;
        }
    }

    public enum Sources{
        ABC("abc-news-au"),
        ArsTechnica("ars-technica"),
        GoogleNews("google-news");
        private String source;

        private Sources(final String source){
            this.source = source;
        }

        @Override
        public String toString() {
            return source;
        }
    }
}
