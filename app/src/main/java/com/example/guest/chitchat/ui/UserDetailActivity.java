package com.example.guest.chitchat.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guest.chitchat.R;
import com.example.guest.chitchat.adapters.UserPagerAdapter;
import com.example.guest.chitchat.models.User;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager)
    ViewPager mViewPager;
    private UserPagerAdapter adapterViewPager;
    ArrayList<User> mUsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);
        mUsers = Parcels.unwrap(getIntent().getParcelableExtra("users"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new UserPagerAdapter(getSupportFragmentManager(), mUsers);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
