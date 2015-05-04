package com.bemach.labguide.dao;

import com.bemach.labguide.UserInfo;

/**
 * Created by ktran on 5/2/2015.
 */
public class UserInfoDAOImpl implements UserInfoDAO {
    public boolean create(UserInfo userInfo) {
        return false;
    }

    public UserInfo read(String userId) {
        return null;
    }

    public boolean update(UserInfo oldUserInfo, UserInfo newUserInfo) {
        return false;
    }

    public boolean delete(UserInfo userInfo) {
        return false;
    }

    public static UserInfoDAO getInstance() {
        return new UserInfoDAOImpl();
    }
}
