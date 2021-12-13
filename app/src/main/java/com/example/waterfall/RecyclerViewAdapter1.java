package com.example.waterfall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.ViewHolder> {
    Context context;
    List<Float> floatList;


    public RecyclerViewAdapter1(Context context, List<Float> floatList) {
        this.context = context;
        this.floatList = floatList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_adapter1, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.setDimension(floatList.get(i));
        int a = i % 6;
        viewHolder.ImageView1.setBackgroundColor(context.getResources().getColor(Constant.color[a]));
        // Glide.with(context).load(resultBeanList.get(i).getBrand_logo()).into(viewHolder.ImageView);
    }

    @Override
    public int getItemCount() {
        return floatList.size();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ImageView1;

        void setDimension(float dimension) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (dimension * 100));
            ImageView1.setLayoutParams(layoutParams);
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            ImageView1 = (ImageView) itemView.findViewById(R.id.ImageView1);
        }
    }
}
