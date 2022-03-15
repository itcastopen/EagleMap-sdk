package cn.itcast.em.sdk.ops;

import cn.itcast.em.sdk.EagleMapTemplate;
import cn.itcast.em.sdk.enums.ServerType;
import cn.itcast.em.sdk.vo.CoordinateVo;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/15
 */
public class DirectionOperationsTest {

    private EagleMapTemplate eagleMapTemplate;

    @Before
    public void init() {
        String host = "127.0.0.1";
        this.eagleMapTemplate = new EagleMapTemplate(host);
    }

    //驾车规划
    @Test
    public void driving() {
        CoordinateVo origin = new CoordinateVo(116.34411597643727, 40.06061915065967);
        CoordinateVo destination = new CoordinateVo(116.398704, 39.907539);
        String result = this.eagleMapTemplate.opsForDirection().driving(ServerType.AMAP, origin, destination);
        System.out.println(result);
    }

    //骑行路线规划
    @Test
    public void walking() {
        CoordinateVo origin = new CoordinateVo(116.34411597643727, 40.06061915065967);
        CoordinateVo destination = new CoordinateVo(116.398704, 39.907539);
        String result = this.eagleMapTemplate.opsForDirection().walking(ServerType.AMAP, origin, destination);
        System.out.println(result);
    }

    //骑行路线规划
    @Test
    public void bicycling() {
        CoordinateVo origin = new CoordinateVo(116.34411597643727, 40.06061915065967);
        CoordinateVo destination = new CoordinateVo(116.398704, 39.907539);
        String result = this.eagleMapTemplate.opsForDirection().bicycling(ServerType.AMAP, origin, destination);
        System.out.println(result);
    }
}