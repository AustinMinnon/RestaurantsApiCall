package com.example.guest.chitchat.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.guest.chitchat.models.User;
import com.example.guest.chitchat.ui.UserDetailFragment;

import java.util.ArrayList;

public class UserPagerAdapter extends FragmentPagerAdapter{
    private ArrayList<User> mUsers;

    public UserPagerAdapter(FragmentManager fm, ArrayList<User> users){
        super(fm);
        mUsers = users;
    }

    @Override
    public Fragment getItem(int position){
        return UserDetailFragment.newInstance(mUsers.get(position));
    }

    @Override
    public int getCount(){
        return mUsers.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mUsers.get(position).getName();
    }

}
