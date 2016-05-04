package com.example.guest.chitchat.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.guest.chitchat.R;
import com.example.guest.chitchat.models.User;
import com.example.guest.chitchat.ui.UserDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserViewHolder extends RecyclerView.ViewHolder{
    @Bind(R.id.userTextView) TextView mUserTextView;
    @Bind(R.id.emailTextView) TextView mEmailTextView;

    private Context mContext;
    private ArrayList<User> mUsers = new ArrayList<>();

    public UserViewHolder(View itemView, ArrayList<User> users){
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mUsers = users;
        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, UserDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("users", Parcels.wrap(mUsers));
                mContext.startActivity(intent);
            }
        });
    }
        public void bindUser(User user){
        mEmailTextView.setText(user.getEmail());
        mUserTextView.setText(user.getName());
    }
}
