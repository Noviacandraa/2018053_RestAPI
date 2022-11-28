package com.example.rest_api.api;

import com.example.rest_api.model.RecipeList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Api {
  @GET("api/recipes")
  Call<RecipeList> getRecipeList();

}
