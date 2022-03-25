package com.itheima.em.sdk.enums;

public enum FenceEnum {

    CIRCLE(1, "圆形围栏"), POLYGON(2, "多边形围栏"), POLYLINE(3, "线形围栏"),
    DISTRICT(4, "行政区");

    private int value;
    private String desc;

    FenceEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
