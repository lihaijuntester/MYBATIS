package com.com.Enum;

/**
 * Created by arvin on 2018/1/16.
 */
public enum AddressEnum {
    Address0(1,"zhejiang123hao"),
    Address1(2,"zhejiang124hao"),
    Address2(3,"zhejiang125hao"),
    Address3(4,"zhejiang126hao");
    private int index;
    private String Address;

    AddressEnum(int index, String address) {
        this.index = index;
        Address = address;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
