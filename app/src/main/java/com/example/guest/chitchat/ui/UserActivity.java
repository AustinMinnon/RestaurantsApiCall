package com.example.guest.chitchat.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.guest.chitchat.Constants;
import com.example.guest.chitchat.R;
import com.example.guest.chitchat.adapters.FirebaseUserListAdapter;
import com.example.guest.chitchat.models.User;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private Query mQuery;
    private Firebase mFirebaseUserRef;
    private FirebaseUserListAdapter mAdapter;
    public ArrayList<User> mUsers = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        mFirebaseUserRef = new Firebase(Constants.FIREBASE_URL_USERS);

        setUpFirebaseQuery();
        setUpRecyclerView();
    }

    private void setUpFirebaseQuery(){
        String user = mFirebaseUserRef.toString();
        mQuery = new Firebase(user);
    }
    private void setUpRecyclerView(){
        mAdapter = new FirebaseUserListAdapter(mQuery, User.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}
