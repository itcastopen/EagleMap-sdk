package cn.itcast.em.sdk.ops;

import cn.itcast.em.sdk.EagleMapTemplate;
import cn.itcast.em.sdk.enums.CoordinateType;
import cn.itcast.em.sdk.enums.ServerType;
import cn.itcast.em.sdk.vo.Coordinate;
import cn.itcast.em.sdk.vo.IpResult;
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
        String ip = "114.242.26.45";
        IpResult ipResult = this.eagleMapTemplate
                .opsForBase().queryIp(ip);
        System.out.println(ipResult);
    }

    @Test
    public void staticMapImage() {
        Double longitude = 116.405285;
        Double latitude = 39.904989;
        // String result = this.eagleMapTemplate.opsForBase().staticMapImage(longitude, latitude);
        String result = this.eagleMapTemplate.opsForBase().staticMapImage(ServerType.BAIDU, longitude, latitude);
        System.out.println(result);
    }

    @Test
    public void convertToGcj02() {
        Coordinate[] vos = new Coordinate[]{new Coordinate(116.350717, 40.066273),
                new Coordinate(116.336429, 40.072473)};
        List<Coordinate> coordinates = this.eagleMapTemplate.opsForBase().convertToGcj02(ServerType.BAIDU, CoordinateType.BAIDU, vos);
        // List<CoordinateVo> coordinateVos = this.eagleMapTemplate.opsForBase().baiduConvertToGcj02(vos);
        for (Coordinate coordinate : coordinates) {
            System.out.println(coordinate.toParam());
        }
    }

    @Test
    public void convert() {
        Coordinate vo = new Coordinate(116.350717, 40.066273);
        Coordinate convert = this.eagleMapTemplate.opsForBase()
                .convert(ServerType.BAIDU, CoordinateType.BAIDU, CoordinateType.AMAP, vo);
        System.out.println(convert.toParam());

        Coordinate vo2 = new Coordinate(116.34337,40.060448);
        Coordinate convert2 = this.eagleMapTemplate.opsForBase()
                .convert(ServerType.BAIDU, CoordinateType.AMAP, CoordinateType.BAIDU, vo2);
        System.out.println(convert2.toParam());
    }

}