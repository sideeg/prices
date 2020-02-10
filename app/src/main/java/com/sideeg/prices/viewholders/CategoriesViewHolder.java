package com.sideeg.prices.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sideeg.prices.R;
import com.sideeg.prices.interfaces.ItemclickInterface;

import androidx.recyclerview.widget.RecyclerView;

public class CategoriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView restricName;
    public ImageView restricImage;
    private ItemclickInterface itemclickInterface;

    public void setItemclickInterface(ItemclickInterface itemclickInterface) {
        this.itemclickInterface = itemclickInterface;
    }

    public CategoriesViewHolder(View itemView) {

        super(itemView);

        restricName =(TextView) itemView.findViewById(R.id.categrories_name);
        restricImage = (ImageView)itemView.findViewById(R.id.categrories_image);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        itemclickInterface.onclic(v,getAdapterPosition(),false);
    }
}
