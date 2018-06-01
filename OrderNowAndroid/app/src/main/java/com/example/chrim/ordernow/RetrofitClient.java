package com.example.chrim.ordernow;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {

    private static String url = "http://192.168.137.102/client/";
    private static String AUTH = "Basic YTph";
    private static Retrofit retrofit;
    private static OkHttpClient client;

    static {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request request = chain.request().newBuilder().addHeader("Authorization", AUTH).build();
            return chain.proceed(request);
        });

        client = httpClient.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public static Retrofit getClient() {
        return retrofit;
    }
}
