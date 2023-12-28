package com.example.anaghafishapp.vendor;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.anaghafishapp.R;
import com.example.anaghafishapp.Useractivity.CartFragment;
import com.example.anaghafishapp.Useractivity.CategoryFragment;
import com.example.anaghafishapp.Useractivity.HomeFragment;
import com.example.anaghafishapp.Useractivity.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class VenderActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender);
        bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if (item.getItemId() == R.id.nav_home) {
                selectedFragment = new vendorhomefragment();
            } else if (item.getItemId() == R.id.nav_category) {
                selectedFragment = new vendorhistoryFragment();
            }
            else if (item.getItemId() == R.id.nav_profile) {
                selectedFragment = new vendorprofilefragment();
            }
            /*else if (item.getItemId() == R.id.nav_profile) {
                selectedFragment = new ProfileFragment();
            }*/

            loadFragment(selectedFragment);
            return true;
        });
// Set the default selected item
        bottomNavigation.setSelectedItemId(R.id.nav_home);
    }//----------on create end---------


    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

}