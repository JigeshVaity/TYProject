package com.example.anaghafishapp.retrieve;



import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anaghafishapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private final List<Product> productList;

    private final SelectedItemsViewModel selectedItemsViewModel;

    public ProductAdapter(List<Product> productList, SelectedItemsViewModel selectedItemsViewModel) {
        this.productList = productList;
        this.selectedItemsViewModel = selectedItemsViewModel;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        // Bind the data to the ViewHolder views
        holder.productNameTextView.setText(product.getProductName());
//        holder.vendorNameTextView.setText(product.getVendorName());
        // Load image using a library like Picasso or Glide
        Picasso.get().load(product.getImageUrl()).into(holder.imageView);
//        holder.phoneNumberTextView.setText(product.getPhoneNumber());
        holder.priceTextView.setText(product.getPrice());

        holder.atcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected product

                Product selectedProduct = productList.get(holder.getAdapterPosition());

                Log.d("ProductAdapter", "Button Clicked " + selectedProduct.getProductName());
                // Get the current selected items list from the ViewModel
                List<Product> currentSelectedItems = selectedItemsViewModel.getSelectedItems().getValue();

                if (currentSelectedItems == null) {
                    currentSelectedItems = new ArrayList<>();
                }
                // Add the selected product to the list (if not null)
                currentSelectedItems.add(selectedProduct);

                Log.d("total items", currentSelectedItems.toString());
                // Update the selected items list in the ViewModel
                selectedItemsViewModel.setSelectedItems(currentSelectedItems);

                Toast.makeText(v.getContext(), "Item added to cart " + currentSelectedItems, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView productNameTextView;
        public TextView vendorNameTextView;
        public ImageView imageView;
        public TextView phoneNumberTextView;
        public TextView priceTextView;
        public Button atcButton;


        public ProductViewHolder(View itemView) {
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.productName);
//            vendorNameTextView = itemView.findViewById(R.id.vendor_name);
            imageView = itemView.findViewById(R.id.productImage);
//            phoneNumberTextView = itemView.findViewById(R.id.phone_number);
            priceTextView = itemView.findViewById(R.id.productPrice);

            atcButton = itemView.findViewById(R.id.addToCartButton);
        }
    }
}

