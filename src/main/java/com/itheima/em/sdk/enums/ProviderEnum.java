package com.itheima.em.sdk.enums;

public enum ProviderEnum {

    BAIDU(1, "BAIDU", "百度地图"),
    AMAP(2, "AMAP", "高德地图"),
    QQ(3, "QQ", "腾讯地图"),
    NONE(999, "NONE", "默认地图");

    private int value;
    private String name;
    private String desc;

    ProviderEnum(int value, String name, String desc) {
        this.value = value;
        this.name = name;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
