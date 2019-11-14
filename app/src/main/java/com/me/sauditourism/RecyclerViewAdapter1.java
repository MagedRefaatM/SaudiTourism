package com.me.sauditourism;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.ViewHolder> {

    private int[] cityViewsImages;

    RecyclerViewAdapter1(int[] cityViews ) {
        this.cityViewsImages=cityViews;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView cityViewsImageIv;

        private ViewHolder(View v){
            super(v);
            cityViewsImageIv = (ImageView) v.findViewById(R.id.viewsIv);
        }
    }

    @NonNull
    @Override
    public RecyclerViewAdapter1.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview1, parent, false);
        return new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        switch (position){
            case 0:
                holder.cityViewsImageIv.setImageResource(cityViewsImages[0]);
                break;
            case 1:
                holder.cityViewsImageIv.setImageResource(cityViewsImages[1]);
                break;
            case 2:
                holder.cityViewsImageIv.setImageResource(cityViewsImages[2]);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return cityViewsImages.length;
    }
}