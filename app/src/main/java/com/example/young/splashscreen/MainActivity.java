package com.example.young.splashscreen;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView emailTextView, usernameTextView;
    Button loginButton, logoutButton;
    UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailTextView = (TextView)findViewById(R.id.email_text_view);
        usernameTextView = (TextView)findViewById(R.id.username_text_view);

        loginButton = (Button)findViewById(R.id.login_button);
        logoutButton = (Button)findViewById(R.id.logout_button);

        userLocalStore = new UserLocalStore(this);

        try{
            loginButton.setOnClickListener(this);
            logoutButton.setOnClickListener(this);
        }
        catch (Exception e){

        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(authenticate() == true){
            displayUserDetails();

        }

    }

    private boolean authenticate(){
        return userLocalStore.getUserLoggedIn();
    }

    private void displayUserDetails(){
        User user = userLocalStore.getLoggedInUser();
        emailTextView.setText(user.emailAddress);
        usernameTextView.setText(user.username);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_button:
                startActivity(new Intent(this, Login.class));

                break;
            case R.id.logout_button:
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);
                startActivity(new Intent(this, Login.class));


                break;
        }

    }
}
