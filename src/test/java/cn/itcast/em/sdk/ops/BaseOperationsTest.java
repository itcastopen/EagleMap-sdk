package cn.itcast.em.sdk.ops;

import cn.itcast.em.sdk.EagleMapTemplate;
import cn.itcast.em.sdk.enums.ServerType;
import cn.itcast.em.sdk.vo.IpResultVo;
import org.junit.Before;
import org.junit.Test;

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

}