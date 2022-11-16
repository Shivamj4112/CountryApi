package com.api.countryapi.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.api.countryapi.Activity.All_countryActivity;
import com.api.countryapi.ModelClass.Country;
import com.api.countryapi.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Dataholder> {

    Activity activity;
    public static List<Country> datalist;

    public Adapter(Activity activity, List<Country> datalist) {
        this.activity = activity;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public Dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.layout_item,parent,false);
        return new Dataholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Dataholder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(activity).load(datalist.get(position).getFlags().getPng()).into(holder.flags);

        holder.country_name.setText(datalist.get(position).getName().getCommon());

        holder.flags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(activity, All_countryActivity.class);
                intent.putExtra("flags",position);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class Dataholder extends RecyclerView.ViewHolder {

        ImageView flags;
        TextView country_name;

        public Dataholder(@NonNull View itemView) {
            super(itemView);

            flags = itemView.findViewById(R.id.flags);

            country_name = itemView.findViewById(R.id.country_name);

        }
    }
}