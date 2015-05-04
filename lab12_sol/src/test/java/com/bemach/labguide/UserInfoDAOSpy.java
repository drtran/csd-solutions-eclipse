package com.bemach.labguide;

import com.bemach.labguide.dao.UserInfoDAO;

/**
 * Created by ktran on 5/2/2015.
 */
public class UserInfoDAOSpy implements UserInfoDAO {
    private String userId = null;
    private UserInfo mockUserInfo;

    public void setMockUserInfo(UserInfo mockUserInfo) {
        this.mockUserInfo = mockUserInfo;
    }

    public UserInfo getMockUserInfo() {
        return mockUserInfo;
    }

    public String getUserId() {
        return userId;
    }

    public boolean create(UserInfo userInfo) {
        return false;
    }

    public UserInfo read(String userId) {
        this.userId = userId;
        return this.mockUserInfo;
    }

    public boolean update(UserInfo oldUserInfo, UserInfo newUserInfo) {
        return false;
    }

    public boolean delete(UserInfo userInfo) {
        return false;
    }
}
