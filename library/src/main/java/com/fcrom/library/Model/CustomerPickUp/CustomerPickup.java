package com.fcrom.library.Model.CustomerPickUp;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Nitish.Gaikwad on 18-01-2017.
 */

public class CustomerPickup implements Serializable {
    boolean SplitPaymentEnabled;
    boolean OTPEnabled;
    boolean CSDEnabled;

    private List<PickUpShipment> PickUpShipments = null;

    public List<PickUpShipment> getPickUpShipments() {
        return PickUpShipments;
    }

    public void setPickUpShipments(List<PickUpShipment> pickUpShipments) {
        this.PickUpShipments = pickUpShipments;
    }

    public boolean isSplitPaymentEnabled() {
        return SplitPaymentEnabled;
    }

    public void setSplitPaymentEnabled(boolean splitPaymentEnabled) {
        SplitPaymentEnabled = splitPaymentEnabled;
    }

    public boolean isOTPEnabled() {
        return OTPEnabled;
    }

    public void setOTPEnabled(boolean OTPEnabled) {
        this.OTPEnabled = OTPEnabled;
    }

    public boolean isCSDEnabled() {
        return CSDEnabled;
    }

    public void setCSDEnabled(boolean CSDEnabled) {
        this.CSDEnabled = CSDEnabled;
    }

    @Override
    public String toString() {
        return "CustomerPickup{" +
                "SplitPaymentEnabled=" + SplitPaymentEnabled +
                ", OTPEnabled=" + OTPEnabled +
                ", CSDEnabled=" + CSDEnabled +
                ", PickUpShipments=" + PickUpShipments +
                '}';
    }
}
