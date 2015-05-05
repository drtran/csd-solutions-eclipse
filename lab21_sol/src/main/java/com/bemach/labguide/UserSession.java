package com.bemach.labguide;

/**
 * Created by ktran on 5/3/2015.
 */
public class UserSession {
    private AuthenticationDTO userDTO;
    private String userId;

    public void setUserDTO(AuthenticationDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getUserId() {
        return userId;
    }
}
