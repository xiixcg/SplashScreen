package com.example.young.splashscreen;

/**
 * Created by Young on 8/18/2016.
 * User class to store email, user name, password
 */
public class User {
    String emailAddress, username, password;

    public User (String emailAddress, String username, String password){
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
    }
    public User (String emailAddress, String password){
        int i = password.indexOf('@');
        this.emailAddress = emailAddress;
        this.username = password.substring(0,i);
        this.password = password;
    }
}
