package com.bemach.labguide;

import java.sql.Date;
import java.util.List;

/**
 * Created by ktran on 5/1/2015.
 */
public interface UserService {
    public boolean changeOwnPassword(LoginUser loginUser, String oldPass, String newPass);
    public boolean changeOthersPassword(LoginUser loginUser, String userId, String loginPass, String newPass);
    public List<UserInfo> searchUsers(LoginUser loginUser, String userId, String title, String activeProfile, String role,
                                      Date pswStartDate, Date pswEndDate, Date acctStartDate, Date acctEndDate);
    public UserInfo getAccountInfo(LoginUser loginUser);
    public void updateUserStatus(LoginUser loginUser, String userId, String status);
    public void massUpdateUserStatus(LoginUser loginUser, List<String> userId, String status);
    public void deleteUser(LoginUser loginUser, String userId);
    public void massDeleteUser(LoginUser loginUser, List<String> userIds);
    public boolean createNewUser(LoginUser loginUser, UserInfo newAccountInfo);
    public void modifyUser(LoginUser loginUser, UserInfo accountInfo);
    public void cloneUser(LoginUser loginUser, String sourceUserId, UserInfo accountInfo, List<String> profileList);
}
