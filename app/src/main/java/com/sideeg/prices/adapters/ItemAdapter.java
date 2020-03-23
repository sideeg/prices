package com.sideeg.prices.adapters;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Filter;
import android.widget.Filterable;

import com.sideeg.prices.R;
import com.sideeg.prices.interfaces.ItemclickInterface;
import com.sideeg.prices.models.Item;
import com.sideeg.prices.ui.ItemDetialsActivity;
import com.sideeg.prices.ui.MainActivity;
import com.sideeg.prices.viewholders.ItemsViewHolders;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by sideeg on 1/12/2019.
 */


public class ItemAdapter extends RecyclerView.Adapter<ItemsViewHolders> implements Filterable {

    private List<Item> list;
    private List<Item> itemsListFiltered;

    private Context context;

    private int previousPostion = 0;
    View v;

    public ItemAdapter(List<Item> list, Context context) {
        this.list = list;
        this.itemsListFiltered = list;
        this.context = context;
    }

    @Override
    public ItemsViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(context)
                .inflate(R.layout.item_items,parent,false);
        return new ItemsViewHolders(v);
    }



    @Override
    public void onBindViewHolder(ItemsViewHolders holder, final int position) {




        final Item listItem = itemsListFiltered.get(position);
        if (!listItem.getName().equals("no match found")){

            holder.itemName.setText(listItem.getName());
            holder.itemPrice.setText(String.valueOf(listItem.getPrice()));
           // holder.itemImage.setImageResource(listItem.getImage());
            Picasso.get().load(listItem.getImage()).fit().into(holder.itemImage);
            holder.item_data_text.setText(listItem.getData());
            holder.setItemclickInterface(new ItemclickInterface() {
                @Override
                public void onclic(View view, int postion, Boolean longClick) {
                    Intent intent = new Intent(view.getContext(), ItemDetialsActivity.class);
                    intent.putExtra("src",itemsListFiltered.get(position).getImage());
                    intent.putExtra("name",itemsListFiltered.get(position).getName());
                    intent.putExtra("item descr",itemsListFiltered.get(position).getDescroption());
                    intent.putExtra("itemprice",String.valueOf(itemsListFiltered.get(position).getPrice()));
                    intent.putExtra("item_date",String.valueOf(itemsListFiltered.get(position).getData()));
                    view.getContext().startActivity(intent);


                }
            });
        }


        if (position > previousPostion){

        animate(holder ,true);
    }else {

        animate(holder ,false);
    }

    previousPostion = position;



}

    private void animate(ItemsViewHolders holder, Boolean goesDown) {
//        ObjectAnimator.ofFloat(holder.itemView,"translationY",goesDown==true ?100:-100,100);


        ObjectAnimator textViewAnimator = ObjectAnimator.ofFloat(holder.itemView, "translationY",goesDown==true ?100:-100,0);
        textViewAnimator.setDuration(2000);

        textViewAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        textViewAnimator.start();


    }

    public void remove(int postion){
        list.remove(postion);
        notifyItemRemoved(postion);


    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return itemsListFiltered.size();
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    itemsListFiltered = list;
                } else {
                    List<Item> filteredList = new ArrayList<>();
                    for (Item row : list) {
                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getName().toLowerCase().contains(charString.toLowerCase()) ||row.getDescroption().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    itemsListFiltered = filteredList;
                }

                if (itemsListFiltered.size() == 0){
                   // itemsListFiltered.add(new Item("no match found","",R.drawable.not_found,0,""));
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = itemsListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                itemsListFiltered = (ArrayList<Item>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface ContactsAdapterListener {
        void onContactSelected(Item contact);
    }

}
