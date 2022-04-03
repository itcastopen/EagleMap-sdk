package com.itheima.em.sdk.ops;

import com.itheima.em.sdk.EagleMapTemplate;
import com.itheima.em.sdk.enums.ProviderEnum;
import com.itheima.em.sdk.vo.PageResult;
import com.itheima.em.sdk.vo.TraceFence;
import com.itheima.em.sdk.vo.TraceTerminal;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TraceFenceOperationsTest {


    private EagleMapTemplate eagleMapTemplate;

    @Before
    public void init() {
        String host = "127.0.0.1";
        this.eagleMapTemplate = new EagleMapTemplate(host);
    }

    //高德圆形围栏
    @Test
    public void createCircleFenceAmap() {
        Long serverId = 617418L;
        String name = "测试电子围栏1";
        String desc = "测试电子围栏1的描述";
        Map<String, Object> param = new HashMap<>();
        param.put("center", "116.344132,40.061937"); //中心点
        param.put("radius", 5000); //半径，单位：米
        Long fenceId = this.eagleMapTemplate.opsForTraceFence()
                .createCircleFence(ProviderEnum.AMAP, serverId, name, desc, param);
        System.out.println(fenceId);
    }

    //百度圆形围栏
    @Test
    public void createCircleFenceBaidu() {
        Long serverId = 231526L;
        String name = "测试电子围栏2";
        String desc = "测试电子围栏2的描述";
        Map<String, Object> param = new HashMap<>();
        param.put("longitude", "116.344132"); //中心点
        param.put("latitude", "40.061937"); //中心点
        param.put("radius", 5000); //半径，单位：米
        Long fenceId = this.eagleMapTemplate.opsForTraceFence()
                .createCircleFence(ProviderEnum.BAIDU, serverId, name, desc, param);
        System.out.println(fenceId);
    }

    //高德多边形围栏
    @Test
    public void createPolygonFenceAmap() {
        Long serverId = 617418L;
        String name = "高德多边形围栏1";
        String desc = "高德多边形围栏1的描述";
        Map<String, Object> param = new HashMap<>();
        param.put("points", "116.341622,40.063412;116.346729,40.064546;116.347072,40.060358;116.342373,40.059553"); //多边形的点
        Long fenceId = this.eagleMapTemplate.opsForTraceFence()
                .createPolygonFence(ProviderEnum.AMAP, serverId, name, desc, param);
        System.out.println(fenceId);
    }

    //百度多边形围栏
    @Test
    public void createPolygonFenceBaidu() {
        Long serverId = 231526L;
        String name = "百度多边形围栏1";
        String desc = "百度多边形围栏1的描述";
        Map<String, Object> param = new HashMap<>();
        param.put("vertexes", "40.063412,116.341622;40.064546,116.346729;40.060358,116.347072;40.059553,116.342373"); //多边形的点
        Long fenceId = this.eagleMapTemplate.opsForTraceFence()
                .createPolygonFence(ProviderEnum.BAIDU, serverId, name, desc, param);
        System.out.println(fenceId);
    }

    //高德线形围栏
    @Test
    public void createPolylineFenceAmap() {
        Long serverId = 617418L;
        String name = "高德线形围栏1";
        String desc = "高德线形围栏1的描述";
        Map<String, Object> param = new HashMap<>();
        param.put("points", "116.347115,40.060325;116.342909,40.05957;116.336493,40.058338"); //线形点
        param.put("bufferradius", 200);//沿线偏移距离，单位：米
        Long fenceId = this.eagleMapTemplate.opsForTraceFence()
                .createPolylineFence(ProviderEnum.AMAP, serverId, name, desc, param);
        System.out.println(fenceId);
    }

    //百度线形围栏
    @Test
    public void createPolylineFenceBaidu() {
        Long serverId = 231526L;
        String name = "百度线形围栏1";
        String desc = "百度线形围栏1的描述";
        Map<String, Object> param = new HashMap<>();
        param.put("vertexes", "40.060325,116.347115;40.05957,116.342909;40.058338,116.336493"); //线形点
        param.put("offset", 200);//沿线偏移距离，单位：米
        Long fenceId = this.eagleMapTemplate.opsForTraceFence()
                .createPolylineFence(ProviderEnum.BAIDU, serverId, name, desc, param);
        System.out.println(fenceId);
    }

    //高德行政区围栏
    @Test
    public void createDistrictFenceAmap() {
        Long serverId = 617418L;
        String name = "高德行政区围栏1";
        String desc = "高德行政区围栏1的描述";
        Map<String, Object> param = new HashMap<>();
        param.put("adcode", 110105); //行政区划编码
        Long fenceId = this.eagleMapTemplate.opsForTraceFence()
                .createDistrictFence(ProviderEnum.AMAP, serverId, name, desc, param);
        System.out.println(fenceId);
    }

    //百度行政区围栏
    @Test
    public void createDistrictFenceBaidu() {
        Long serverId = 231526L;
        String name = "百度行政区围栏1";
        String desc = "百度行政区围栏1的描述";
        Map<String, Object> param = new HashMap<>();
        param.put("keyword", "北京市"); //行政区名称
        Long fenceId = this.eagleMapTemplate.opsForTraceFence()
                .createDistrictFence(ProviderEnum.BAIDU, serverId, name, desc, param);
        System.out.println(fenceId);
    }

    //更新高德圆形围栏
    @Test
    public void updateCircleFenceAmap() {
        Long serverId = 617418L;
        Long fenceId = 589280L;
        String name = "测试电子围栏1";
        String desc = "测试电子围栏1的描述";
        Map<String, Object> param = new HashMap<>();
        param.put("center", "116.344132,40.061937"); //中心点
        param.put("radius", 5000); //半径，单位：米
        Boolean result = this.eagleMapTemplate.opsForTraceFence()
                .updateCircleFence(ProviderEnum.AMAP, serverId, fenceId, name, desc, param);
        System.out.println(result);
    }

    //更新百度圆形围栏
    @Test
    public void updateCircleFenceBaidu() {
        Long serverId = 231526L;
        Long fenceId = 7L;
        String name = "测试电子围栏2";
        String desc = "测试电子围栏2的描述";
        Map<String, Object> param = new HashMap<>();
        param.put("longitude", "116.344132"); //中心点
        param.put("latitude", "40.061937"); //中心点
        param.put("radius", 5000); //半径，单位：米
        Boolean result = this.eagleMapTemplate.opsForTraceFence()
                .updateCircleFence(ProviderEnum.BAIDU, serverId, fenceId, name, desc, param);
        System.out.println(result);
    }

    //高德多边形围栏
    @Test
    public void updatePolygonFenceAmap() {
        Long serverId = 617418L;
        Long fenceId = 587079L;
        String name = "高德多边形围栏1";
        String desc = "高德多边形围栏1的描述";
        Map<String, Object> param = new HashMap<>();
        param.put("points", "116.341622,40.063412;116.346729,40.064546;116.347072,40.060358;116.342373,40.059553"); //多边形的点
        Boolean result = this.eagleMapTemplate.opsForTraceFence()
                .updatePolygonFence(ProviderEnum.AMAP, serverId, fenceId, name, desc, param);
        System.out.println(result);
    }

    //百度多边形围栏
    @Test
    public void updatePolygonFenceBaidu() {
        Long serverId = 231526L;
        Long fenceId = 8L;
        String name = "百度多边形围栏1";
        String desc = "百度多边形围栏1的描述";
        Map<String, Object> param = new HashMap<>();
        param.put("vertexes", "40.063412,116.341622;40.064546,116.346729;40.060358,116.347072;40.059553,116.342373"); //多边形的点
        Boolean result = this.eagleMapTemplate.opsForTraceFence()
                .updatePolygonFence(ProviderEnum.BAIDU, serverId, fenceId, name, desc, param);
        System.out.println(result);
    }

    //高德线形围栏
    @Test
    public void updatePolylineFenceAmap() {
        Long serverId = 617418L;
        Long fenceId = 589360L;
        String name = "高德线形围栏1";
        String desc = "高德线形围栏1的描述";
        Map<String, Object> param = new HashMap<>();
        param.put("points", "116.347115,40.060325;116.342909,40.05957;116.336493,40.058338"); //线形点
        param.put("bufferradius", 200);//沿线偏移距离，单位：米
        Boolean result = this.eagleMapTemplate.opsForTraceFence()
                .updatePolylineFence(ProviderEnum.AMAP, serverId, fenceId, name, desc, param);
        System.out.println(result);
    }

    //百度线形围栏
    @Test
    public void updatePolylineFenceBaidu() {
        Long serverId = 231526L;
        Long fenceId = 9L;
        String name = "百度线形围栏1";
        String desc = "百度线形围栏1的描述";
        Map<String, Object> param = new HashMap<>();
        param.put("vertexes", "40.060325,116.347115;40.05957,116.342909;40.058338,116.336493"); //线形点
        param.put("offset", 200);//沿线偏移距离，单位：米
        Boolean result = this.eagleMapTemplate.opsForTraceFence()
                .updatePolylineFence(ProviderEnum.BAIDU, serverId, fenceId, name, desc, param);
        System.out.println(result);
    }

    //高德行政区围栏
    @Test
    public void updateDistrictFenceAmap() {
        Long serverId = 617418L;
        Long fenceId = 589380L;
        String name = "高德行政区围栏1";
        String desc = "高德行政区围栏1的描述";
        Map<String, Object> param = new HashMap<>();
        param.put("adcode", 110000); //行政区划编码
        Boolean result = this.eagleMapTemplate.opsForTraceFence()
                .updateDistrictFence(ProviderEnum.AMAP, serverId, fenceId, name, desc, param);
        System.out.println(result);
    }

    //百度行政区围栏
    @Test
    public void updateDistrictFenceBaidu() {
        Long serverId = 231526L;
        Long fenceId = 10L;
        String name = "百度行政区围栏1";
        String desc = "百度行政区围栏1的描述";
        Map<String, Object> param = new HashMap<>();
        param.put("keyword", "北京市"); //行政区名称
        Boolean result = this.eagleMapTemplate.opsForTraceFence()
                .updateDistrictFence(ProviderEnum.BAIDU, serverId, fenceId, name, desc, param);
        System.out.println(result);
    }

    //高德删除
    @Test
    public void deleteFenceAmap() {
        Long serverId = 617418L;
        Long fenceId = 588679L;
        Boolean result = this.eagleMapTemplate.opsForTraceFence()
                .deleteFence(ProviderEnum.AMAP, serverId, fenceId);
        System.out.println(result);
    }

    //百度删除
    @Test
    public void deleteFenceBaidu() {
        Long serverId = 231526L;
        Long fenceId = 10L;
        Boolean result = this.eagleMapTemplate.opsForTraceFence()
                .deleteFence(ProviderEnum.BAIDU, serverId, fenceId);
        System.out.println(result);
    }

    //将终端加入电子围栏中-高德
    @Test
    public void bindTerminalFenceAmap() {
        Long serverId = 617418L;
        Long fenceId = 589380L;
        Long[] terminalIds = new Long[]{492666422L, 492731778L};
        Boolean result = this.eagleMapTemplate.opsForTraceFence()
                .bindTerminalFence(ProviderEnum.AMAP, serverId, fenceId, terminalIds);
        System.out.println(result);
    }

    //将终端加入电子围栏中-百度
    @Test
    public void bindTerminalFenceBaidu() {
        Long serverId = 231526L;
        Long fenceId = 11L;
        Long[] terminalIds = new Long[]{1501743673574510592L};
        Boolean result = this.eagleMapTemplate.opsForTraceFence()
                .bindTerminalFence(ProviderEnum.BAIDU, serverId, fenceId, terminalIds);
        System.out.println(result);
    }

    //解绑电子围栏中的终端-高德
    @Test
    public void unbindTerminalFenceAmap() {
        Long serverId = 617418L;
        Long fenceId = 589380L;
        Long[] terminalIds = new Long[]{492666422L, 492731778L};
        Boolean result = this.eagleMapTemplate.opsForTraceFence()
                .unbindTerminalFence(ProviderEnum.AMAP, serverId, fenceId, terminalIds);
        System.out.println(result);
    }

    //解绑电子围栏中的终端-百度
    @Test
    public void unbindTerminalFenceBaidu() {
        Long serverId = 231526L;
        Long fenceId = 11L;
        Long[] terminalIds = new Long[]{1501743673574510592L};
        Boolean result = this.eagleMapTemplate.opsForTraceFence()
                .unbindTerminalFence(ProviderEnum.BAIDU, serverId, fenceId, terminalIds);
        System.out.println(result);
    }

    //查询围栏中的终端 - 高德
    @Test
    public void queryTerminalFenceListAmap() {
        Long serverId = 617418L;
        Long fenceId = 589380L;
        PageResult<TraceTerminal> pageResult = this.eagleMapTemplate.opsForTraceFence()
                .queryTerminalFenceList(ProviderEnum.AMAP, serverId, fenceId, 1, 10);
        System.out.println(pageResult);
    }

    //查询围栏中的终端 - 百度
    @Test
    public void queryTerminalFenceListBaidu() {
        Long serverId = 231526L;
        Long fenceId = 11L;
        PageResult<TraceTerminal> pageResult = this.eagleMapTemplate.opsForTraceFence()
                .queryTerminalFenceList(ProviderEnum.BAIDU, serverId, fenceId, 1, 10);
        System.out.println(pageResult);
    }

    @Test
    public void queryFenceList() {  //分页查询围栏列表
        PageResult<TraceFence> pageResult = this.eagleMapTemplate.opsForTraceFence()
                .queryFenceList(ProviderEnum.BAIDU, 1, 2);
        System.out.println(pageResult);
        System.out.println("-----------");

        PageResult<TraceFence> pageResult2 = this.eagleMapTemplate.opsForTraceFence()
                .queryFenceList(ProviderEnum.AMAP, 1, 2);
        System.out.println(pageResult2);
    }

    @Test
    public void queryByFenceIdAmap() { //根据围栏id查询围栏信息
        Long serverId = 617418L;
        Long fenceId = 589380L;
        TraceFence traceFence = this.eagleMapTemplate.opsForTraceFence()
                .queryByFenceId(ProviderEnum.AMAP, serverId, fenceId);
        System.out.println(traceFence);
    }

    @Test
    public void queryByFenceIdBaidu() { //根据围栏id查询围栏信息
        Long serverId = 231526L;
        Long fenceId = 11L;
        TraceFence traceFence = this.eagleMapTemplate.opsForTraceFence()
                .queryByFenceId(ProviderEnum.BAIDU, serverId, fenceId);
        System.out.println(traceFence);
    }

    @Test
    public void queryTerminalStatus() { //查询终端在围栏中的状态
        Long serverId = 617418L;
        Long fenceId = 589380L;
        Long terminalId = 492666422L;
        Boolean result = this.eagleMapTemplate.opsForTraceFence()
                .queryTerminalStatus(ProviderEnum.AMAP, serverId, fenceId, terminalId);
        System.out.println(result);
    }
}