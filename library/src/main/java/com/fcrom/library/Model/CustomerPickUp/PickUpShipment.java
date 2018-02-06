package com.fcrom.library.Model.CustomerPickUp;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Nitish.Gaikwad on 30-01-2017.
 */

public class PickUpShipment implements Serializable {


    private String CustName;
    private String CustEmail;
    private String PhNO;
    private String ShipmentNo;
    private String ShipmentKey;
    private String OrderNo;
    private String OrderHeaderKey;
    private String TimeSlot;
    private String TotalItems;
    private String TotalQuantity;
    private String PayType;
    private String TotalAmount;
    private String OrderPickupOTP;
    private String HasShortPick;


    private List<OrderLine> OrderLines = null;

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String CustName) {
        this.CustName = CustName;
    }

    public String getCustEmail() {
        return CustEmail;
    }

    public void setCustEmail(String CustEmail) {
        this.CustEmail = CustEmail;
    }

    public String getPhNO() {
        return PhNO;
    }

    public void setPhNO(String PhNO) {
        this.PhNO = PhNO;
    }

    public String getShipmentNo() {
        return ShipmentNo;
    }

    public void setShipmentNo(String ShipmentNo) {
        this.ShipmentNo = ShipmentNo;
    }

    public String getShipmentKey() {
        return ShipmentKey;
    }

    public void setShipmentKey(String ShipmentKey) {
        this.ShipmentKey = ShipmentKey;
    }

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String OrderNo) {
        this.OrderNo = OrderNo;
    }

    public String getOrderHeaderKey() {
        return OrderHeaderKey;
    }

    public void setOrderHeaderKey(String OrderHeaderKey) {
        this.OrderHeaderKey = OrderHeaderKey;
    }

    public String getTimeSlot() {
        return TimeSlot;
    }

    public void setTimeSlot(String TimeSlot) {
        this.TimeSlot = TimeSlot;
    }

    public String getTotalItems() {
        return TotalItems;
    }

    public void setTotalItems(String TotalItems) {
        this.TotalItems = TotalItems;
    }

    public String getTotalQuantity() {
        return TotalQuantity;
    }

    public void setTotalQuantity(String TotalQuantity) {
        this.TotalQuantity = TotalQuantity;
    }

    public String getPayType() {
        return PayType;
    }

    public void setPayType(String PayType) {
        this.PayType = PayType;
    }

    public String getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(String TotalAmount) {
        this.TotalAmount = TotalAmount;
    }

    public List<OrderLine> getOrderLines() {
        return OrderLines;
    }

    public void setOrderLines(List<OrderLine> OrderLines) {
        this.OrderLines = OrderLines;
    }

    public String getOrderPickupOTP() {
        return OrderPickupOTP;
    }

    public void setOrderPickupOTP(String orderPickupOTP) {
        OrderPickupOTP = orderPickupOTP;
    }

    public String getHasShortPick() {
        return HasShortPick;
    }

    public void setHasShortPick(String hasShortPick) {
        HasShortPick = hasShortPick;
    }

    @Override
    public String toString() {
        return "PickUpShipment{" +
                "CustName='" + CustName + '\'' +
                ", CustEmail='" + CustEmail + '\'' +
                ", PhNO='" + PhNO + '\'' +
                ", ShipmentNo='" + ShipmentNo + '\'' +
                ", ShipmentKey='" + ShipmentKey + '\'' +
                ", OrderNo='" + OrderNo + '\'' +
                ", OrderHeaderKey='" + OrderHeaderKey + '\'' +
                ", TimeSlot='" + TimeSlot + '\'' +
                ", TotalItems='" + TotalItems + '\'' +
                ", TotalQuantity='" + TotalQuantity + '\'' +
                ", PayType='" + PayType + '\'' +
                ", TotalAmount='" + TotalAmount + '\'' +
                ", OrderPickupOTP='" + OrderPickupOTP + '\'' +
                ", HasShortPick='" + HasShortPick + '\'' +
                ", OrderLines=" + OrderLines +
                '}';
    }
}
