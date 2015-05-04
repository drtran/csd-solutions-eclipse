package com.bemach.labguide;

import com.bemach.labguide.dao.UserInfoDAO;

/**
 * Created by ktran on 5/2/2015.
 */
public class ServiceLocatorImpl implements ServiceLocator{
    public LoginService getLoginService() {
        return null;
    }

    public LoginUser getLoginUser(UserCredential userCredential) {
        return LoginUser.getInstance(userCredential);
    }

    public UserInfoDAO getUserInfoDAO(UserCredential userCredential) {
        return null;
    }
}
