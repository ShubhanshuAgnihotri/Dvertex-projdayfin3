package com.devdroid.projdayfin3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvProducts = findViewById(R.id.rvItemsList);
        getProducts();
    }

   /* private void getProducts(){
        Call<List<ProductResultModel>> apiCall =RetrofitClient.getInstance().getApis().getProducts();
        Log.d("MainActivity",apiCall.toString());
        apiCall.enqueue(new Callback<List<ProductResultModel>>() {
            @Override
            public void onResponse(Call<List<ProductResultModel>> call, Response<List<ProductResultModel>> response) {
                Log.d("OnResponse: ",response.body().toString());

                List<ProductResultModel> productResults = response.body();
                List<Product> productList = productResults.get(0).getProducts();
//                Toast.makeText(context,ActivityRvProducts.this,text+ "Got Products",Toast.LENGTH_SHORT).show();
//                List<ProductResultModel> ProductResult;
                setAdapter(productList);
            }

            @Override
            public void onFailure(Call<List<ProductResultModel>> call, Throwable t) {
                Log.d("OnFailure: ",t.toString());

            }
        });
    }*/
   private void getProducts(){
       Call<ProductResultModel> apiCall = RetrofitClient.getInstance().getApis().getProducts();
       Log.d("MainActivity", apiCall.request().url().toString()); // Log the URL for debugging
       apiCall.enqueue(new Callback<ProductResultModel>() {
           @Override
           public void onResponse(Call<ProductResultModel> call, Response<ProductResultModel> response) {
               if (response.isSuccessful() && response.body() != null) {
                   ProductResultModel productResult = response.body();
                   List<Product> productList = productResult.getProducts();
                   setAdapter(productList);
               } else {
                   Log.e("MainActivity", "Failed to get response");
               }
           }

           @Override
           public void onFailure(Call<ProductResultModel> call, Throwable t) {
               Log.e("MainActivity", "Failed to fetch data: " + t.getMessage());
           }
       });
   }
    private void setAdapter(List<Product> productResults){
        rvProducts.setLayoutManager(new LinearLayoutManager( this));
        RVRetrofitAdapter rvRetrofitAdapter = new RVRetrofitAdapter(this,productResults);
        rvProducts.setAdapter(rvRetrofitAdapter);
    }
}