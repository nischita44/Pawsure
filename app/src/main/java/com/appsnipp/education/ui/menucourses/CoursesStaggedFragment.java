/*
 * Copyright (c) 2021. rogergcc
 */

package com.appsnipp.education.ui.menucourses;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.appsnipp.education.CameraActivity;
import com.appsnipp.education.PetRegistrationActivity;
import com.appsnipp.education.R;
import com.appsnipp.education.databinding.FragmentCoursesStaggedBinding;
import com.appsnipp.education.ui.helpers.GridSpacingItemDecoration;
import com.appsnipp.education.ui.listeners.CoursesItemClickListener;
import com.appsnipp.education.ui.model.CourseCard;

import java.util.ArrayList;


public class CoursesStaggedFragment extends Fragment
        implements CoursesItemClickListener {

    FragmentCoursesStaggedBinding binding;
    private Context mcontext;
    private ArrayList<CourseCard> courseCards;
    private CourseRecyclerAdapter adapter;

    public CoursesStaggedFragment() {
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
//        return inflater.inflate(R.layout.fragment_courses_stagged, container, false);

        binding = FragmentCoursesStaggedBinding.inflate(getLayoutInflater());
        mcontext = this.getContext();
        View view = binding.getRoot();


        binding.edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    //For this example only use seach option
                    //U can use a other view with activityresult
                    performSearch();
                    Toast.makeText(mcontext,
                            "Edt Searching Click: " + binding.edtSearch.getText().toString().trim(),
                            Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        StaggeredGridLayoutManager layoutManager =
                new StaggeredGridLayoutManager(
                        2,
                        StaggeredGridLayoutManager.VERTICAL);

        binding.rvCourses.setLayoutManager(
                layoutManager
        );
        binding.rvCourses.setClipToPadding(false);
        binding.rvCourses.setHasFixedSize(true);

//        binding.rvCourses.addItemDecoration(
//                new HorizontalMarginItemDecoration(
//                        mcontext,
//                        R.dimen.top_text_subtitle_card,
//                        R.dimen.top_text_subtitle_card
//                )
//        );

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.horizontal_card);
        binding.rvCourses.addItemDecoration(new GridSpacingItemDecoration(2, spacingInPixels, true, 0));

        courseCards = new ArrayList<>();

        courseCards.add(new CourseCard(1, R.drawable.pet7, "Add your Pet", "Insurance"));
        courseCards.add(new CourseCard(2, R.drawable.twodogs, "Add your 2nd pet", "5% OFF/-"));
        courseCards.add(new CourseCard(3, R.drawable.otherservices, "Other Services", ""));


        adapter = new CourseRecyclerAdapter(mcontext, courseCards, this);

//        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.card_margin);
//        binding.rvCourses.addItemDecoration(new SpacesItemDecoration(spacingInPixels));

        binding.rvCourses.setAdapter(adapter);
        return view;
    }

    private void performSearch() {
        binding.edtSearch.clearFocus();
        InputMethodManager in = (InputMethodManager) mcontext.getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(binding.edtSearch.getWindowToken(), 0);
        //...perform search
    }

    @Override
    public void onDashboardCourseClick(CourseCard courseCard, ImageView imageView) {
        if(courseCard.getCourseTitle().equals("Add your Pet") || courseCard.getCourseTitle().equals("Add your 2nd pet")){
            Intent intent= new Intent(mcontext, PetRegistrationActivity.class);
            mcontext.startActivity(intent);

        }else if(courseCard.getCourseTitle().equals("Other Services")){
            Toast.makeText(mcontext,
                    "In Progress...",
                    Toast.LENGTH_SHORT).show();
        }
    }
}