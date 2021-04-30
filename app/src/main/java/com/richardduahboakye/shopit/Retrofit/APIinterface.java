package com.richardduahboakye.shopit.Retrofit;

import com.richardduahboakye.shopit.model.ItemModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {

    @GET("v3/59640725-94a2-484c-80ff-998ef30f4b53")
    Call<List<ItemModel>> getList();
}
