package com.example.rest_api.api;

import com.example.rest_api.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
  private static ApiClient mInstance;
  private Retrofit retrofit;

  private ApiClient() {
    retrofit = new Retrofit.Builder()
            .baseUrl(BuildConfig.BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
  }

  public static synchronized ApiClient getInstance(){
    if(mInstance==null){
      mInstance = new ApiClient();
    }
    return mInstance;
  }

  public Api getApi(){
    return retrofit.create(Api.class);
  }
}
