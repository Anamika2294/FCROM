package com.fcrom.library.Model;

/**
 * Created by Nitish.Gaikwad on 12-12-2016.
 */

public class LoginBody {

    private String UserId;
    private String Password;
    private String IMEI;
    private String IMSI;
    private String EnterpriseCode = "AEL";

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getIMSI() {
        return IMSI;
    }

    public void setIMSI(String IMSI) {
        this.IMSI = IMSI;
    }

    public String getEnterpriseCode() {
        return EnterpriseCode;
    }

    public void setEnterpriseCode(String EnterpriseCode) {
        this.EnterpriseCode = EnterpriseCode;
    }

    @Override
    public String toString() {
        return "LoginBody{" +
                "UserId='" + UserId + '\'' +
                ", Password='" + Password + '\'' +
                ", IMEI='" + IMEI + '\'' +
                ", IMSI='" + IMSI + '\'' +
                ", EnterpriseCode='" + EnterpriseCode + '\'' +
                '}';
    }
}

