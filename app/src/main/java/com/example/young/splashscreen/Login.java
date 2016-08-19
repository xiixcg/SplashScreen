package com.example.young.splashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button loginButton;
    EditText usernameEditText, passwordEditText;
    TextView registerTextView;
    UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.login_button);
        usernameEditText = (EditText) findViewById(R.id.username_edit_text);
        passwordEditText = (EditText) findViewById(R.id.password_edit_text);
        registerTextView = (TextView) findViewById(R.id.register_text_view) ;

        userLocalStore = new UserLocalStore(this);
        try {
            loginButton.setOnClickListener(this);
            registerTextView.setOnClickListener(this);
        }
        catch (Exception e){

        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_button:

                User user = new User (null, null);

                userLocalStore.storeUserData(user);
                userLocalStore.setUserLoggedIn(true);
                startActivity(new Intent(this, MainActivity.class));

                break;
            case R.id.register_text_view:
                startActivity(new Intent(this,Register.class));

                break;
        }
    }
}
