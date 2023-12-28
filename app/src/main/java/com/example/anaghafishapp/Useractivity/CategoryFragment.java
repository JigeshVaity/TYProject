package com.example.anaghafishapp.Useractivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.anaghafishapp.retrieve.Product;
import com.example.anaghafishapp.retrieve.ProductAdapter;
import com.example.anaghafishapp.retrieve.SelectedItemsViewModel;
import com.example.anaghafishapp.vendoradapter;
import com.google.firebase.FirebaseApp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anaghafishapp.Categorylist.CategoryBiryaniFragment;
import com.example.anaghafishapp.Categorylist.CategoryCurryFragment;
import com.example.anaghafishapp.Categorylist.CategoryFriedFragment;
import com.example.anaghafishapp.Categorylist.CategoryPickleFragment;
import com.example.anaghafishapp.Categorylist.CategoryRawFragment;
import com.example.anaghafishapp.Categorylist.CategoryFoodFragment;
import com.example.anaghafishapp.R;
import com.example.anaghafishapp.vendormodel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

    LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4,linearLayout5,linearLayout6;

    private ProductAdapter adapter;
    private List<Product> productList;
    RecyclerView recview;
   // vendoradapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        linearLayout1 = view.findViewById(R.id.linearLayout1);
        linearLayout2 = view.findViewById(R.id.linearLayout2);
        linearLayout3 = view.findViewById(R.id.linearLayout3);
        linearLayout4 = view.findViewById(R.id.linearLayout4);
        linearLayout5 = view.findViewById(R.id.linearLayout5);
        linearLayout6 = view.findViewById(R.id.linearLayout6);

        recview = (RecyclerView)view.findViewById(R.id.recview);

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment secondFrag = new CategoryRawFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,secondFrag).commit();
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment secondFrag = new CategoryFoodFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,secondFrag).commit();
            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment secondFrag = new CategoryFriedFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,secondFrag).commit();
            }
        });

        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment secondFrag = new CategoryCurryFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,secondFrag).commit();
            }
        });

        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment secondFrag = new CategoryBiryaniFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,secondFrag).commit();
            }
        });

        linearLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment secondFrag = new CategoryPickleFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,secondFrag).commit();
            }
        });


        //retrieve data
/*
        recview.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<vendormodel> options =
                new FirebaseRecyclerOptions.Builder<vendormodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("VendorName"), vendormodel.class)
                        .build();

        Log.d("MyTag", "Number of items in options: " + options.getSnapshots().size());
        adapter = new vendoradapter(options);
        recview.setAdapter(adapter);
*/
        SelectedItemsViewModel selectedItemsViewModel = new ViewModelProvider(this).get(SelectedItemsViewModel.class);

        // Initialize Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference productsRef = database.getReference("VendorName");

        // Initialize your RecyclerView and its adapter
        RecyclerView recyclerView = view.findViewById(R.id.recview);
        productList = new ArrayList<>();
        adapter = new ProductAdapter(productList , selectedItemsViewModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        productsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                productList.clear();
                for (DataSnapshot vendorSnapshot : dataSnapshot.getChildren()) {
                    for (DataSnapshot productSnapshot : vendorSnapshot.getChildren()) {
                        // Assuming that each product node has fields like "product_name", "vendor_name", "image_url", "price"
                        Product product = new Product();
                        product.setProductName(productSnapshot.child("product_name").getValue(String.class));
                        Log.d("name",productSnapshot.child("product_name").getValue(String.class));
                        product.setVendorName(productSnapshot.child("vendor_name").getValue(String.class));
                        product.setImageUrl(productSnapshot.child("image_url").getValue(String.class));
                        product.setPrice(productSnapshot.child("price").getValue(String.class));
                        productList.add(product);
                    }
                }
                // Now, you can use the productList to populate your UI or RecyclerView
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors here
                Log.e("FirebaseError", "Firebase Data Error: " + databaseError.getMessage());
            }
        });

        return view;
    }
/*
    @Override
    public void onStart()
    {
        super.onStart();
        try {
            adapter.startListening();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.d("CategoryFragment", "onStart - adapter.startListening()");
    }
    @Override
    public void onStop()
    {
        super.onStop();
        adapter.stopListening();
        Log.d("CategoryFragment", "onStop - adapter.stopListening()");
    }
*/
}
