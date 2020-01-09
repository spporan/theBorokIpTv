package com.example.theborokiptv.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.theborokiptv.R;
import com.example.theborokiptv.model.TvModel;
import com.example.theborokiptv.screens.TvScreenActivity;
import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TvListAdapater extends RecyclerView.Adapter<TvListAdapater.MyViewHolder> {
    List<TvModel>tvModelList;
    Context context;
    public TvListAdapater(List<TvModel>tvModelList,Context context){
        this.tvModelList = tvModelList;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(context).inflate(R.layout.recycler_items, parent, false);
        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Log.d("Image Url :",tvModelList.get(position).getImage());
        Picasso.get().load(tvModelList.get(position).getImage()).into(holder.tvImage);
        holder.titleTv.setText(tvModelList.get(position).getTitle());
       holder. playBtn.setOnClickListener(v -> {
            Intent intent = new Intent(context, TvScreenActivity.class);
           intent.putExtra("url", tvModelList.get(position).getUrl());
           context.startActivity(intent);

        });


    }

    @Override
    public int getItemCount() {
        return tvModelList.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView tvImage;
        Button playBtn,genreBtn;
        TextView titleTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvImage = itemView.findViewById(R.id.image_tv);
            titleTv = itemView.findViewById(R.id.tv_title);
            playBtn = itemView.findViewById(R.id.platBtn);
            genreBtn = itemView.findViewById(R.id.genreBtn);


        }
    }
}
