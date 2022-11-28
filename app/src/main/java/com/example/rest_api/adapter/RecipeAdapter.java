package com.example.rest_api.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rest_api.R;
import com.example.rest_api.model.ResultsItem;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {
  private final Context context;
  private List<ResultsItem> recipeList;

  public RecipeAdapter(Context context, List<ResultsItem> recipeList) {
    this.context = context;
    this.recipeList = recipeList;
  }

  public List<ResultsItem> getRecipeList() {
    return recipeList;
  }

  public void setRecipeList(List<ResultsItem> recipeList) {
    this.recipeList = recipeList;
  }


  @NonNull
  @Override
  public RecipeAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
    return new RecipeViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull RecipeAdapter.RecipeViewHolder holder, int position) {
    ResultsItem recipeList = getRecipeList().get(position);
    holder.textView1.setText(recipeList.getTitle());
    holder.textView2.setText(recipeList.getServing());
  }

  @Override
  public int getItemCount() {
    return recipeList.size();
  }

  public class RecipeViewHolder extends RecyclerView.ViewHolder {
    TextView textView1, textView2;
    public RecipeViewHolder(@NonNull View itemView) {
      super(itemView);
      textView1 = itemView.findViewById(R.id.textView1);
      textView2 = itemView.findViewById(R.id.textView2);
    }
  }
}
