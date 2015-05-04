package com.bemach.labguide;

import java.sql.Date;

/**
 * Created by ktran on 4/30/2015.
 */
public class UserProfile {
    private String profileName;
    private String type;
    private char typeCode;
    private String servicingSite;
    private String modiferUserId;
    private Date modifiedDate;

    public String getProfileName() {
        return profileName;
    }

    public String getType() {
        return type;
    }

    public char getTypeCode() {
        return typeCode;
    }

    public String getServicingSite() {
        return servicingSite;
    }

    public String getModiferUserId() {
        return modiferUserId;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }
}
