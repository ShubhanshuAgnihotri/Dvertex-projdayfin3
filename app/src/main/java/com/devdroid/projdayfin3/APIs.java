package com.devdroid.projdayfin3;

import com.devdroid.projdayfin3.ProductResultModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {
    String BASE_URL ="https://dummyjson.com/";
    @GET("products")
    Call<ProductResultModel> getProducts();
}
