package com.sideeg.prices.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sideeg.prices.R;

public class ItemDetialsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detials);

        Bundle b = getIntent().getExtras();
        int src = b.getInt("src");
        String name = b.getString("name","categories Name");

    }
}
