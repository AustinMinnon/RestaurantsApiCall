package com.example.guest.chitchat.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.guest.chitchat.Constants;
import com.example.guest.chitchat.R;
import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.contactsButton) Button mContactsButton;
    private Firebase mFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
        ButterKnife.bind(this);
        mContactsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v == mContactsButton){
            Intent intent = new Intent(MainActivity.this, UserActivity.class);
            startActivity(intent);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void takeUserToLoginScreenOnUnAuth(){
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
    protected void logout() {
        mFirebaseRef.unauth();
        takeUserToLoginScreenOnUnAuth();
    }
}
