package com.example.anaghafishapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class AdvertisementAdapter extends PagerAdapter {
    private Context context;
    private int[] advertisementImages = {R.drawable.adv4, R.drawable.adv2, R.drawable.adv1};

    public AdvertisementAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return advertisementImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.advertisement_item, container, false);

        // Customize the view for each advertisement image if needed

        // Set the image for the advertisement
        // Assuming you have an ImageView in your advertisement_item.xml layout
        // and its ID is advertisementImageView
        ImageView imageView = view.findViewById(R.id.advertisementImageView);
        imageView.setImageResource(advertisementImages[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

