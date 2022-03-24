package cn.itcast.em.sdk.enums;

public enum ProviderEnum {

    BAIDU(1, "BAIDU"), AMAP(2, "AMAP"), NONE(999, "NONE");

    private int value;
    private String name;

    ProviderEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}