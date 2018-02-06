package com.fcrom.library.Model;

/**
 * Created by Nitish.Gaikwad on 12-12-2016.
 */

public class LoginResponse {
    private String ActivateFlag;
    private String LocaleCode;
    private String LoginID;
    private String OrganizationCode;
    private String PWDLastChangedOn;
    private String Password;
    private String UserGroupID;
    private String UserGroupDescription;
    private String UserGroupKey;
    private String UserGroupName;
    private String UserName;
    private String UserKey;
    private String OrganizationName;

    public String getActivateFlag() {
        return ActivateFlag;
    }

    public void setActivateFlag(String ActivateFlag) {
        this.ActivateFlag = ActivateFlag;
    }

    public String getLocaleCode() {
        return LocaleCode;
    }

    public void setLocaleCode(String LocaleCode) {
        this.LocaleCode = LocaleCode;
    }

    public String getLoginID() {
        return LoginID;
    }

    public void setLoginID(String LoginID) {
        this.LoginID = LoginID;
    }

    public String getOrganizationCode() {
        return OrganizationCode;
    }

    public void setOrganizationCode(String OrganizationCode) {
        this.OrganizationCode = OrganizationCode;
    }

    public String getPWDLastChangedOn() {
        return PWDLastChangedOn;
    }

    public void setPWDLastChangedOn(String PWDLastChangedOn) {
        this.PWDLastChangedOn = PWDLastChangedOn;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUserGroupID() {
        return UserGroupID;
    }

    public void setUserGroupID(String UserGroupID) {
        this.UserGroupID = UserGroupID;
    }

    public String getUserGroupDescription() {
        return UserGroupDescription;
    }

    public void setUserGroupDescription(String UserGroupDescription) {
        this.UserGroupDescription = UserGroupDescription;
    }

    public String getUserGroupKey() {
        return UserGroupKey;
    }

    public void setUserGroupKey(String UserGroupKey) {
        this.UserGroupKey = UserGroupKey;
    }

    public String getUserGroupName() {
        return UserGroupName;
    }

    public void setUserGroupName(String UserGroupName) {
        this.UserGroupName = UserGroupName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserKey() {
        return UserKey;
    }

    public void setUserKey(String UserKey) {
        this.UserKey = UserKey;
    }

    public String getOrganizationName() {
        return OrganizationName;
    }

    public void setOrganizationName(String organizationName) {
        OrganizationName = organizationName;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "ActivateFlag='" + ActivateFlag + '\'' +
                ", LocaleCode='" + LocaleCode + '\'' +
                ", LoginID='" + LoginID + '\'' +
                ", OrganizationCode='" + OrganizationCode + '\'' +
                ", PWDLastChangedOn='" + PWDLastChangedOn + '\'' +
                ", Password='" + Password + '\'' +
                ", UserGroupID='" + UserGroupID + '\'' +
                ", UserGroupDescription='" + UserGroupDescription + '\'' +
                ", UserGroupKey='" + UserGroupKey + '\'' +
                ", UserGroupName='" + UserGroupName + '\'' +
                ", UserName='" + UserName + '\'' +
                ", UserKey='" + UserKey + '\'' +
                ", OrganizationName='" + OrganizationName + '\'' +
                '}';
    }
}
