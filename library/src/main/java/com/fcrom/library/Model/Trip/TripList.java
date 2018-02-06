package com.fcrom.library.Model.Trip;

import java.io.Serializable;
import java.util.List;

/**
 * Created by anamika.chavan on 01-02-2018.
 */

public class TripList implements Serializable {
    private String TripId;
    private String DriverName;
    private String VehicleNumber;
    private String DriverPhone;
    private String Status;
    private List<CrateList> CrateList = null;

    public String getTripId() {
        return TripId;
    }

    public void setTripId(String TripId) {
        this.TripId = TripId;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String DriverName) {
        this.DriverName = DriverName;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String VehicleNumber) {
        this.VehicleNumber = VehicleNumber;
    }

    public String getDriverPhone() {
        return DriverPhone;
    }

    public void setDriverPhone(String DriverPhone) {
        this.DriverPhone = DriverPhone;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public List<CrateList> getCrateList() {
        return CrateList;
    }

    public void setCrateList(List<CrateList> CrateList) {
        this.CrateList = CrateList;
    }

    @Override
    public String toString() {
        return "TripList{" +
                "TripId='" + TripId + '\'' +
                ", DriverName='" + DriverName + '\'' +
                ", VehicleNumber='" + VehicleNumber + '\'' +
                ", DriverPhone='" + DriverPhone + '\'' +
                ", Status='" + Status + '\'' +
                ", CrateList=" + CrateList +
                '}';
    }
}
