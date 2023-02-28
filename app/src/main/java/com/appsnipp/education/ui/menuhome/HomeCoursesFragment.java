/*
 * Copyright (c) 2021. rogergcc
 */

package com.appsnipp.education.ui.menuhome;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.appsnipp.education.CameraActivity;
import com.appsnipp.education.CustomDialog;
import com.appsnipp.education.LoginActivity;
import com.appsnipp.education.PawFree;
import com.appsnipp.education.R;
import com.appsnipp.education.StatsActivity;
import com.appsnipp.education.WeekActivity;
import com.appsnipp.education.databinding.FragmentCoursesStaggedBinding;

public class HomeCoursesFragment extends Fragment {
    private Context mcontext;


    public HomeCoursesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mcontext = this.getContext();

        View v = inflater.inflate(R.layout.fragment_home_courses, container, false);

        ImageView b = (ImageView) v.findViewById(R.id.clickandsave);
        ImageView pawweek = (ImageView) v.findViewById(R.id.pawweek);
        ImageView pawfree = (ImageView) v.findViewById(R.id.pawFree);
        ImageView imag2 = (ImageView) v.findViewById(R.id.imag2);
        ImageView pawsure = (ImageView) v.findViewById(R.id.pawSure);

        TextView token = (TextView) v.findViewById(R.id.token);

// Retrieving the value using its
        //keys the file name// must be same in both saving and retrieving the dataSharedPreferences
        SharedPreferences sh = getActivity().getSharedPreferences("pref", MODE_PRIVATE);
        String s1 = sh.getString("name","$10");
        token.setText(s1);

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent= new Intent(mcontext, CameraActivity.class);
                mcontext.startActivity(intent);
            }
        });
        pawweek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext , WeekActivity.class);
                mcontext.startActivity(intent);
            }
        });
        pawfree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext , PawFree.class);
                mcontext.startActivity(intent);
            }
        });
        pawsure.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext , StatsActivity.class);
                mcontext.startActivity(intent);
            }
        }));

        LinearLayout refer = (LinearLayout) v.findViewById(R.id.refer);
        refer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = "Earn 20$ Cashback with the PawSure from StateFarm Insurance when you ensure your pet using my unique referral code";
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, message);

                startActivity(Intent.createChooser(share, "PawShare"));

            }
        });




        imag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog viewDialog = new CustomDialog();
                viewDialog.showDialog(mcontext);
            }
        });

        return v;

    }
}