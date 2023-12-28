package com.example.anaghafishapp.vendor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.anaghafishapp.R;
import com.example.anaghafishapp.loginActivity;
import com.example.anaghafishapp.otplogin.entermobilenumberone1;
import com.google.firebase.auth.FirebaseAuth;

public class vendorprofilefragment extends Fragment {
    private FirebaseAuth mAuth;

    // Declare the parameters for the fragment
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Parameters for the fragment
    private String mParam1;
    private String mParam2;

    public vendorprofilefragment() {
        // Required empty public constructor
    }

    public static vendorprofilefragment newInstance(String param1, String param2) {
        vendorprofilefragment fragment = new vendorprofilefragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

        // Check for arguments if needed
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Check if mAuth is not null before using it
        if (mAuth != null) {
            view.findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAuth.signOut();
                    Intent intent = new Intent(getActivity(), entermobilenumberone1.class);
                    startActivity(intent);

                    // Use getActivity() instead of requireActivity() for consistency
                    if (getActivity() != null) {
                        getActivity().finish();
                    }
                }
            });
        }

        return view;
    }
}
