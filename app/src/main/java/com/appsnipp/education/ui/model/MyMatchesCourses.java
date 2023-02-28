/*
 * Copyright (c) 2020. rogergcc
 */

package com.appsnipp.education.ui.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.appsnipp.education.App;
import com.appsnipp.education.R;

import java.util.Arrays;
import java.util.List;


public class MyMatchesCourses {

    private static final String STORAGE = "shop";
    private SharedPreferences storage;

    private MyMatchesCourses() {
        storage = App.getInstance().getSharedPreferences(STORAGE, Context.MODE_PRIVATE);
    }

    public static MyMatchesCourses get() {
        return new MyMatchesCourses();
    }

    public List<MatchCourse> getData() {
        return Arrays.asList(
//                new MatchCourse(1, "Everyday Candle", "$12.00 USD", R.drawable.shop1),
//                new MatchCourse(2, "Small Porcelain Bowl", "$50.00 USD", R.drawable.shop2),
//                new MatchCourse(3, "Favourite Board", "$265.00 USD", R.drawable.shop3),
//                new MatchCourse(4, "Earthenware Bowl", "$18.00 USD", R.drawable.shop4),
//                new MatchCourse(5, "Porcelain Dessert Plate", "$36.00 USD", R.drawable.shop5),
//                new MatchCourse(6, "Detailed Rolling Pin", "$145.00 USD", R.drawable.shop6)
                new MatchCourse(1, "Contact Us", "", R.drawable.call2),
                new MatchCourse(2, "Vet Appointments", "", R.drawable.clinic2)

        );
    }

    public boolean isRated(int itemId) {
        return storage.getBoolean(String.valueOf(itemId), false);
    }

    public void setRated(int itemId, boolean isRated) {
        storage.edit().putBoolean(String.valueOf(itemId), isRated).apply();
    }
}
