package com.itheima.em.sdk.vo;

/**
 * 位置的geo信息
 *
 * @author zzj
 * @version 1.0
 * @date 2022/3/25
 */
public class GeoResult {

    private String address; //详情地址
    private String country; //国家
    private String province; //省
    private String city; //市
    private String district; //区
    private Coordinate location; //所在的经纬度
    private String data; //地图服务商返回的json数据

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Coordinate getLocation() {
        return location;
    }

    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GeoResult{");
        sb.append("address='").append(address).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", province='").append(province).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", district='").append(district).append('\'');
        sb.append(", location=").append(location);
        sb.append(", data='").append(data).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
