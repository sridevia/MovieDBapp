package com.example.sridevi.moviedbapp.utilities;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Sridevi on 4/13/2017.
 */
public class NetworkManager {
    //https://api.themoviedb.org/3/movie/550?api_key=f85681f445e65e980c1fe51baa1cca05&search=avatar
    public final String MOVIES_DB_URL = "https://api.themoviedb.org/3/movie/550";
    public final String API_KEY = "f85681f445e65e980c1fe51baa1cca05";
    public static NetworkManager INSTANCE = null;
    private OkHttpClient okHttpClient;
    private NetworkManager(){
        okHttpClient = new OkHttpClient();
    }
    public static NetworkManager getInstance() {
        if (INSTANCE == null)
            return INSTANCE = new NetworkManager();
        else
            return INSTANCE;
    }

    public Request createSearchRequest(String searchText) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(MOVIES_DB_URL).newBuilder();
        urlBuilder.addQueryParameter("api_key", API_KEY);
        urlBuilder.addQueryParameter("search", searchText);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                        .url(url)
                        .build();
        return  request;
    }

    public OkHttpClient getOkHttpClient() {
        return this.okHttpClient;
    }


 }
