package com.sideeg.prices.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sideeg.prices.R;
import com.sideeg.prices.adapters.CategoriesAdapter;
import com.sideeg.prices.models.Categories;
import com.sideeg.prices.models.Item;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.sideeg.prices.ui.ItemActivity.restricList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView recyclerViewMenu;
    RecyclerView.LayoutManager layoutManager;
    public static CategoriesAdapter adapter;
    public static List<Categories> categoriesList;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoriesList = new ArrayList<>();
        categoriesList.add(new Categories("العملات",R.drawable.omla2));
        categoriesList.add(new Categories("الفضة",R.drawable.selver1));
        categoriesList.add(new Categories("الذهب ",R.drawable.gold1));

        ///////////////////////////////////////////////////////////////////////////////////////////
        restricList = new ArrayList<>();
        restricList.add(new Item("gold","die",R.drawable.omla2,1500,""));
        restricList.add(new Item("test","yaah",R.drawable.omla3,1200,""));
        restricList.add(new Item( "choclate","yah",R.drawable.omla4,1200,""));
        restricList.add(new Item("pizaa","sss",R.drawable.omla5,500,""));
        restricList.add(new Item("البيك","ss",R.drawable.omla6,600,""));
        restricList.add(new Item("burgar","",R.drawable.omla7,452,""));
        restricList.add(new Item("humburuger","qwqw",R.drawable.omla8,782,""));
        restricList.add(new Item("jad","sss",R.drawable.gold1,3698,""));
        restricList.add(new Item("hoot","asasas",R.drawable.gold3,145,""));
        restricList.add(new Item("kak","",R.drawable.gold4,258,""));
        restricList.add(new Item("iccream","",R.drawable.gold5,745,""));
        restricList.add(new Item("piza","hj",R.drawable.gold6,125,""));
        restricList.add(new Item("watwe fire","",R.drawable.selver1,785,""));

        adapter = new CategoriesAdapter(categoriesList,this,restricList);
        //add recycler view
        recyclerViewMenu = findViewById(R.id.categories_recycler_view);
        recyclerViewMenu.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewMenu.setLayoutManager(layoutManager);

        recyclerViewMenu.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                adapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // close search view on back button pressed
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }
}
