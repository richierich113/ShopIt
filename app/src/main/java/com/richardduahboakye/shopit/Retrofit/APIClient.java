package com.richardduahboakye.shopit.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    //defining base url
    public static final String BASE_URL = "https://run.mocky.io/";


    //retrofit
    public static Retrofit getClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static APIinterface apIinterface() {
        return getClient().create(APIinterface.class);
    }




}
