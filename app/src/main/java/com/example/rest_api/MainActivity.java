package com.example.rest_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;

import com.example.rest_api.adapter.RecipeAdapter;
import com.example.rest_api.model.RecipeList;
import com.example.rest_api.viewmodel.FoodViewModel;

public class MainActivity extends AppCompatActivity{
    RecyclerView recylerView;
    RecipeAdapter adapter;
    FoodViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recylerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recylerView.setLayoutManager(linearLayoutManager);
        viewModel = new FoodViewModel();
        viewModel.getFoodList().observe(this, new Observer<RecipeList>() {
            @Override
            public void onChanged(RecipeList foodList) {
                if (foodList.getResults() != null) {
                    adapter = new RecipeAdapter(MainActivity.this, foodList.getResults());
                    adapter.notifyDataSetChanged();
                    recylerView.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}