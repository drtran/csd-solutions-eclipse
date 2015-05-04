package com.bemach.labguide;

import com.bemach.labguide.dao.UserInfoDAO;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by ktran on 4/30/2015.
 *
 * AccountInfo is retrieved from a database.
 *
 */
public class UserInfo implements Serializable {
    private static ServiceLocator svcLoc = ServiceLocatorFactory.getInstance().getServiceLocator();
    private UserCredential userCredential;
    private String title;
    private String fullName;
    private String activeProfile;
    private Date accountExpirationDate;
    private Date passwordExpirationDate;
    private String officeCode;
    private Boolean accountEnabled;
    private Boolean loginDisabled;
    private SecurityQA[] securityQAs;
    private UserRole currentRole;
    private UserProfile currentProfile;
    private ArrayList<UserRole> permittedRoles;
    private ArrayList<UserProfile> personalProfiles;

    //audit information
    private Date lastLogin;
    private Date createdByDate;
    private String createdByUserId;

    public UserCredential getUserCredential() {
        return userCredential;
    }

    public String getTitle() {
        return title;
    }

    public String getFullName() {
        return fullName;
    }

    public String getActiveProfile() {
        return activeProfile;
    }

    public Date getAccountExpirationDate() {
        return accountExpirationDate;
    }

    public Date getPasswordExpirationDate() {
        return passwordExpirationDate;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public Boolean getAccountEnabled() {
        return accountEnabled;
    }

    public Boolean getLoginDisabled() {
        return loginDisabled;
    }

    public SecurityQA[] getSecurityQAs() {
        return securityQAs;
    }

    public UserRole getCurrentRole() {
        return currentRole;
    }

    public UserProfile getCurrentProfile() {
        return currentProfile;
    }

    public ArrayList<UserRole> getPermittedRoles() {
        return permittedRoles;
    }

    public ArrayList<UserProfile> getPersonalProfiles() {
        return personalProfiles;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public Date getCreatedByDate() {
        return createdByDate;
    }

    public String getCreatedByUserId() {
        return createdByUserId;
    }

    public Boolean isNil() {
        return userCredential == null;
    }

    public static UserInfo getInstance(UserCredential userCredential) {
        UserInfoDAO dao = svcLoc.getUserInfoDAO(userCredential);
        return dao.read(userCredential.getUserId());
    }

    /**
     * I am making this as a package-access. outside of this package no acccess
     * is allowed.
     *
     * @param userCredential
     * @param title
     */
    UserInfo(UserCredential userCredential, String title, String fullName,
             String activeProfile, Date accountExpirationDate, Date passwordExpirationDate,
             String officeCode, Boolean accountEnabled, Boolean loginDisabled,
             SecurityQA[] securityQAs, UserRole currentRole, UserProfile currentProfile,
             ArrayList<UserRole> permittedRoles, ArrayList<UserProfile> personalProfiles,
             Date lastLogin, Date createdByDate, String createdByUserId) {
        this.accountEnabled = accountEnabled;
        this.accountExpirationDate = accountExpirationDate;
        this.activeProfile = activeProfile;
        this.createdByDate = createdByDate;
        this.createdByUserId = createdByUserId;
        this.currentProfile = currentProfile;
        this.currentRole = currentRole;
        this.fullName = fullName;
        this.lastLogin = lastLogin;
        this.loginDisabled = loginDisabled;
        this.officeCode = officeCode;
        this.passwordExpirationDate = passwordExpirationDate;
        this.permittedRoles = permittedRoles;
        this.personalProfiles = personalProfiles;
        this.securityQAs = securityQAs;
        this.title = title;
        this.userCredential = userCredential;
    }

}
