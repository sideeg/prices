package com.sideeg.prices.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sideeg.prices.R;
import com.sideeg.prices.adapters.CategoriesAdapter;
import com.sideeg.prices.models.Categories;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView recyclerViewMenu;
    RecyclerView.LayoutManager layoutManager;
    public static RecyclerView.Adapter adapter;
    public static List<Categories> categoriesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoriesList = new ArrayList<>();
        categoriesList.add(new Categories("العملات",R.drawable.omla2));
        categoriesList.add(new Categories("الفضة",R.drawable.selver1));
        categoriesList.add(new Categories("الذهب ",R.drawable.gold1));

        adapter = new CategoriesAdapter(categoriesList,this);
        //add recycler view
        recyclerViewMenu = findViewById(R.id.categories_recycler_view);
        recyclerViewMenu.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewMenu.setLayoutManager(layoutManager);

        recyclerViewMenu.setAdapter(adapter);
    }
}
