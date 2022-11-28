package com.example.rest_api.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rest_api.BuildConfig;
import com.example.rest_api.api.ApiClient;
import com.example.rest_api.model.RecipeList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodViewModel extends ViewModel {
    private static final String TAG = "FoodViewModel";
    MutableLiveData<RecipeList> foodList;

    public MutableLiveData<RecipeList> getFoodList() {
        if (foodList == null) {
            foodList = new MutableLiveData<>();
            setFoodList();
        }
        return foodList;
    }

    private void setFoodList() {
        ApiClient.getInstance().getApi().getRecipeList()
                .enqueue(new Callback<RecipeList>() {
                    @Override
                    public void onResponse(Call<RecipeList> call, Response<RecipeList> response) {
                        if (response.isSuccessful()) {
                            foodList.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<RecipeList> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }
}
