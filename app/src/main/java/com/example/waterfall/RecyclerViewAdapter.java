package com.example.waterfall;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Random;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    List<Float> floatList;

    public RecyclerViewAdapter(Context context, List<Float> floatList) {
        this.context = context;
        this.floatList=floatList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_adapter, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.setDimension(floatList.get(i));
        int a= i%6;
        viewHolder.ImageView.setBackgroundColor(context.getResources().getColor(Constant.color[a]));
       // Glide.with(context).load(resultBeanList.get(i).getBrand_logo()).into(viewHolder.ImageView);
    }

    @Override
    public int getItemCount() {
        return floatList.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        private android.widget.ImageView ImageView;
        void setDimension(float dimension){
                FrameLayout.LayoutParams layoutParams =new FrameLayout.LayoutParams((int) (dimension*100),ViewGroup.LayoutParams.MATCH_PARENT);
             //   layoutParams.setMargins(3,3,3,3);
                ImageView.setLayoutParams(layoutParams);
//            if(dimension%2==0){
//                FrameLayout.LayoutParams layoutParams =new FrameLayout.LayoutParams(90,ViewGroup.LayoutParams.MATCH_PARENT);
//                layoutParams.setMargins(3,3,3,3);
//                ImageView.setLayoutParams(layoutParams);
//            }else{
//                FrameLayout.LayoutParams layoutParams =new FrameLayout.LayoutParams(150,ViewGroup.LayoutParams.MATCH_PARENT);
//                layoutParams.setMargins(3,3,3,3);
//                ImageView.setLayoutParams(layoutParams);
//            }
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            ImageView = (ImageView) itemView.findViewById(R.id.ImageView);


        }
    }
}
