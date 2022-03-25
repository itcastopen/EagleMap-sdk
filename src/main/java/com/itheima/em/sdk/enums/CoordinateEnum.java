package com.itheima.em.sdk.enums;

public enum CoordinateEnum {

    BAIDU("百度(bd09ll)"),
    AMAP("高德(gcj02)"),
    QQ("腾讯(gcj02)"),
    GPS("wgs84"),
    SOU_GOU("搜狗");

    private String name;

    CoordinateEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

