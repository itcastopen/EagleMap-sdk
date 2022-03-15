package cn.itcast.em.sdk.ops;

import cn.hutool.core.util.CoordinateUtil;
import cn.itcast.em.sdk.EagleMapTemplate;
import cn.itcast.em.sdk.enums.CoordinateType;
import cn.itcast.em.sdk.enums.ServerType;
import cn.itcast.em.sdk.vo.CoordinateVo;
import cn.itcast.em.sdk.vo.IpResultVo;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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
        IpResultVo ipResultVo = this.eagleMapTemplate
                .opsForBase().queryIp(ip);
        System.out.println(ipResultVo);
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
        CoordinateVo[] vos = new CoordinateVo[]{new CoordinateVo(116.350717, 40.066273),
                new CoordinateVo(116.336429, 40.072473)};
        List<CoordinateVo> coordinateVos = this.eagleMapTemplate.opsForBase().convertToGcj02(ServerType.BAIDU, CoordinateType.BAIDU, vos);
        // List<CoordinateVo> coordinateVos = this.eagleMapTemplate.opsForBase().baiduConvertToGcj02(vos);
        for (CoordinateVo coordinateVo : coordinateVos) {
            System.out.println(coordinateVo.toParam());
        }
    }

    @Test
    public void convert() {
        CoordinateVo vo = new CoordinateVo(116.350717, 40.066273);
        CoordinateVo convert = this.eagleMapTemplate.opsForBase()
                .convert(ServerType.BAIDU, CoordinateType.BAIDU, CoordinateType.AMAP, vo);
        System.out.println(convert.toParam());

        CoordinateVo vo2 = new CoordinateVo(116.34337,40.060448);
        CoordinateVo convert2 = this.eagleMapTemplate.opsForBase()
                .convert(ServerType.BAIDU, CoordinateType.AMAP, CoordinateType.BAIDU, vo2);
        System.out.println(convert2.toParam());
    }

}