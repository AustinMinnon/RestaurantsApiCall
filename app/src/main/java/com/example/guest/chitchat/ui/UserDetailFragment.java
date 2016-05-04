package com.example.guest.chitchat.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.guest.chitchat.R;
import com.example.guest.chitchat.models.User;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserDetailFragment extends Fragment {
    @Bind(R.id.nameTextView) TextView mNameTextView;
    @Bind(R.id.emailTextView) TextView mEmailTextView;
    private User mUser;

    public static UserDetailFragment newInstance(User user){
        UserDetailFragment userDetailFragment= new UserDetailFragment();
        Bundle args= new Bundle();
        args.putParcelable("user", Parcels.wrap(user));
        userDetailFragment.setArguments(args);
        return userDetailFragment;
        }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mUser= Parcels.unwrap(getArguments().getParcelable("user"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_detail, container, false);
        ButterKnife.bind(this, view);

        mNameTextView.setText(mUser.getName());
        mEmailTextView.setText(mUser.getEmail());
        return view;
    }
}
