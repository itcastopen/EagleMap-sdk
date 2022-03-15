package cn.itcast.em.sdk.vo;

import cn.hutool.core.util.CoordinateUtil;

public class CoordinateVo {

    private Double longitude; //经度
    private Double latitude; //纬度

    public CoordinateVo() {
    }

    public CoordinateVo(CoordinateUtil.Coordinate coordinate) {
        this.longitude = coordinate.getLng();
        this.latitude = coordinate.getLat();
    }

    public CoordinateVo(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * 将经纬度数据用逗号连接
     *
     * @return
     */
    public String toParam() {
        return longitude + "," + latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CoordinateVo{");
        sb.append("longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append('}');
        return sb.toString();
    }
}
