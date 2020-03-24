package com.sideeg.prices.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sideeg.prices.NetWorkApis.ApiClient;
import com.sideeg.prices.NetWorkApis.NetWorkApis;
import com.sideeg.prices.R;
import com.sideeg.prices.Utility;
import com.sideeg.prices.adapters.CategoriesAdapter;
import com.sideeg.prices.adapters.ItemAdapter;
import com.sideeg.prices.models.CategoriesBaseRespnse;
import com.sideeg.prices.models.Item;
import com.sideeg.prices.models.ItemsBaseRespnse;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends AppCompatActivity {

    RecyclerView recyclerViewMenu;
    RecyclerView.LayoutManager layoutManager;
    public static ItemAdapter adapter;
    public static List<Item> restricList;
    private SearchView searchView;
    private String TAG = "ItemActivity";
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        getSupportActionBar().hide();
        Bundle b = getIntent().getExtras();
       // int src = b.getInt("src");
       // String name = b.getString("name","categories Name");
        id = b.getString("id","0");

//        ImageView foodimage= findViewById(R.id.image_categoreis_diteals);
//        foodimage.setImageResource(src);

//        TextView itemName = findViewById(R.id.cateogries_namedetails);
//        itemName.setText(name);

//        restricList = new ArrayList<>();
//        restricList.add(new Item("gold","die",R.drawable.omla2,1500,"1/5/1992"));
//        restricList.add(new Item("test","yaah",R.drawable.omla3,1200,"2/5/2020"));
//        restricList.add(new Item( "choclate","yah",R.drawable.omla4,1200,"3/2/1952"));
//        restricList.add(new Item("pizaa","sss",R.drawable.omla5,500,"5/6/2019"));
//        restricList.add(new Item("البيك","ss",R.drawable.omla6,600,"/1/1/2020"));
//        restricList.add(new Item("burgar","",R.drawable.omla7,452,""));
//        restricList.add(new Item("humburuger","qwqw",R.drawable.omla8,782,""));
//        restricList.add(new Item("jad","sss",R.drawable.gold1,3698,""));
//        restricList.add(new Item("hoot","asasas",R.drawable.gold3,145,""));
//        restricList.add(new Item("kak","",R.drawable.gold4,258,""));
//        restricList.add(new Item("iccream","",R.drawable.gold5,745,""));
//        restricList.add(new Item("piza","hj",R.drawable.gold6,125,""));
//        restricList.add(new Item("watwe fire","",R.drawable.selver1,785,""));

        getList();

    }

    private void getList() {


        NetWorkApis api = ApiClient.getClient(ApiClient.BASE_URL).create(NetWorkApis.class);
        Call<ItemsBaseRespnse> loginCall = api.getItems("categories/"+id+"/items");
        loginCall.enqueue(new Callback<ItemsBaseRespnse>() {
            @Override
            public void onResponse(Call<ItemsBaseRespnse> call, Response<ItemsBaseRespnse> response) {
                if (response.isSuccessful()) {
                    if (response.body().isError()) {
                        Utility.showAlertDialog(getString(R.string.error), response.body().getMessage(), ItemActivity.this);

                    } else {
                        adapter = new ItemAdapter(response.body().getData(),ItemActivity.this);


                        //add recycler view
                        recyclerViewMenu = findViewById(R.id.item_recuclyer);
                        recyclerViewMenu.setHasFixedSize(true);
                        layoutManager = new LinearLayoutManager(ItemActivity.this);
                        recyclerViewMenu.setLayoutManager(layoutManager);

                        recyclerViewMenu.setAdapter(adapter);

                    }
                } else {
                    Log.i(TAG, response.errorBody().toString());
                    Utility.showAlertDialog(getString(R.string.error), getString(R.string.servererror), ItemActivity.this);

                }
            }

            @Override
            public void onFailure(Call<ItemsBaseRespnse> call, Throwable t) {
                Utility.showAlertDialog(getString(R.string.error), t.getMessage(), ItemActivity.this);
                Utility.printLog(TAG, t.getMessage());
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//
//        // Associate searchable configuration with the SearchView
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        searchView = (SearchView) menu.findItem(R.id.action_search)
//                .getActionView();
//        searchView.setSearchableInfo(searchManager
//                .getSearchableInfo(getComponentName()));
//        searchView.setMaxWidth(Integer.MAX_VALUE);
//
//        // listening to search query text change
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                // filter recycler view when query submitted
//                adapter.getFilter().filter(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String query) {
//                // filter recycler view when text is changed
//                adapter.getFilter().filter(query);
//                return false;
//            }
//        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_search) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // close search view on back button pressed
//        if (!searchView.isIconified()) {
//            searchView.setIconified(true);
//            return;
//        }
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
