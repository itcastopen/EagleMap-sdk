package com.itheima.em.sdk.ops;

import com.itheima.em.sdk.EagleMapTemplate;
import com.itheima.em.sdk.enums.ProviderEnum;
import com.itheima.em.sdk.vo.Coordinate;
import org.junit.Before;
import org.junit.Test;

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
        Coordinate origin = new Coordinate(116.34411597643727, 40.06061915065967);
        Coordinate destination = new Coordinate(116.398704, 39.907539);
        String result = this.eagleMapTemplate.opsForDirection().driving(ProviderEnum.AMAP, origin, destination);
        System.out.println(result);
    }

    //步行路线规划
    @Test
    public void walking() {
        Coordinate origin = new Coordinate(116.34411597643727, 40.06061915065967);
        Coordinate destination = new Coordinate(116.398704, 39.907539);
        String result = this.eagleMapTemplate.opsForDirection().walking(ProviderEnum.AMAP, origin, destination);
        System.out.println(result);
    }

    //骑行路线规划
    @Test
    public void bicycling() {
        Coordinate origin = new Coordinate(116.34411597643727, 40.06061915065967);
        Coordinate destination = new Coordinate(116.398704, 39.907539);
        String result = this.eagleMapTemplate.opsForDirection().bicycling(ProviderEnum.AMAP, origin, destination);
        System.out.println(result);
    }
}