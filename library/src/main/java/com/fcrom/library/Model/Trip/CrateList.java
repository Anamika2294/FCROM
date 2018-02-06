package com.fcrom.library.Model.Trip;

import java.io.Serializable;

/**
 * Created by anamika.chavan on 01-02-2018.
 */

public class CrateList implements Serializable {
    private String CrateId;
    private String ConsignmentId;
    private String PupId;
    private Boolean isscanned =false;

    public String getCrateId() {
        return CrateId;
    }

    public void setCrateId(String CrateId) {
        this.CrateId = CrateId;
    }

    public Boolean getIsscanned() {
        return isscanned;
        //return isscanned;
    }

    public void setIsscanned(Boolean isscanned) {
        this.isscanned = isscanned;
    }

    public String getConsignmentId() {
        return ConsignmentId;
    }

    public void setConsignmentId(String ConsignmentId) {
        this.ConsignmentId = ConsignmentId;
    }

    public String getPupId() {
        return PupId;
    }

    public void setPupId(String PupId) {
        this.PupId = PupId;
    }

    @Override
    public String toString() {
        return "CrateList{" +
                "CrateId='" + CrateId + '\'' +
                ", ConsignmentId='" + ConsignmentId + '\'' +
                ", PupId='" + PupId + '\'' +
                '}';
    }
}
