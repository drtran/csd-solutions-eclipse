package com.bemach.labguide.dao;

import com.bemach.labguide.LoginUser;

/**
 * Created by ktran on 4/30/2015.
 *
 * Basic CRUD operations.
 *
 */
public interface LoginUserDAO {
    public boolean create(LoginUser loginUser);
    public LoginUser read(String userId);
    public boolean update(LoginUser oldLoginUser, LoginUser newLoginUser);
    public boolean delete(LoginUser loginUser);
}
