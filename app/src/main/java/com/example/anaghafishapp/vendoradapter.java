package com.example.anaghafishapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class vendoradapter extends FirebaseRecyclerAdapter<vendormodel, vendoradapter.myviewholder> {

    public vendoradapter(@NonNull FirebaseRecyclerOptions<vendormodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull vendormodel model) {
        if (model != null) {
            holder.phonetext.setText(model.getPhone_number());
            holder.fishtext.setText(model.getProduct_name());
            holder.nametext.setText(model.getVendor_name());
            holder.pricetext.setText(model.getPrice());

            // Load image using Glide if the image URL is not null
            if (model.getImage_url() != null && !model.getImage_url().isEmpty()) {
                Glide.with(holder.img1.getContext()).load(model.getImage_url()).into(holder.img1);
            } else {
                // Handle null or empty URL, e.g., load a placeholder image
                holder.img1.setImageResource(R.drawable.raw);
            }
        } else {
            // Handle the case where model is null (empty data)
            // For example, set default values or display an error message
            holder.phonetext.setText("");
            holder.fishtext.setText("");
            holder.nametext.setText("");
            holder.pricetext.setText("");
            holder.img1.setImageResource(R.drawable.raw);
        }
        Log.d("vendoradapter", "onBindViewHolder - position: " + position + ", model: " + model.toString());
    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to create the running view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_vendorlist, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView phonetext,fishtext, nametext, pricetext;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img1 = itemView.findViewById(R.id.img1);
            phonetext = itemView.findViewById(R.id.phonetext);
            pricetext = itemView.findViewById(R.id.pricetext);
            fishtext = itemView.findViewById(R.id.fishtext);
            nametext = itemView.findViewById(R.id.nametext);
        }
    }
}
