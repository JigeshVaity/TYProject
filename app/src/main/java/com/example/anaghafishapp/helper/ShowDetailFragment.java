// ShowDetailFragment.java
package com.example.anaghafishapp.helper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.example.anaghafishapp.Domain.FoodDomain;
import com.example.anaghafishapp.R;

public class ShowDetailFragment extends Fragment {
    private TextView addToCartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt, totalPriceTxt, starTxt, caloryTxt, timeTxt;
    private ImageView plusBtn, minusBtn, picFood;
    private FoodDomain object;
    private int numberOrder = 1;
    private ManagementCart managementCart;

    private static final String ARG_FOOD_DOMAIN = "food_domain";

    public ShowDetailFragment() {
        // Required empty public constructor
    }

    public static ShowDetailFragment newInstance(FoodDomain foodDomain) {
        ShowDetailFragment fragment = new ShowDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_FOOD_DOMAIN, foodDomain);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        managementCart = new ManagementCart(requireContext()); // Initialize the managementCart
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_detail, container, false);
        initView(view);
        getBundle();
        return view;
    }

    private void getBundle() {
        Bundle args = getArguments();
        if (args != null) {
            object = (FoodDomain) args.getSerializable(ARG_FOOD_DOMAIN);
            if (object != null) {
               // int drawableResourceId = getResources().getIdentifier(object.getPic(), "drawable", requireContext().getPackageName);
                int drawableResourceId = getResources().getIdentifier(object.getPic(), "drawable", requireContext().getPackageName());


                Glide.with(this)
                        .load(drawableResourceId)
                        .into(picFood);

                titleTxt.setText(object.getTitle());

                if (object.getFee() != null) {
                    feeTxt.setText("₹ " + object.getFee());
                } else {
                    feeTxt.setText("Price not available");
                }

                descriptionTxt.setText(object.getDescription());
                numberOrderTxt.setText(String.valueOf(numberOrder));
                caloryTxt.setText(object.getCalories() + " Calories");
                starTxt.setText(String.valueOf(object.getStar()));
                timeTxt.setText(object.getTime() + " minutes");

                // Calculate and set the initial total price
                double initialTotalPrice = numberOrder * (object.getFee() != null ? object.getFee() : 0);
                totalPriceTxt.setText(String.valueOf(initialTotalPrice));
            }
        }
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOrder > 1) {
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText(String.valueOf(numberOrder * object.getFee()));
            }
        });
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder = numberOrder + 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText(String.valueOf(numberOrder * (object.getFee() != null ? object.getFee() : 0)));
            }
        });

        // Similar logic for the minus button...

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your logic to add the item to the cart...
                object.setNumberInCart(numberOrder);
                managementCart.insertFood(object);
            }
        });
    }

    private void initView(View view) {
        // Initialize your views here...
        addToCartBtn = view.findViewById(R.id.addToCartBtn);
        titleTxt = view.findViewById(R.id.titleTxt);
        feeTxt = view.findViewById(R.id.priceTxt);
        descriptionTxt = view.findViewById(R.id.descriptionTxt);
        numberOrderTxt = view.findViewById(R.id.numberItemTxt);
        plusBtn = view.findViewById(R.id.plusCartBtn);
        minusBtn = view.findViewById(R.id.minusCartBtn);
        picFood = view.findViewById(R.id.foodPic);
        totalPriceTxt = view.findViewById(R.id.totalPriceTxt);
        starTxt = view.findViewById(R.id.starTxt);
        caloryTxt = view.findViewById(R.id.caloriesTxt);
        timeTxt = view.findViewById(R.id.timeTxt);
    }
}
