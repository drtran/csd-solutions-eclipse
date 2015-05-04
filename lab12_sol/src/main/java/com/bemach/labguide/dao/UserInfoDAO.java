package com.bemach.labguide.dao;

import com.bemach.labguide.UserInfo;

/**
 * Created by ktran on 4/30/2015.
 */
public interface UserInfoDAO {
    public boolean create(UserInfo userInfo);
    public UserInfo read(String userId);
    public boolean update(UserInfo oldUserInfo, UserInfo newUserInfo);
    public boolean delete(UserInfo userInfo);
}
