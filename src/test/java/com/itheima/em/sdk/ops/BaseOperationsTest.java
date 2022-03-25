package com.itheima.em.sdk.ops;

import com.itheima.em.sdk.EagleMapTemplate;
import com.itheima.em.sdk.enums.CoordinateEnum;
import com.itheima.em.sdk.enums.ProviderEnum;
import com.itheima.em.sdk.vo.Coordinate;
import com.itheima.em.sdk.vo.GeoResult;
import com.itheima.em.sdk.vo.IpResult;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/15
 */
public class BaseOperationsTest {

    private EagleMapTemplate eagleMapTemplate;

    @Before
    public void init() {
        String host = "127.0.0.1";
        this.eagleMapTemplate = new EagleMapTemplate(host);
    }

    @Test
    public void queryIp() {
        String ip = "115.47.143.145";
        IpResult ipResult = this.eagleMapTemplate
                .opsForBase().queryIp(ip);
        System.out.println(ipResult);
    }

    @Test
    public void staticMapImage() {
        Double longitude = 116.405285;
        Double latitude = 39.904989;
        // String result = this.eagleMapTemplate.opsForBase().staticMapImage(longitude, latitude);
        String result = this.eagleMapTemplate.opsForBase().staticMapImage(ProviderEnum.BAIDU, longitude, latitude);
        System.out.println(result);
    }

    @Test
    public void convertToGcj02() {
        Coordinate[] vos = new Coordinate[]{new Coordinate(116.350717, 40.066273),
                new Coordinate(116.336429, 40.072473)};
        List<Coordinate> coordinates = this.eagleMapTemplate.opsForBase().convertToGcj02(ProviderEnum.BAIDU, CoordinateEnum.BAIDU, vos);
        // List<CoordinateVo> coordinateVos = this.eagleMapTemplate.opsForBase().baiduConvertToGcj02(vos);
        for (Coordinate coordinate : coordinates) {
            System.out.println(coordinate.toParam());
        }
    }

    @Test
    public void convert() {
        Coordinate vo = new Coordinate(116.350717, 40.066273);
        Coordinate convert = this.eagleMapTemplate.opsForBase()
                .convert(ProviderEnum.BAIDU, CoordinateEnum.BAIDU, CoordinateEnum.AMAP, vo);
        System.out.println(convert.toParam());

        Coordinate vo2 = new Coordinate(116.34337, 40.060448);
        Coordinate convert2 = this.eagleMapTemplate.opsForBase()
                .convert(ProviderEnum.BAIDU, CoordinateEnum.AMAP, CoordinateEnum.BAIDU, vo2);
        System.out.println(convert2.toParam());
    }

    @Test
    public void test() {
        Coordinate coordinate = this.eagleMapTemplate.opsForBase()
                .bd09ToGcj02(116.350717, 40.066273);
        System.out.println(coordinate);
        //116.343847,40.060539
    }

    @Test
    public void geoCode() {
        String address = "北京市龙旗广场";
        GeoResult geoResult = this.eagleMapTemplate.opsForBase()
                .geoCode(ProviderEnum.AMAP, address, null);
        System.out.println(geoResult);
    }

    @Test
    public void geoDecode() {
        GeoResult geoResult = this.eagleMapTemplate.opsForBase()
                .geoDecode(ProviderEnum.BAIDU, 116.346566,40.066852, null);
        System.out.println(geoResult);
    }

}