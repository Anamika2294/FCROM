package com.fcrom.library.Model.CustomerPickUp;

import java.io.Serializable;

/**
 * Created by Nitish.Gaikwad on 30-01-2017.
 */

public class OrderLine implements Serializable {
    private String ItemID;
    private String ItemName;
    private String LineTotal;
    private String ExtendedPrice;
    private String Discount;
    private String UnitPrice;
    private String UnitSellingPrice;
    private String OrderQuantity;
    private String OriginalOrderQuantity;
    private String CustomePickQuantity;
    private String EANno;
    private String ShipmentLineKey;
    private String PrimeLineNo;
    private String ShortageResolutionReason;


    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getLineTotal() {
        return LineTotal;
    }

    public void setLineTotal(String LineTotal) {
        this.LineTotal = LineTotal;
    }

    public String getExtendedPrice() {
        return ExtendedPrice;
    }

    public void setExtendedPrice(String ExtendedPrice) {
        this.ExtendedPrice = ExtendedPrice;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String Discount) {
        this.Discount = Discount;
    }

    public String getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(String UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public String getUnitSellingPrice() {
        return UnitSellingPrice;
    }

    public void setUnitSellingPrice(String unitSellingPrice) {
        UnitSellingPrice = unitSellingPrice;
    }

    public String getOrderQuantity() {
        return OrderQuantity;
    }

    public void setOrderQuantity(String OrderQuantity) {

        this.OrderQuantity = OrderQuantity;
    }

    public String getEANno() {
        return EANno;
    }

    public void setEANno(String EANno) {
        this.EANno = EANno;
    }

    public String getShipmentLineKey() {
        return ShipmentLineKey;
    }

    public void setShipmentLineKey(String ShipmentLineKey) {
        this.ShipmentLineKey = ShipmentLineKey;
    }

    public String getCustomePickQuantity() {
        return CustomePickQuantity;
    }

    public void setCustomePickQuantity(String customePickQuantity) {
        this.CustomePickQuantity = customePickQuantity;
    }

    public String getPrimeLineNo() {
        return PrimeLineNo;
    }

    public void setPrimeLineNo(String primeLineNo) {
        PrimeLineNo = primeLineNo;
    }

    public String getShortageResolutionReason() {
        return ShortageResolutionReason;
    }

    public void setShortageResolutionReason(String shortageResolutionReason) {
        ShortageResolutionReason = shortageResolutionReason;
    }

    public String getOriginalOrderQuantity() {
        return OriginalOrderQuantity;
    }

    public void setOriginalOrderQuantity(String originalOrderQuantity) {
        OriginalOrderQuantity = originalOrderQuantity;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "ItemID='" + ItemID + '\'' +
                ", ItemName='" + ItemName + '\'' +
                ", LineTotal='" + LineTotal + '\'' +
                ", ExtendedPrice='" + ExtendedPrice + '\'' +
                ", Discount='" + Discount + '\'' +
                ", UnitPrice='" + UnitPrice + '\'' +
                ", UnitSellingPrice='" + UnitSellingPrice + '\'' +
                ", OrderQuantity='" + OrderQuantity + '\'' +
                ", OriginalOrderQuantity='" + OriginalOrderQuantity + '\'' +
                ", CustomePickQuantity='" + CustomePickQuantity + '\'' +
                ", EANno='" + EANno + '\'' +
                ", ShipmentLineKey='" + ShipmentLineKey + '\'' +
                ", PrimeLineNo='" + PrimeLineNo + '\'' +
                ", ShortageResolutionReason='" + ShortageResolutionReason + '\'' +
                '}';
    }
}
