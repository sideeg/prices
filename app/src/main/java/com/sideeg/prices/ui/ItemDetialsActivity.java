package com.sideeg.prices.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.sideeg.prices.R;

public class ItemDetialsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detials);

        Bundle b = getIntent().getExtras();
        int src = b.getInt("src");
        String name = b.getString("name","item Name");
        String description  = b.getString("item descr","");
        String  price= b.getString("itemprice","0000");

        ImageView imageView = findViewById(R.id.image_item_diteals);
        TextView itemName = findViewById(R.id.item_namedetails);
        TextView itemDesciption = findViewById(R.id.item_descrition);
        TextView itemPrice = findViewById(R.id.item_pricedetails);

        imageView.setImageResource(src);
        itemName.setText(name);
        itemPrice.setText(price);
        itemDesciption.setText(description);



    }
}
