package com.sideeg.prices.viewholders;

import android.view.View;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.sideeg.prices.R;
import com.sideeg.prices.interfaces.ItemclickInterface;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ItemsViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView itemName,itemPrice,item_data_text;
    public ImageView itemImage;
    public CardView cardView;
    private ItemclickInterface itemclickInterface;


    public ItemsViewHolders(View itemView) {
        super(itemView);
        itemName = itemView.findViewById(R.id.item_name);
        itemImage = itemView.findViewById(R.id.item_image);
        itemPrice =  itemView.findViewById(R.id.item_price);
        cardView =  itemView.findViewById(R.id.item_card_view);
        item_data_text =  itemView.findViewById(R.id.item_data_text);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        itemclickInterface.onclic(v,getAdapterPosition(),false);


    }

    public void setItemclickInterface(ItemclickInterface itemclickInterface) {
        this.itemclickInterface = itemclickInterface;
    }
}
