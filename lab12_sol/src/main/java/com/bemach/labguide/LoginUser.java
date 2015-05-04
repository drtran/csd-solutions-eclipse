package com.bemach.labguide;

import java.sql.Date;

/**
 * Created by ktran on 4/30/2015.
 *
 * Note that this class is from a legacy system and it can be refactored
 * to provide better services to its application.
 *
 * AccountUser is runtime object that contains live information for an
 * actively logged on user.
 *
 */
public class LoginUser {
    private UserInfo userInfo;
    private String userIp;
    private int loginCounter;
    private Date loginDate;
    private UserProfile activeUserProfile;

    private UserInfo selectedUserInfo;
    private UserProfile selectedProfile;
    private UserProfile selectedGlobalProfile;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public String getUserIp() {
        return userIp;
    }

    public int getLoginCounter() {
        return loginCounter;
    }

    public UserInfo getSelectedUser() {
        return selectedUserInfo;
    }

    public UserProfile getSelectedProfile() {
        return selectedProfile;
    }

    public UserProfile getActiveUserProfile() {
        return activeUserProfile;
    }

    public UserProfile getSelectedGlobalProfile() {
        return selectedGlobalProfile;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public static LoginUser getInstance(UserCredential userCredential) {
        LoginUser loginUser = new LoginUser();
        return loginUser;
    }
    public Boolean isNil() {
        return userInfo == null;
    }
}
