package com.bemach.labguide;

/**
 * Created by ktran on 4/30/2015.
 */
public class UserCredential {
    private String password;
    private String[] roles;
    private String userId;

    public String getPassword() {
        return password;
    }

    public String[] getRoles() {
        return roles;
    }

    public String getUserId() {
        return userId;
    }

    private UserCredential(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public static UserCredential getInstance(String userId, String password) {
        return new UserCredential(userId, password);
    }
}
