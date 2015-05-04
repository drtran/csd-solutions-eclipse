package com.bemach.labguide;

import java.sql.Date;
import java.util.List;

/**
 * Created by ktran on 4/30/2015.
 */
public interface LoginService {
    public LoginUser login(UserCredential userCredential);
    public void logout(LoginUser loginUser);

}
