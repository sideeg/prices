package com.sideeg.prices.adapters;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;


import com.sideeg.prices.R;
import com.sideeg.prices.interfaces.ItemclickInterface;
import com.sideeg.prices.models.Categories;
import com.sideeg.prices.ui.ItemActivity;
import com.sideeg.prices.viewholders.CategoriesViewHolder;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by sideeg on 6/21/2018.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesViewHolder> {

    private List<Categories> list;

    private Context context;

    private int previousPostion = 0;
    View v;


    public CategoriesAdapter(List<Categories> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public CategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(context)
                .inflate(R.layout.item_categories,parent,false);
        return new CategoriesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CategoriesViewHolder holder, final int position) {

        holder.setItemclickInterface(new ItemclickInterface() {
            @Override
            public void onclic(View view, int postion, Boolean longClick) {
                Intent intent = new Intent(view.getContext(), ItemActivity.class);
                intent.putExtra("src",list.get(position).getImage());
                intent.putExtra("name",list.get(position).getName());
                view.getContext().startActivity(intent);


            }
        });
        final Categories listItem = list.get(position);
        holder.restricName.setText(listItem.getName());
        //holder.lastName.setText(listItem.getDesc());
        holder.restricImage.setImageResource(listItem.getImage());
       // holder.cardView.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {
             //   if (listItem.isFood()) {
               //     Intent intent = new Intent(v.getContext(), FoodDetials.class);
//                    intent.putExtra("id",listItem.getID());
                 //   context.startActivity(intent);
               // }else {
                 //   Intent intent = new Intent(v.getContext(), RestricDetials.class);
                   // intent.putExtra("id",listItem.getHead());
                  //  context.startActivity(intent);
                //}
            //}
        //});

//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                remove(position);
//            }
//        });





//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(context,Product_Detile.class);
////                intent.putExtra("proudect name",listItem.getData());
////                intent.putExtra("proudect image",listItem.getSrc());
////
////                context.startActivity(intent);
//
//                Toast.makeText(context,"1234",Toast.LENGTH_LONG);
//
//
//
//
//            }
//        });

        if (position > previousPostion){

            animate(holder ,true);
        }else {

            animate(holder ,false);
        }

        previousPostion = position;



    }

    private void animate(CategoriesViewHolder holder, Boolean goesDown) {
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
        return list.size();
    }


    }

