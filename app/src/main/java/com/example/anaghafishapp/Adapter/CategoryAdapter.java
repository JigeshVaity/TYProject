package com.example.anaghafishapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.anaghafishapp.Domain.CategoryDomain;
import com.example.anaghafishapp.Categorylist.CategoryBiryaniFragment;
import com.example.anaghafishapp.Categorylist.CategoryCurryFragment;
import com.example.anaghafishapp.Categorylist.CategoryDiscountFragment;
import com.example.anaghafishapp.Categorylist.CategoryFoodFragment;
import com.example.anaghafishapp.Categorylist.CategoryFriedFragment;
import com.example.anaghafishapp.Categorylist.CategoryPickleFragment;
import com.example.anaghafishapp.Categorylist.CategoryRawFragment;
import com.example.anaghafishapp.R;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private ArrayList<CategoryDomain> categoryDomains;
    private Context context;


    public CategoryAdapter(Context context,ArrayList<CategoryDomain> categoryDomains) {
        this.context = context;
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryDomain category = categoryDomains.get(holder.getAdapterPosition());

        holder.categoryName.setText(category.getTitle());

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(String.valueOf(category.getPic()), "drawable", holder.itemView.getContext().getPackageName());

        // Resize the image using Glide
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .centerInside()
                .into(holder.categoryPic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                switch (position) {
                    case 0:
                        // Navigate to the PracticeFragment
                        navigateToCategoryRawFragment();
                        break;
                    case 1:
                        // Navigate to another fragment based on position 1
                        navigateToCategoryFoodFragment();
                        break;
                    case 2:
                        // Navigate to another fragment based on position 2
                        navigateToCategoryFriedFragment();
                        break;
                    case 3:
                        // Navigate to another fragment based on position 3
                        navigateToCategoryCurryFragment();
                        break;
                    case 4:
                        // Navigate to another fragment based on position 3
                        navigateToCategoryBiryaniFragment();
                        break;
                    case 5:
                        // Navigate to another fragment based on position 3
                        navigateToCategoryPickleFragment();
                        break;
                    case 6:
                        navigateToCategoryDiscountFragment();
                    default:
                        // Handle the default case or navigate to a default fragment
                        break;
                }
            }

        });
    }


    private void navigateToCategoryRawFragment() {
        // Create an instance of the PracticeFragment
        CategoryRawFragment practiceFragment = new CategoryRawFragment();

        // Get the FragmentManager and start a new FragmentTransaction
        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the current fragment with the PracticeFragment
        fragmentTransaction.replace(R.id.fragment_container, practiceFragment);

        // Add the transaction to the back stack (optional)
        fragmentTransaction.addToBackStack(null);

        // Commit the transaction
        fragmentTransaction.commit();
    }
    private void navigateToCategoryFoodFragment() {
        // Create an instance of the CategoryFoodFragment
        CategoryFoodFragment foodFragment = new CategoryFoodFragment(); // Replace with the actual fragment you want to navigate to

        // Get the FragmentManager and start a new FragmentTransaction
        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the current fragment with the CategoryFoodFragment
        fragmentTransaction.replace(R.id.fragment_container, foodFragment);

        // Add the transaction to the back stack (optional)
        fragmentTransaction.addToBackStack(null);

        // Commit the transaction
        fragmentTransaction.commit();
    }
    private void navigateToCategoryFriedFragment() {
        // Create an instance of the CategoryFriedFragment
        CategoryFriedFragment friedFragment = new CategoryFriedFragment(); // Replace with the actual fragment you want to navigate to

        // Get the FragmentManager and start a new FragmentTransaction
        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the current fragment with the CategoryFriedFragment
        fragmentTransaction.replace(R.id.fragment_container, friedFragment);

        // Add the transaction to the back stack (optional)
        fragmentTransaction.addToBackStack(null);

        // Commit the transaction
        fragmentTransaction.commit();
    }

    private void navigateToCategoryCurryFragment() {
        // Create an instance of the CategoryCurryFragment
        CategoryCurryFragment curryFragment = new CategoryCurryFragment(); // Replace with the actual fragment you want to navigate to

        // Get the FragmentManager and start a new FragmentTransaction
        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the current fragment with the CategoryCurryFragment
        fragmentTransaction.replace(R.id.fragment_container, curryFragment);

        // Add the transaction to the back stack (optional)
        fragmentTransaction.addToBackStack(null);

        // Commit the transaction
        fragmentTransaction.commit();
    }
    private void navigateToCategoryBiryaniFragment() {
        // Create an instance of the CategoryCurryFragment
        CategoryBiryaniFragment biryaniFragment = new CategoryBiryaniFragment(); // Replace with the actual fragment you want to navigate to

        // Get the FragmentManager and start a new FragmentTransaction
        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the current fragment with the CategoryCurryFragment
        fragmentTransaction.replace(R.id.fragment_container, biryaniFragment);

        // Add the transaction to the back stack (optional)
        fragmentTransaction.addToBackStack(null);

        // Commit the transaction
        fragmentTransaction.commit();
    }
    private void navigateToCategoryPickleFragment() {
        // Create an instance of the CategoryCurryFragment
        CategoryPickleFragment pickleFragment = new CategoryPickleFragment(); // Replace with the actual fragment you want to navigate to

        // Get the FragmentManager and start a new FragmentTransaction
        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the current fragment with the CategoryCurryFragment
        fragmentTransaction.replace(R.id.fragment_container, pickleFragment);

        // Add the transaction to the back stack (optional)
        fragmentTransaction.addToBackStack(null);

        // Commit the transaction
        fragmentTransaction.commit();
    }
    private void navigateToCategoryDiscountFragment() {
        // Create an instance of the CategoryCurryFragment
        CategoryDiscountFragment discountFragment = new CategoryDiscountFragment(); // Replace with the actual fragment you want to navigate to

        // Get the FragmentManager and start a new FragmentTransaction
        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the current fragment with the CategoryCurryFragment
        fragmentTransaction.replace(R.id.fragment_container, discountFragment);

        // Add the transaction to the back stack (optional)
        fragmentTransaction.addToBackStack(null);

        // Commit the transaction
        fragmentTransaction.commit();
    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView categoryPic;
        public TextView categoryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            categoryName = itemView.findViewById(R.id.categoryName);
        }
    }
}
