package com.bemach.labguide;

import com.bemach.labguide.dao.UserInfoDAO;

/**
 * Created by ktran on 5/2/2015.
 */
public interface ServiceLocator {
    public LoginService getLoginService();
    public LoginUser getLoginUser(UserCredential userCredential);
    public UserInfoDAO getUserInfoDAO(UserCredential userCredential);
}
